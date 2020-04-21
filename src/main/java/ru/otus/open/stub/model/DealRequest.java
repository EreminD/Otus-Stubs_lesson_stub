package ru.otus.open.stub.model;

import java.io.Serializable;

public class DealRequest implements Serializable {
    private CcyPairs pair;
    private double amountInCcy1;
    private long size;

    public DealRequest() {
    }

    public DealRequest(CcyPairs pair, double amountInCcy1, long size) {
        this.pair = pair;
        this.amountInCcy1 = amountInCcy1;
        this.size = size;
    }

    public CcyPairs getPair() {
        return pair;
    }

    public void setPair(CcyPairs pair) {
        this.pair = pair;
    }

    public double getAmountInCcy1() {
        return amountInCcy1;
    }

    public void setAmountInCcy1(double amountInCcy1) {
        this.amountInCcy1 = amountInCcy1;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DealRequest{" +
                "pair=" + pair +
                ", amountInCcy1=" + amountInCcy1 +
                ", amount=" + size +
                '}';
    }
}
