package Task3;

public class Room
{
    private String cusName;
    private int noCustomer;

    public Room(String cusName, int noCustomer)
    {
        this.cusName = cusName;
        this.noCustomer = noCustomer;
    }

    public String getCusName()
    {
        return cusName;
    }

    public void setCusName(String cusName)
    {
        this.cusName = cusName;
    }

    public int getNoCustomer()
    {
        return noCustomer;
    }

    public void setNoCustomer(int noCustomer)
    {
        this.noCustomer = noCustomer;
    }
}
