package ru.otus.open.stub.model;

import java.io.Serializable;
import java.util.Objects;

public class PriceFeed implements Serializable {
    private double price;
    private String name;

    public PriceFeed() {
    }

    public PriceFeed(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public PriceFeed(CcyPairs pair, double price) {
        this(pair.pair(), price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceFeed priceFeed = (PriceFeed) o;
        return Double.compare(priceFeed.price, price) == 0 &&
                Objects.equals(name, priceFeed.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "PriceFeed{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
