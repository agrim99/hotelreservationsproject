package io.project.crudprojecthotelcsv.crudprojecthotelkafka.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.redis.core.RedisHash;


@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
public class HotelReservationRequest {

    private long hotel_id;
    private String date;
    private String room_category_id;
    private int occupancy;

    public long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom_category_id() {
        return room_category_id;
    }

    public void setRoom_category_id(String room_category_id) {
        this.room_category_id = room_category_id;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public String getKeyForCache() {
        return hotel_id+"@"+date+"@"+room_category_id+"@"+occupancy;

    }

}
