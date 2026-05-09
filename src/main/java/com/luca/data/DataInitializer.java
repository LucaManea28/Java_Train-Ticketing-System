package com.luca.data;

import com.luca.model.Route;
import com.luca.model.Station;
import com.luca.model.Train;

import java.util.Arrays;

public class DataInitializer {
    public static void popultateWithData(DataStore dataStore){
        System.out.println("Start Initializing Data System");
        Train train1 = new Train(1, 150);
        Train train2 = new Train(2, 80);
        Train train3 = new Train(3, 200);
        Train train4 = new Train(4, 2);

        dataStore.addTrain(train1);
        dataStore.addTrain(train2);
        dataStore.addTrain(train3);
        dataStore.addTrain(train4);

        Station paris = new Station("Paris");
        Station lyon = new Station("Lyon");
        Station marseille = new Station("Marseille");
        Station nice = new Station("Nice");
        Station monaco = new Station("Monaco");
        Station london = new Station("London");
        Station manchester = new Station("Manchester");

        Route route1 = new Route(1, train1, Arrays.asList(paris, lyon, marseille));
        Route route2 = new Route(2, train2, Arrays.asList(marseille, nice, monaco));
        Route route3 = new Route(3, train3, Arrays.asList(london, manchester));
        Route routeTest = new Route(4, train4, Arrays.asList(paris, london));

        dataStore.addRoute(route1);
        dataStore.addRoute(route2);
        dataStore.addRoute(route3);
        dataStore.addRoute(routeTest);
        System.out.println("End Initializing Data System");
    }
}
