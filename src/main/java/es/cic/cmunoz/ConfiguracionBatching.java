package es.cic.cmunoz;

import es.cic.cmunoz.backend.service.CurvasService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableBatchProcessing
public class ConfiguracionBatching {

//    @Autowired
//    private JobBuilderFactory jobs;
//
//    @Autowired
//    private StepBuilderFactory steps;
//
//    @Autowired
//    private CurvasService curvasService;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;

    private static final String COLECCION = "Curvas";

//    @Bean
//    public Step step() {
//        return stepBuilders.get("step")
//                .<Partner, Partner>chunk(1)
//                .reader(reader(OVERRIDDEN_BY_EXPRESSION))
//                .processor(processor())
//                .writer(writer())
//                .listener(logProcessListener())
//                .build();
//    }
//
//    @Bean
//    public Job flatfileToDbWithParametersAutowiringJob(Step step) {
//        return jobBuilders.get("flatfileToDbWithParametersAutowiringJob")
//                .listener(protocolListener())
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    public Step step(ItemReader<Partner> reader) {
//        return stepBuilders.get("step")
//                .<Partner, Partner>chunk(1)
//                .reader(reader)
//                .processor(processor())
//                .writer(writer())
//                .listener(logProcessListener())
//                .build();
//    }
}
