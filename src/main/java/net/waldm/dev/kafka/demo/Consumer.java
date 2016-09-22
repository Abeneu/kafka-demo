package net.waldm.dev.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
class Consumer implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    private volatile boolean running = false;

    @Autowired
    KafkaConsumer<String, String> kafkaConsumer;

    @Override
    public void run() {
        kafkaConsumer.subscribe(Collections.singletonList(KafakConfig.TOPIC));
        running = true;

        try {
            while (running) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
                for (ConsumerRecord<String, String> record : records)
                    logger.info(record.offset() + ": " + record.value());
            }
        } finally {
            kafkaConsumer.close();
        }
    }

    public void stop() {
        running = false;
    }
}
