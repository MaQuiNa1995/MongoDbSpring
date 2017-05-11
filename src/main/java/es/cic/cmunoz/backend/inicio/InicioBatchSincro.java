package es.cic.cmunoz.backend.inicio;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class InicioBatchSincro {

    protected static Log logger = LogFactory.getLog(InicioBatchSincro.class);

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    
    protected static ClassPathXmlApplicationContext ctx;
    
    static {
        //LogFactory.getFactory().getInstance(Inicio.class).info(Commons.VERSION);
        ctx = new ClassPathXmlApplicationContext("applicationJobSincroContext.xml");
        ctx.start();
    }

    public InicioBatchSincro start() {
        // Devuelvo el InicioBatchSincro de Spring
        return ctx.getBean(InicioBatchSincro.class);
    }

    public void execute() {
        
        try {
            // Le asigno parametros distintos para cada ejecución para que no de el error "JobInstanceAlreadyCompleteException"
            JobParameters jobParam = new JobParametersBuilder().addLong("fecha_inicio", System.currentTimeMillis()).toJobParameters();
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
        } catch (JobExecutionAlreadyRunningException |
                JobRestartException |
                JobInstanceAlreadyCompleteException |
                JobParametersInvalidException ex) {
            Logger.getLogger(InicioBatchSincro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new InicioBatchSincro().start().execute();
    }

}
