package io.project.crudprojecthotelcsv.crudprojecthotelkafka.configuations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservation;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, HotelReservation> consumerFactory(){

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(HotelReservation.class));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, HotelReservation> kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String, HotelReservation> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;

    }


}
