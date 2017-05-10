package es.cic.cmunoz;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {Main.class})
@PropertySource("classpath:application.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongodb.name}")
    private String nombreBaseDatos;

    @Value("${mongodb.host}")
    private String servidor;

    @Value("${mongodb.port}")
    private Integer puerto;

    @Value("${mongodb.username}")
    private String usuario;

    @Value("${mongodb.password}")
    private String contrasenna;

    @Override
    protected String getDatabaseName() {
        return this.nombreBaseDatos;
    }

    @Override
    public MongoClient mongo() throws Exception {
//                return new Mongo(new ArrayList<ServerAddress>() {
//            {
//                add(new ServerAddress("127.0.0.1", 27017));
//                add(new ServerAddress("127.0.0.1", 27027));
//                add(new ServerAddress("127.0.0.1", 27037));
//            }
//        });

//        Resource resource = new ClassPathResource("/application.properties");
//        Properties props = PropertiesLoaderUtils.loadProperties(resource);
//
//        MongoCredential credential = MongoCredential.createCredential(
//                props.getProperty("spring.data.mongodb.username"),
//                getDatabaseName(),
//                props.getProperty("spring.data.mongodb.password").toCharArray());
        MongoClient client = new MongoClient(
                servidor,
                puerto
        );

        return client;
    }

    @Override
    @Bean
    public SimpleMongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }

    public @Bean
    MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(new ServerAddress(this.servidor, this.puerto), new ArrayList<MongoCredential>() {
            private static final long serialVersionUID = 1L;

            {
                add(MongoCredential.createCredential(usuario, nombreBaseDatos, contrasenna.toCharArray()));
            }
        });
    }

@Override
    public @Bean MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

}
