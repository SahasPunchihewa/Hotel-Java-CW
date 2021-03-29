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
        mainloop:
        while(true)
        {
            System.out.println("Please Select One From Below List\nv - View All Rooms\na - Add a Customer\n" +
                    "e - Display Empty Rooms\nd - Delete Customer From Room\nf - Find Room From Customer\n" +
                    "s - Store Program Data Into File\nl - Load Program Data From File\no - View Guests Order By First Name" +
                    "\nx - Stop Program");
            String menuOut=input.next().toLowerCase();
            switch (menuOut)
            {
                case "x":
                    break mainloop;
                case "v":
                    viewAll(hotel);
                    break;
                case  "a":
                    addCustomer(hotel);
                    viewAll(hotel);
                    break;
                case "e":
                    viewEmpty(hotel);
                    break;
                case "d":
                    deleteCustomer(hotel);
                    break;
                case "f":
                    findRoom(hotel);
                    break;

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
    private static void viewEmpty(String hotelRoom[])
    {
        for (int x = 0; x < 6; x++ )
        {
            if (hotelRoom[x].equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
        }
    }
    private static void addCustomer(String hRooms[])
    {
        Scanner cInput=new Scanner(System.in);
        System.out.println("Enter room number (0-5) or 6 to stop:" );
        int rNumber = cInput.nextInt();
        System.out.println("Enter name for room " + rNumber +" :" ) ;
        String rName = cInput.next();
        hRooms[rNumber] = rName ;
    }
    private static void deleteCustomer(String hRooms[])
    {
        Scanner cInput=new Scanner(System.in);
        System.out.println("Enter room number (0-5) to Delete A Customer" );
        int rNumber = cInput.nextInt();
        if(hRooms[rNumber].equals("e"))
        {
            System.out.println("This Room Is Already Empty");
        }
        else
        {
            String rname=hRooms[rNumber];
            hRooms[rNumber]="e";
            System.out.println("Successfully Deleted "+rname);
        }
    }
    private static void findRoom(String hRooms[])
    {
        Scanner cInput=new Scanner(System.in);
        System.out.println("Enter Customer Name :");
        String rName=cInput.next();
        int rNumber=Arrays.asList(hRooms).indexOf(rName);
        System.out.println("Room "+rNumber+" is occupied by "+rName);
    }
}

/*References

https://stackoverflow.com/questions/886955/how-do-i-break-out-of-nested-loops-in-java



 */