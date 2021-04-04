package Task4;

public class RoomT4
{
    private String cusName;
    private int noCustomer;

    public RoomT4(String cusName, int noCustomer)
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
