package Interfaces;

import POJO.Customer;
import POJO.Receptionist;
import POJO.Room;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ReceptionistI {
    boolean register(Receptionist receptionist);

    boolean addRoom(Room room);

    boolean validate(Receptionist receptionist);

    boolean update(Room room);

    int delete(Room room);

    List<Room> viewRooms();

    List<Customer> viewCustomer();

    List<Room> viewBookedRooms();


}
