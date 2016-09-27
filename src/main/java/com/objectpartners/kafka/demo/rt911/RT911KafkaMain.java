package com.objectpartners.kafka.demo.rt911;


import com.objectpartners.kafka.demo.KafakConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RT911KafkaMain {

    private final static Logger logger = LoggerFactory.getLogger(RT911KafkaMain.class);

    public static void main(String[] args) {
        logger.info("Initializing Spring context.");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(KafakConfig.class);
        logger.info("Spring context initialized.");

        RT911KafkaPublisherRunner runner = (RT911KafkaPublisherRunner) ctx.getBean("RT911KafkaPublisherRunner");
        runner.runDemo();
    }
}
