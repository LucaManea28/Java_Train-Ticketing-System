package com.luca.business;

import com.luca.data.DataStore;
import com.luca.model.Route;
import com.luca.model.Station;
import com.luca.model.Train;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Administrator {
    private DataStore dataStore;
    public Administrator(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Train createTrain(int trainId, int capaciy){
        Train train = new Train(trainId, capaciy);
        dataStore.addTrain(train);
        return train;
    }

    public void createRoute(int routeId, Train train, List<Station> stations){
        Route route = new Route(routeId, train, stations);
        dataStore.addRoute(route);
    }

    public void reportDelay(int trainId){
        for(Train train : dataStore.getTrains()){
            if(train.getTrainId() == trainId){
                train.setDelay(true);
                System.out.println("A: Train " + trainId + " is delayed");
                printDelayWarningEmail(trainId);
                return;
            }
        }
        System.out.println("Train " + trainId + " not found");
    }

    private void printDelayWarningEmail(int trainId){
        String logFile = "emails_log_delays.txt";
        try(FileWriter fw = new FileWriter(logFile, true);
            PrintWriter print = new PrintWriter(fw)){
            print.println("\nDelay Warning Email");
            print.println("To: All Passengers of Train " + trainId);
            print.println("Subject: TRAIN DELAY ALERT");
            print.println("Message: Please be advised that train " + trainId + " is currently experiencing delays. ");
            print.println();
        } catch (IOException e) {
            System.out.println("Log writing error\n");
        }
    }

    public void showBookingsForTrain(int trainId){
        for(Train train : dataStore.getTrains()){
            if(train.getTrainId() == trainId){
                int soldTickets = train.getCapacity() - train.getAvailableSeats();
                System.out.println("A: Train " + trainId + " sold tickets: " + soldTickets);
                return;
            }
        }
    }
}
