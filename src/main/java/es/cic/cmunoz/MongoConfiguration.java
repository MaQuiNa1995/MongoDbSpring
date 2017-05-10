package es.cic.cmunoz;

import com.mongodb.Mongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {Main.class})
@PropertySource("classpath:application.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "PruebasSpring";
    }

    @Override
    public Mongo mongo() throws Exception {
//                return new Mongo(new ArrayList<ServerAddress>() {
//            {
//                add(new ServerAddress("127.0.0.1", 27017));
//                add(new ServerAddress("127.0.0.1", 27027));
//                add(new ServerAddress("127.0.0.1", 27037));
//            }
//        });
         return new Mongo("localhost", 27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "es.cic.cmunoz.backend.dominio";
    }

}
