package com.objectpartners.kafka.demo.rt911;

import com.objectpartners.kafka.demo.KafakConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RT911KafkaPublisherRunner {

    private final static Logger logger = LoggerFactory.getLogger(RT911KafkaPublisherRunner.class);

    @Autowired
    RT911Producer producer;


    public void runDemo() {
        logger.info("this demo requires ZooKeeper and Kafka to be up and running " +
                    "and the topic " + KafakConfig.TOPIC + " must be available");

        Thread producerThread = new Thread(producer);

        logger.info("starting producer thread....");
        producerThread.start();

        try {
            producerThread.join();
            logger.info("producer complete");
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }

        logger.info("kafka rt911 publisher completed");
    }

}
