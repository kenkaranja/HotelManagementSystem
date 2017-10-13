package POJO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Room {
    int roomNo;
    String roomType;
    String description;
    float cost;
    int noofpeople;
    String bookedStatus;
    String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(String bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getNoofpeople() {
        return noofpeople;
    }

    public void setNoofpeople(int noofpeople) {
        this.noofpeople = noofpeople;
    }
}
