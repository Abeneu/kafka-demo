package com.objectpartners.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RT911KafkaRunner {

    private final static Logger logger = LoggerFactory.getLogger(RT911KafkaRunner.class);

    @Autowired
    RT911Producer producer;

    @Autowired
    Consumer consumer;

    public void runDemo() {
        logger.info("this demo requires ZooKeeper and Kafka to be up and running " +
                    "and the topic " + KafakConfig.TOPIC + " must be available");

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        logger.info("starting producer and consumer threads....");
        consumerThread.start();
        producerThread.start();

        try {
            producerThread.join();
            logger.info("producer complete");
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        } finally {
            consumer.stop();
        }

        logger.info("demo run completed");
    }

}
