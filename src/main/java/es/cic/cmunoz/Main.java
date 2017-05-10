package es.cic.cmunoz;

import es.cic.cmunoz.backend.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("MongoDemo application");

        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfiguration.class);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        // cleanup person collection before insertion
        personRepository.dropPersonCollection();

        //create person collection
        personRepository.createPersonCollection();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            personRepository.insertPersonWithNameJohnathan(Math.ceil(Math.random() * 100));
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info("Load Took " + (endTime - startTime) / 1000 + " seconds");


        startTime = System.currentTimeMillis();
        personRepository.countAllPersons();
        endTime = System.currentTimeMillis();
        LOGGER.info("Count All Took " + (endTime - startTime)  / 1000 + " seconds");


        /***
         *
         * Added Under Age Test For someone to see
         *
         */
        startTime = System.currentTimeMillis();
        personRepository.countUnderAge();
        endTime = System.currentTimeMillis();
        LOGGER.info("Under age search Took " + (endTime - startTime) / 1000 + " seconds");




        LOGGER.info("MongoDemo application");
    }
}
