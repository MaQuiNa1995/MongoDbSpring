package es.cic.cmunoz;

import es.cic.cmunoz.backend.service.CurvasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

//    @Autowired
//    CurvasService curvasService;
    
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfiguration.class);

        CurvasService curvasService = context.getBean(CurvasService.class);
        
        curvasService.hacerOperaciones();

    }
}
