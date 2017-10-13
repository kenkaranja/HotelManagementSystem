package Beans;

import Interfaces.DBI;
import Interfaces.ReceptionistI;
import POJO.Customer;
import POJO.Receptionist;
import POJO.Room;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class ReceptionistBean implements ReceptionistI {
    @EJB
    DBI dbi;

    public boolean addRoom(Room room) {
        try {

            String sql = "insert into room(id,roomtype,cost,noofpeople,description,status) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbi.createPreparedStatement(sql);
            ps.setInt(1, room.getRoomNo());
            ps.setString(2, room.getRoomType());
            ps.setFloat(3, room.getCost());
            ps.setInt(4, room.getNoofpeople());
            ps.setString(5, room.getDescription());
            ps.setString(6, room.getBookedStatus());
            return dbi.dbWrite(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    public boolean register(Receptionist receptionist) {
        try {
            String sql = "insert into Receptionist(name,email,password) values(?,?,?)";
            PreparedStatement ps = dbi.createPreparedStatement(sql);

            ps.setString(1, receptionist.getName());
            ps.setString(2, receptionist.getEmail());
            ps.setString(3, receptionist.getPassword());
            return dbi.dbWrite(ps);
        } catch (Exception ex) {

            System.out.println(ex);
            return false;
        }

    }

    public boolean validate(Receptionist receptionist) {
        String sql = "SELECT * from Receptionist where email='" + receptionist.getEmail() + "' and password='" + receptionist.getPassword() + "'";
        ResultSet rs = dbi.dbRead(sql);
        try {
            return (rs.next() && rs != null);
        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Room room) {
        try {
            String sql = "update Room set status='" + room.getBookedStatus() + "'";
            PreparedStatement ps = dbi.createPreparedStatement(sql);
            ps.setString(1, room.getRoomType());
            ps.setFloat(2, room.getCost());
            ps.setInt(3, room.getNoofpeople());
            ps.setString(4, room.getDescription());
            return dbi.dbWrite(ps);
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public int delete(Room room) {

        int status = 0;
        try {
            String sql = "delete from Room where id='" + room.getRoomNo() + "'";
            PreparedStatement ps = dbi.createPreparedStatement(sql);
            dbi.delete(ps);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public List<Room> viewRooms() {
        List<Room> list = new ArrayList<Room>();
        try {
            String sql = "select * from Room";
            ResultSet rs = dbi.dbRead(sql);
            while (rs.next()) {
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

    public List<Customer> viewCustomer() {
        List<Customer> list = new ArrayList<Customer>();
        String sql = "select * from Customer";
        ResultSet rs = dbi.dbRead(sql);
        try {
            while (rs.next() && rs != null) {
                Customer customer = new Customer();
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Room> viewBookedRooms() {
        List<Room> list = new ArrayList<Room>();
        try {
            String sql = "select * from bookedroom";
            ResultSet rs = dbi.dbRead(sql);
            while (rs.next()) {
                Room room = new Room();
                room.setRoomNo(rs.getInt("id"));
                room.setCost(rs.getFloat("cost"));
                room.setNoofpeople(rs.getInt("noofpeople"));
                room.setRoomType(rs.getString("roomtype"));
                room.setDescription(rs.getString("description"));
                room.setUser(rs.getString("Customer"));
                list.add(room);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }
}
