package com.luca.data;

import com.luca.model.Route;
import com.luca.model.Station;
import com.luca.model.Train;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private List<Train> trains;
    private List<Route> routes;
    private List<Station> stations;

    public DataStore() {
        trains = new ArrayList<>();
        routes = new ArrayList<>();
        stations = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }
    public void addRoute(Route route) {
        routes.add(route);
        for(Station station : route.getStations()) {
            if(!stations.contains(station)) {
                stations.add(station);
            }
            System.out.println("A: Route " + route.getRouteId() + " added");
        }
    }

    public List<Train> getTrains() {
        return trains;
    }
    public List<Route> getRoutes() {
        return routes;
    }
    public List<Station> getStations() {
        return stations;
    }
}
