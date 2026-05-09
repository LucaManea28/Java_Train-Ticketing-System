package com.luca.model;

import java.util.List;

public class Route {
    private int routeId;
    private Train train;
    private List<Station> stations;
    public Route(int routeId, Train train, List<Station> stations) {
        this.routeId = routeId;
        this.train = train;
        this.stations = stations;
    }

    public int getRouteId() {
        return routeId;
    }
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public List<Station> getStations() {
        return stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", train=" + train +
                ", stations=" + stations +
                '}';
    }
}
