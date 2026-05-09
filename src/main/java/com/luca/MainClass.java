package com.luca;

import com.luca.business.Administrator;
import com.luca.business.BookingTickets;
import com.luca.business.RouteFinder;
import com.luca.data.*;
import com.luca.model.Station;

public class MainClass {
    static void main() {
        DataStore dataStore = new DataStore();
        DataInitializer.popultateWithData(dataStore);

        Administrator administrator = new Administrator(dataStore);
        BookingTickets bookingTickets = new BookingTickets(dataStore);
        RouteFinder routeFinder = new RouteFinder(dataStore);

        System.out.println("\na) Booking availabilty\n");
        bookingTickets.bookTicket(1, "clinet1@gmail.com", 2);
        bookingTickets.bookTicket(4, "client2@yahoo.com", 1);
        bookingTickets.bookTicket(4, "client3@gmail.com", 7);


        System.out.println("\nb) Journey\n");
        Station paris = new  Station("Paris");
        Station lyon = new Station("Lyon");
        Station monaco = new Station("Monaco");
        Station manchester = new Station("Manchester");
        //direct route
        routeFinder.findRoute(paris, lyon);
        //overchange route
        routeFinder.findRoute(paris, monaco);
        //impossible route
        routeFinder.findRoute(monaco, manchester);

        System.out.println("\nc) Administrator\n");
        administrator.showBookingsForTrain(1);
        administrator.reportDelay(1);
        administrator.showBookingsForTrain(4);
        System.out.println("\n");
    }
}
