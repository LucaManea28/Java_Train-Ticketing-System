package com.luca.model;

import java.util.ArrayList;

public class Train {
    private int trainId;
    private int capacity;
    private int availableSeats;
    private boolean delay;

    public Train(int trainId, int capacity, int availableSeats, boolean delay) {
        this.trainId = trainId;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.delay = delay;
    }

    public Train(int trainId, int capacity){
        this.trainId = trainId;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public int getTrainId() {
        return trainId;
    }
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public boolean isDelay() {
        return delay;
    }
    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public boolean acceptBooking(int numberTickets){
        if(this.availableSeats - numberTickets >= 0){
            return true;
        }
        return false;
    }

    public void addBooking(int numberTickets){
        this.availableSeats -= numberTickets;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", delay=" + delay +
                '}';
    }
}
