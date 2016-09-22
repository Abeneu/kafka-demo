package net.waldm.dev.kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class Producer implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    KafkaProducer<String, String> kafkaProducer;

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            kafkaProducer.send(new ProducerRecord<>(KafakConfig.TOPIC, Integer.toString(i), Integer.toString(i)));
            logger.info("sent <" + i + "," + i + "> to  topic " + KafakConfig.TOPIC);
        }
        kafkaProducer.close();
    }
}
