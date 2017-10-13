package Interfaces;

import POJO.Customer;
import POJO.Room;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerI {
    boolean register(Customer customer);

    boolean validate(Customer customer);

    List<Room> viewRoom();

    boolean bookRoom();

    List<Room> viewBookedRooms(String user);

    int deleteBookedRoom();

    boolean payForRoom();


}
