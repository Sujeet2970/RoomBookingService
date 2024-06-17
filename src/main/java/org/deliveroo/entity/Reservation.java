package org.deliveroo.entity;

public class Reservation {
    private String startTime;
    private String endTime;
    private String roomId;
    private String reservationId;

    public Reservation(String startTime, String endTime, String roomId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomId = roomId;
        this.reservationId = generateReservationId();
    }

    private String generateReservationId() {
        return roomId + "-" + startTime + "-" + endTime;
    }

    public boolean overlaps(String startTime, String endTime) {
        return !(this.endTime.compareTo(startTime) <= 0 || this.startTime.compareTo(endTime) >= 0);
    }

    public String getReservationId() {
        return reservationId;
    }
}
