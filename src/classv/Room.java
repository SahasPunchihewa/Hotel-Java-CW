package classv;

public class Room
{
    //private  int roomNumber;
    private String cusName;

    public Room(String cusName)
    {
        //this.roomNumber = roomNumber;
        this.cusName = cusName;
    }

    /*public int getRoomNumber()
    {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }*/

    public String getCusName()
    {
        return cusName;
    }

    public void setCusName(String cusName)
    {
        this.cusName = cusName;
    }
}
