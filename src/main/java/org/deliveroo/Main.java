package org.deliveroo;

import org.deliveroo.exception.NoAvailableRoomException;
import org.deliveroo.service.RoomReservationSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roomIds = Arrays.asList("roomA", "roomB", "roomC");
        RoomReservationSystem system = new RoomReservationSystem(roomIds);

        try {
            System.out.println(system.scheduleMeeting("10:00", "11:00"));
            System.out.println(system.scheduleMeeting("10:30", "11:30"));
            System.out.println(system.scheduleMeeting("11:00", "12:00"));
            System.out.println(system.scheduleMeeting("10:00", "11:00"));
        } catch (NoAvailableRoomException e) {
            System.out.println(e.getMessage());
        }
    }
}






