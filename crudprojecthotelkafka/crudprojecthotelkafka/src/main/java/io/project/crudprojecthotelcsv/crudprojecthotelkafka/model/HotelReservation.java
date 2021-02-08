package io.project.crudprojecthotelcsv.crudprojecthotelkafka.model;


import javax.persistence.*;

@Entity
@Table(name = "hotelreservations")
public class HotelReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Hotelid")
    private long hotel_id;

    @Column(name = "Date")
    private String date;

    @Column(name = "Roomcategoryid")
    private String room_category_id;

    @Column(name = "Occupancy")
    private int occupancy;

    @Column(name = "Price")
    private long price;


    public HotelReservation() {

    }

    public HotelReservation(long hotel_id, String date, String room_category_id, int occupancy) {
        this.hotel_id = hotel_id;
        this.date = date;
        this.room_category_id = room_category_id;
        this.occupancy = occupancy;
    }

    public HotelReservation(long hotel_id, String date, String room_category_id, int occupancy, long price) {
        this.hotel_id = hotel_id;
        this.date = date;
        this.room_category_id = room_category_id;
        this.occupancy = occupancy;
        this.price = price;
    }

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getKeyForCache() {
        return hotel_id+"@"+date+"@"+room_category_id+"@"+occupancy;

    }

}
