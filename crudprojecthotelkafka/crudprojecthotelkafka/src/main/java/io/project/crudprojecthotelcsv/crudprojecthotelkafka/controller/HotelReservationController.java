package io.project.crudprojecthotelcsv.crudprojecthotelkafka.controller;

import com.sun.istack.NotNull;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservation;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservationRequest;
import io.project.crudprojecthotelcsv.crudprojecthotelkafka.repository.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
public class HotelReservationController {

    public static final String HASH_KEY = "PRICE";

    @Autowired
    private HotelReservationRepository hotelReservationRepository;

    @PostMapping("hotelreservations")
    @CachePut(key = "#hotelReservation.getKeyForCache()", value = HASH_KEY)
    public long createHotelReservation(@RequestBody HotelReservation hotelReservation){
        hotelReservationRepository.save(hotelReservation);
        return hotelReservation.getPrice();
    }

    @GetMapping("hotelreservations")
    @Cacheable(key = "#hotelReservationRequest.getKeyForCache()", value = HASH_KEY)
    public long getHotelReservationPrice(@RequestBody HotelReservationRequest hotelReservationRequest){

        List<Long> prices = hotelReservationRepository.getPrice(hotelReservationRequest.getHotel_id(),
                hotelReservationRequest.getDate(), hotelReservationRequest.getRoom_category_id(),
                hotelReservationRequest.getOccupancy());
        return prices.get(0);

    }

    @PutMapping("hotelreservations")
    //@CacheEvict(key = "#hotelReservation.getKeyForCache()", value = HASH_KEY)
    @CachePut(key = "#hotelReservation.getKeyForCache()", value = HASH_KEY)
    public long updateHotelReservation(@RequestBody HotelReservation hotelReservation){

        hotelReservationRepository.updatePrice(hotelReservation.getHotel_id(), hotelReservation.getDate(),
                hotelReservation.getRoom_category_id(), hotelReservation.getOccupancy(), hotelReservation.getPrice());
        return hotelReservation.getPrice();
    }

    @DeleteMapping("hotelreservations")
    @CacheEvict(key = "#hotelReservationRequest.getKeyForCache()", value = HASH_KEY)
    public String deleteHotelReservation(@RequestBody @NotNull HotelReservationRequest hotelReservationRequest){

        hotelReservationRepository.deleterow(hotelReservationRequest.getHotel_id(), hotelReservationRequest.getDate(),
                hotelReservationRequest.getRoom_category_id(), hotelReservationRequest.getOccupancy());
        return "Deleted Successfully";
    }


}
