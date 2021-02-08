package io.project.crudprojecthotelcsv.crudprojecthotelkafka.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("PRICE")
public class Price {

    long price;

    public Price(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
