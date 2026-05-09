package com.luca.business;

import com.luca.data.DataStore;
import com.luca.model.Train;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BookingTickets {
    private DataStore dataStore;

    public BookingTickets(DataStore dataStore){
        this.dataStore = dataStore;
    }

    public boolean bookTicket(int trainId, String customerEmail, int numberTickets) {
        for (Train train : dataStore.getTrains()) {
            if (train.getTrainId() == (trainId)) {
                if (train.acceptBooking(numberTickets)) {
                    train.addBooking(numberTickets);
                    System.out.println("Succesful booking of " + numberTickets + " for train " + trainId );
                    printConfirmation(customerEmail, trainId);
                    return true;
                }else{
                    System.out.println("Failed booking of " + numberTickets + " for train " + trainId);
                    return false;
                }
            }
        }
        System.out.println("Booking failed! Train " + trainId + " not found");
        return false;
    }

    public void printConfirmation(String customerEmail, int trainId) {
        String logFile = "emails_log_confirmation.txt";
        try(FileWriter fw = new FileWriter(logFile, true);
            PrintWriter print = new PrintWriter(fw)){
                print.println("\nBooking Email Confirmation\n");
                print.println("To: " + customerEmail);
                print.println("Subject: Booking Confiramtion");
                print.println("Message: Your ticket/s for train " + trainId + " are confirmed. Have a safe journey!");
                print.println("----------------------");
        } catch (IOException e) {
            System.out.println("Log wrinting error\n");
        }
    }
}
