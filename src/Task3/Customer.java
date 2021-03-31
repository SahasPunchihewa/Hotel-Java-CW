package Task3;

public class Customer
{
    private String firstName,surName;
    private int creditCard;

    public Customer(String firstName, String surName, int creditCard)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.creditCard = creditCard;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurName()
    {
        return surName;
    }

    public void setSurName(String surName)
    {
        this.surName = surName;
    }

    public int getCreditCard()
    {
        return creditCard;
    }

    public void setCreditCard(int creditCard)
    {
        this.creditCard = creditCard;
    }
}
