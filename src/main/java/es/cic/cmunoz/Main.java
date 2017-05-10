package es.cic.cmunoz;

import es.cic.cmunoz.backend.dominio.Curvas;
import es.cic.cmunoz.backend.repository.CurvasRepository;
import es.cic.cmunoz.backend.util.Utilidades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("MongoDemo application");

        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfiguration.class);

        CurvasRepository personRepository = context.getBean(CurvasRepository.class);
        Utilidades utilidades = context.getBean(Utilidades.class);

        
        
        Curvas curva = new Curvas(0, "sdf", 0, "dfgdf", utilidades.generarValores(), utilidades.generarFlags());
        personRepository.save(curva);




        LOGGER.info("MongoDemo application");
    }
}
