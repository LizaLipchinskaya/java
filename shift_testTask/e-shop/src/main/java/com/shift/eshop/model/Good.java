package com.shift.eshop.model;

import javax.persistence.*;

@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(name = "serialNumber")
    public String serialNumber;
    @Column(name = "producer")
    public String producer;
    @Column(name = "price")
    public double price;
    @Column(name = "count")
    public int count;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getProducer() {
        return producer;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
