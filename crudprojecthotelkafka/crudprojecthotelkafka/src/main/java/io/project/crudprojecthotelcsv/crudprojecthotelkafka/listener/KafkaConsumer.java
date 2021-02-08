package io.project.crudprojecthotelcsv.crudprojecthotelkafka.listener;

import io.project.crudprojecthotelcsv.crudprojecthotelkafka.controller.HotelReservationController;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservation;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.repository.HotelReservationRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private HotelReservationRepository hotelReservationRepository;

    @KafkaListener(topics = "Kafka_csv", groupId = "group_json", containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(HotelReservation hotelReservation){

        System.out.println("Consumed Message");
        hotelReservationRepository.save(hotelReservation);

    }


}
