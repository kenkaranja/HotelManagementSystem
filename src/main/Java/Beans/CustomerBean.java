package Beans;

import Interfaces.CustomerI;
import Interfaces.DBI;
import POJO.Customer;
import POJO.Room;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class CustomerBean implements CustomerI {
    @EJB
    DBI dbi;

    @Inject
    Room room;
    String name;

    public boolean register(Customer customer) {
        if (dbi != null) {
            try {
                String sql = "insert into Customer(name,email,password,address,contact,arrival_date,dep_time) values(?,?,?,?,?,?,?)";
                PreparedStatement ps = dbi.createPreparedStatement(sql);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getEmail());
                ps.setString(3, customer.getPassword());
                ps.setString(4, customer.getAddress());
                ps.setString(5, customer.getContact());
                ps.setString(6, customer.getArrival_date());
                ps.setString(7, customer.getDep_date());
                return dbi.dbWrite(ps);
            } catch (Exception ex) {
                System.out.println(ex);
                return false;
            }
        }
        return false;
    }

    public boolean validate(Customer customer) {
        String sql = "SELECT * from Customer where email='" + customer.getEmail() + "' and password='" + customer.getPassword() + "'";
        ResultSet rs = dbi.dbRead(sql);
        try {
            return (rs != null && rs.next());
        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;
        }
    }


    public List<Room> viewRoom() {

        List<Room> list = new ArrayList<Room>();
        String booked = "NotBooked";
        try {
            String sql = "select * from Room where status='" + booked + "'";
            ResultSet rs = dbi.dbRead(sql);
            while (rs != null && rs.next()) {
                Room room = new Room();
                room.setRoomNo(rs.getInt("id"));
                room.setCost(rs.getFloat("cost"));
                room.setNoofpeople(rs.getInt("noofpeople"));
                room.setRoomType(rs.getString("roomtype"));
                room.setDescription(rs.getString("description"));
                room.setBookedStatus(rs.getString("status"));
                list.add(room);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public List<Room> viewBookedRooms(String user) {

        List<Room> list = new ArrayList<Room>();
        try {
            String sql = "select * from bookedroom where Customer='" + user + "'";
            ResultSet rs = dbi.dbRead(sql);
            while (rs != null && rs.next()) {
                Room room = new Room();
                room.setCost(rs.getFloat("cost"));
                room.setNoofpeople(rs.getInt("noofpeople"));
                room.setRoomType(rs.getString("roomtype"));
                room.setDescription(rs.getString("description"));
                list.add(room);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public int deleteBookedRoom() {
        int status = 0;
        try {
            String sql = "delete from bookedroom where id='" + room.getRoomNo() + "'";
            PreparedStatement ps = dbi.createPreparedStatement(sql);
            dbi.delete(ps);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;


    }

    public boolean bookRoom() {
        String roomstatus = "Booked";
        String sql = "Select * from Room where id='" + room.getRoomNo() + "'";
        ResultSet rs = dbi.dbRead(sql);
        String sqlUpdaterooms = "Update Room set status ='" + roomstatus + "' where id='" + room.getRoomNo() + "'";
        PreparedStatement updateps = dbi.createPreparedStatement(sqlUpdaterooms);
        dbi.dbWrite(updateps);
        String sqlInsert = "Insert into bookedroom(id,roomtype,cost,noofpeople,description,Customer) values(?,?,?,?,?,?)";
        PreparedStatement ps = dbi.createPreparedStatement(sqlInsert);

        try {
            while (rs != null && rs.next()) {
                ps.setInt(1, room.getRoomNo());
                ps.setString(2, room.getRoomType());
                ps.setFloat(3, room.getCost());
                ps.setInt(4, room.getNoofpeople());
                ps.setString(5, room.getDescription());
                ps.setString(6, room.getUser());
                return dbi.dbWrite(ps);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean payForRoom() {
        String sql = "delete from bookedroom where id='" + room.getRoomNo() + "'";
        PreparedStatement ps = dbi.createPreparedStatement(sql);
        dbi.delete(ps);
        String roomstatus = "NotBooked";
        String sqlUpdaterooms = "Update Room set status ='" + roomstatus + "' where id='" + room.getRoomNo() + "'";
        PreparedStatement updateps = dbi.createPreparedStatement(sqlUpdaterooms);
        return dbi.dbWrite(updateps);

    }
}
