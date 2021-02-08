package io.project.crudprojecthotelcsv.crudprojecthotelkafka.repository;

import io.project.crudprojecthotelcsv.crudprojecthotelkafka.model.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation,Long>{

    @Query(value = "SELECT price FROM hotelreservations WHERE hotelid=:hotel_id AND date=:date AND roomcategoryid=:room_category_id AND occupancy=:occupancy", nativeQuery = true)
    List<Long> getPrice(long hotel_id, String date, String room_category_id, int occupancy);


    @Query(value = "UPDATE hotelreservations SET price=:price WHERE hotelid=:hotel_id AND date=:date AND roomcategoryid=:room_category_id AND occupancy=:occupancy", nativeQuery = true)
    void updatePrice(long hotel_id, String date, String room_category_id, int occupancy, long price);


    @Query(value = "DELETE FROM hotelreservations WHERE hotelid=:hotel_id AND date=:date AND roomcategoryid=:room_category_id AND occupancy=:occupancy", nativeQuery = true)
    void deleterow(long hotel_id, String date, String room_category_id, int occupancy);


}
