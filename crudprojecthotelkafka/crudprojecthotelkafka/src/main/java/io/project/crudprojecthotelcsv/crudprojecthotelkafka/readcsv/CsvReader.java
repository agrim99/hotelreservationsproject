package io.project.crudprojecthotelcsv.crudprojecthotelkafka.readcsv;

import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReader {

    @Autowired
    private KafkaTemplate<String, HotelReservation> kafkaTemplate;

    private static final String TOPIC = "Kafka_csv";

    public void producedata() {

        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Reservations.csv"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                HotelReservation hotelReservation = new HotelReservation(Integer.parseInt(data[1]), data[0], data[4],
                        Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                kafkaTemplate.send(TOPIC,hotelReservation);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV Read");

    }


}
