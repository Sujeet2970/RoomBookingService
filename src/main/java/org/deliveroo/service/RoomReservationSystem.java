package org.deliveroo.service;

import org.deliveroo.entity.Room;
import org.deliveroo.exception.NoAvailableRoomException;

import java.util.ArrayList;
import java.util.List;

public class RoomReservationSystem {
    private List<Room> rooms;

    public RoomReservationSystem(List<String> roomIds) {
        this.rooms = new ArrayList<>();
        for (String roomId : roomIds) {
            rooms.add(new Room(roomId));
        }
    }

    public String scheduleMeeting(String startTime, String endTime) {
        for (Room room : rooms) {
            if (room.isAvailable(startTime, endTime)) {
                String reservationId = room.reserve(startTime, endTime);
                return "Reservation successful for " + reservationId;
            }
        }
        throw new NoAvailableRoomException("No rooms available for the given time slot");
    }
}