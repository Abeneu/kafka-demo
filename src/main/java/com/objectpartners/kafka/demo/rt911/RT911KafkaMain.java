package com.objectpartners.kafka.demo.rt911;


import com.objectpartners.kafka.demo.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RT911KafkaMain {

    private final static Logger logger = LoggerFactory.getLogger(RT911KafkaMain.class);

    public static void main(String[] args) {
        String dataFile = KafkaConfig.DATA_FILE;
        if(args.length > 0) {
            dataFile = args[0];
            logger.info("Using " + args[0] + " as input data file");
        }

        ApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);

        RT911KafkaPublisherRunner runner = (RT911KafkaPublisherRunner) ctx.getBean("RT911KafkaPublisherRunner");
        runner.setDataFileName(dataFile);
        runner.runDemo();
    }
}
