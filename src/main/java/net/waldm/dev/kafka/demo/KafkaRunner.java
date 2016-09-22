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

    }

    public String testMe() {
        logger.info("producer = " + producer.toString());
        logger.info("consumer = " + consumer.toString());
        return "yes boss!";
    }


}
