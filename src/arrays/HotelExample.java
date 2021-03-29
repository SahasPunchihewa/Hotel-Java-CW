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
        initialise(hotel);

        System.out.println("Please Select One From Below List\nv - View All Rooms\na - Add a Customer\n" +
                "e - Display Empty Rooms\nd - Delete Customer From Room\nf - Find Room From Customer\n" +
                "s - Store Program Data Into File\nl - Load Program Data From File\no - View Guests Order By First Name");
        String menuOut=input.next().toLowerCase();
        switch (menuOut)
        {
            case "v":
                viewAll(hotel);
                break;
            case  "a":
                addCustomer(roomNum,input,roomName,hotel);
                viewAll(hotel);
                break;

        }

        /*while ( roomNum < 6 )
        {
            viewAll(hotel);
            addCustomer(roomNum,input,roomName,hotel);
        }*/
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
            if (hotelRoom[x].equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
            else
            {
                System.out.println("room " + x + " occupied by " + hotelRoom[x]);
            }
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
