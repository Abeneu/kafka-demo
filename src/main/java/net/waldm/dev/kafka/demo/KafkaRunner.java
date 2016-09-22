package net.waldm.dev.kafka.demo;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaRunner {

    private final static Logger logger = LoggerFactory.getLogger(KafkaRunner.class);

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    public void runDemo() {
        logger.info("this demo requires ZooKeeper and Kafka to be up and running\n" +
                    "and the topic " + KafakConfig.TOPIC + " must be available");

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        logger.info("starting producer and consumer threads....");
        consumerThread.start();
        producerThread.start();

        try {
            logger.info("sleep for 10 seconds so the producer and consumer can work....");
            Thread.sleep(10000);
            logger.info("sleep complete");
        } catch (InterruptedException e) {
            logger.info("wake up, time to finish up");
        } finally {
            logger.info("stopping consumer");
            consumer.stop();
        }
        logger.info("demo run completed");
    }

    public String testMe() {
        logger.info("producer = " + producer.toString());
        logger.info("consumer = " + consumer.toString());
        return "yes boss!";
    }


}
