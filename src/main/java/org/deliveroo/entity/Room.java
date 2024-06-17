package org.deliveroo.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String id;
    private List<Reservation> reservations;

    public Room(String id) {
        this.id = id;
        this.reservations = new ArrayList<>();
    }

    public boolean isAvailable(String startTime, String endTime) {
        for (Reservation reservation : reservations) {
            if (reservation.overlaps(startTime, endTime)) {
                return false;
            }
        }
        return true;
    }

    public String reserve(String startTime, String endTime) {
        Reservation reservation = new Reservation(startTime, endTime, id);
        reservations.add(reservation);
        return reservation.getReservationId();
    }

    public String getId() {
        return id;
    }
}