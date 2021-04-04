package Task4;

public class Person
{
    private String firstName,surName;
    private double creditCard;

    public Person(String firstName, String surName, double creditCard)
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

    public double getCreditCard()
    {
        return creditCard;
    }

    public void setCreditCard(int creditCard)
    {
        this.creditCard = creditCard;
    }
}
