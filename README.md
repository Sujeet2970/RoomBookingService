# Conference Room Reservation System

This project is a simple conference room reservation system written in Java. It allows users to schedule meetings in predefined conference rooms, ensuring that no room can be double-booked for the same time slot.

## Features

- Schedule meetings in predefined conference rooms.
- Check availability of rooms for a given time slot.
- Prevent double booking of rooms.
- Custom exception handling for no available rooms.

## Classes and Methods

### RoomReservationSystem

Manages the reservation system for multiple rooms.

- **Constructor**
  - `RoomReservationSystem(List<String> roomIds)`: Initializes the system with a list of room IDs.

- **Methods**
  - `String scheduleMeeting(String startTime, String endTime)`: Attempts to schedule a meeting in an available room. Returns a reservation identifier if successful, otherwise throws `NoAvailableRoomException`.

### Room

Represents a single conference room.

- **Constructor**
  - `Room(String id)`: Initializes a room with the given ID.

- **Methods**
  - `boolean isAvailable(String startTime, String endTime)`: Checks if the room is available for the given time slot.
  - `String reserve(String startTime, String endTime)`: Reserves the room for the given time slot if available. Returns a reservation ID.

### Reservation

Represents a reservation for a conference room.

- **Constructor**
  - `Reservation(String startTime, String endTime, String roomId)`: Initializes a reservation with the given start and end times and room ID.

- **Methods**
  - `boolean overlaps(String startTime, String endTime)`: Checks if the reservation overlaps with another given time slot.
  - `String getReservationId()`: Returns the reservation ID.

### NoAvailableRoomException

Custom exception for handling cases when no rooms are available.

- **Constructor**
  - `NoAvailableRoomException(String message)`: Initializes the exception with a custom message.

## Usage

```java
import java.util.*;

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
