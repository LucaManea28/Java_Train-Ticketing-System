package com.luca.business;

import com.luca.data.DataStore;
import com.luca.model.Route;
import com.luca.model.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteFinder {
    private DataStore dataStore;
    public RouteFinder(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void findRoute(Station start, Station end){
        for(Route route: dataStore.getRoutes()){
            if(route.getStations().contains(start) && route.getStations().contains(end)){
                int startIndex = route.getStations().indexOf(start);
                int endIndex = route.getStations().indexOf(end);
                if(startIndex < endIndex){
                    System.out.println();
                    System.out.println("Succes: Direct route found");
                    System.out.println("Train ID " + route.getTrain().getTrainId() + " Route ID " + route.getRouteId());
                    System.out.println();
                    return;
                }
            }
        }
        List<Route> matchingStops = getRoutesByStations(start);
        for(Route firstRoute: matchingStops){
            for(Station transferStation: firstRoute.getStations()){
                List<Route> connectionRoutes = getRoutesByStations(transferStation);
                for(Route secondRoute: connectionRoutes){
                    if(firstRoute.getRouteId() != secondRoute.getRouteId()){
                        if(secondRoute.getStations().contains(end)){
                            int startIndex = firstRoute.getStations().indexOf(start);
                            int transferIndex1 = firstRoute.getStations().indexOf(transferStation);
                            int transferIndex2 = secondRoute.getStations().indexOf(transferStation);
                            int endIndex = secondRoute.getStations().indexOf(end);
                            if(startIndex < transferIndex1 && transferIndex2 < endIndex){
                                System.out.println();
                                System.out.println("Succes: Changeover route found");
                                System.out.println("Train ID " +  firstRoute.getTrain().getTrainId() + " from " + start.getName() + " to " + transferStation.getName());
                                System.out.println("ChangeOver in " + transferStation.getName());
                                System.out.println("Train ID " + secondRoute.getTrain().getTrainId() + " from " + transferStation.getName() + " to " + end.getName());
                                System.out.println();
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Impossible to find a like between " + start.getName() + " and " + end.getName());
        System.out.println();
    }

    private List<Route> getRoutesByStations(Station station){
        List<Route> matchingRoutes = new ArrayList<>();
        for(Route route: dataStore.getRoutes()){
            if(route.getStations().contains(station)){
                matchingRoutes.add(route);
            }
        }
        return matchingRoutes;
    }
}
