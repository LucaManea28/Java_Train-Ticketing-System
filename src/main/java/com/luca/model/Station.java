package com.luca.model;

public class Station {
    private int stationId;
    private String name;

    public  Station(int stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public Station(String name) {
        this.name = name;
    }

    public int getStationId() {
        return stationId;
    }
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }else if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return this.name.equals(station.name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                '}';
    }
}
