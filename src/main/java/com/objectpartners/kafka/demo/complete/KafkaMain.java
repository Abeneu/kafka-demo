package com.objectpartners.kafka.demo.complete;



import com.objectpartners.kafka.demo.KafakConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KafkaMain {

    private final static Logger logger = LoggerFactory.getLogger(KafkaMain.class);

    public static void main(String[] args) {
        logger.info("Initializing Spring context.");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(KafakConfig.class);
        logger.info("Spring context initialized.");

        KafkaRunner runner = (KafkaRunner) ctx.getBean("kafkaRunner");
        runner.runDemo();
    }
}
