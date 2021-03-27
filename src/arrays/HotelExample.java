package arrays;
import java.util.*;
public class HotelExample
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String roomName="";
        int roomNum = 0;
        String[] hotel = new String[7];
        //for (int x = 0; x < 6; x++ ) hotel[x] = ""; //initialise
        initialise(hotel); //better to initialise in a procedure
        while ( roomNum < 6 )
        {
            viewAll(hotel);
            addCustomer(roomNum,input,roomName,hotel);

            for (int x = 0; x < 6; x++ )
            {
                System.out.println("room " + x + " occupied by " + hotel[x]);
            }
        }
    }
    private static void initialise( String hotelRef[] )
    {
        for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
        System.out.println( "initilise ");
    }
    private static void viewAll(String hotelRoom[])
    {
        for (int x = 0; x < 6; x++ )
        {
            if (hotelRoom[x].equals("e"))System.out.println("room " + x + " is empty");
        }
    }
    private static void addCustomer(int rNumber,Scanner cInput,String rName,String hRooms[])
    {
        System.out.println("Enter room number (0-5) or 6 to stop:" );
        rNumber = cInput.nextInt();
        System.out.println("Enter name for room " + rNumber +" :" ) ;
        rName = cInput.next();
        hRooms[rNumber] = rName ;
    }
}
