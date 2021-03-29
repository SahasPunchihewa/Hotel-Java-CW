package arrays;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class HotelExample
{
    //Main method
    public static void main(String[] args)
    {
        //initialize variables
        Scanner input = new Scanner(System.in);
        String roomName = "";
        int roomNum = 0;
        String[] hotel = new String[7];
        //call initialize method
        initialise (hotel);
        //loop for repeating main menu
        mainloop:
        while (true)
        {
            //print menu legend
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Please Select One From Below List\nv - View All Rooms\na - Add a Customer\n" +
                    "e - Display Empty Rooms\nd - Delete Customer From Room\nf - Find Room From Customer\n" +
                    "s - Store Program Data Into File\nl - Load Program Data From File\no - View Guests Order By First Name" +
                    "\nx - Stop Program");
            System.out.println("------------------------------------------------------------------");
            int subloop = 1;
            //loop for repeating input if wrong input is given
            while(subloop == 1)
            {
                String menuOut = input.next().toLowerCase();
                System.out.println("------------------------------------------------------------------\n");
                //checking entered input
                switch (menuOut)
                {
                    case "x" :
                        //stops the program
                        subloop = 0;
                        break mainloop;
                    case "v" :
                        //view all rooms
                        viewAll (hotel);
                        subloop = 0;
                        break;
                    case  "a" :
                        //add new customer
                        subloop = 0;
                        addCustomer (hotel);
                        viewAll (hotel);
                        break;
                    case "e" :
                        //view empty rooms
                        subloop = 0;
                        viewEmpty (hotel);
                        break;
                    case "d" :
                        //delete customer
                        subloop = 0;
                        deleteCustomer (hotel);
                        break;
                    case "f" :
                        //find room number when customer name given
                        subloop = 0;
                        findRoom (hotel);
                        break;
                    case "s" :
                        //saves customer data into a txt file
                        subloop = 0;
                        storeData (hotel);
                        break;
                    case "l" :
                        //loads customer data from txt file
                        subloop = 0;
                        loadData (hotel);
                        break;
                    case "o" :
                        //sorts customer names alphabetically
                        subloop = 0;
                        sortData (hotel);
                        break;
                    default :
                        //repeat menu input when given input is wrong
                        System.out.println("Please Enter A Correct Command !");
                }
            }
        }
    }
    //initialise method
    private static void initialise( String hotelRef[] )
    {
        //insert 'e' for all rooms
        for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
        System.out.println ( "initialise ");
    }
    //view all rooms method
    private static void viewAll(String hotelRoom[])
    {
        //loops for all rooms
        for (int x = 0; x < 6; x++ )
        {
            //checks for empty rooms
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
    //view empty rooms method
    private static void viewEmpty(String hotelRoom[])
    {
        //loop for find empty rooms
        for (int x = 0; x < 6; x++ )
        {
            //checks of the room is empty or not
            if (hotelRoom[x].equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
        }
    }
    //add customer method
    private static void addCustomer(String hRooms[])
    {
        //loop for get correct input
        while (true)
        {
            Scanner cInput=new Scanner(System.in);
            System.out.println("Enter room number (0-5)" );
            int rNumber = cInput.nextInt();
            //checks is room number is between 0 and 5
            if((rNumber >= 0) && (rNumber <= 5))
            {
                System.out.println("Enter name for room " + rNumber +" :" ) ;
                String rName = cInput.next();
                hRooms[rNumber] = rName ;
                break;
            }
            //if room number is out of range above will be looped
            else
            {
                System.out.println("Please Enter Number Between 0 and 5)");
            }
        }
    }
    //delete customer method
    private static void deleteCustomer(String hRooms[])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter room number (0-5) to Delete A Customer" );
        int rNumber = cInput.nextInt();
        //checks is entered room is empty or not
        if(hRooms[rNumber].equals("e"))
        {
            System.out.println("This Room Is Already Empty");
        }
        else
        {
            String rname = hRooms[rNumber];
            hRooms[rNumber] = "e";
            System.out.println("Successfully Deleted "+rname);
        }
    }
    //find room method
    private static void findRoom(String hRooms[])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter Customer Name :");
        String rName = cInput.next();
        int rNumber = Arrays.asList(hRooms).indexOf(rName);
        System.out.println("Room " + rNumber + " is occupied by " + rName);
    }
    //store data method
    private static void storeData(String hRooms[])
    {
        //create a file
        try
        {
            File rooms = new File("rooms.txt");
            rooms.createNewFile();
            //saves data to the file
            try
            {
                FileWriter rWriter = new FileWriter("rooms.txt");
                for (int x = 0; x < 6; x++ )
                {
                    rWriter.write(x + "|" + hRooms[x] + "\n");
                }
                rWriter.close();
                System.out.println("Data Saved Successfully !");
            }
            catch (IOException e)
            {
                //e.printStackTrace();
                System.out.println("An Error Occurred");
            }
        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("An Error Occurred");
        }
    }
    //load data method
    private static void loadData(String hRooms[])
    {
        //imports text file
        try
        {
            File rooms = new File("rooms.txt");
            Scanner txtReader = new Scanner(rooms);
            int i = 0;
            //reds file line by line
            while (txtReader.hasNextLine())
            {
                String[] room = txtReader.nextLine().split("\\|");
                hRooms[i] = room[1];
                i++;
            }
            System.out.println("Successfully Loaded !");
            txtReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Find The File");
            //e.printStackTrace();
        }
    }
    //sort data method
    private static void sortData(String hRooms[])
    {
        //create sort data array
        String[] sortedRooms = hRooms;
        for(int j = 0; j < sortedRooms.length; j++)
        {
            //compare values by name
            for (int i = 0; i < sortedRooms.length-2; i++)
            {
                String tmp = sortedRooms[i];
                String tmp2 = sortedRooms[i+1];
                if(tmp.compareTo(tmp2) >0)
                {
                    sortedRooms[i] = tmp2;
                    sortedRooms[i+1] = tmp;
                }
            }
        }
        //prints sorted names without empty values
        for (int x = 0; x < 6; x++ )
        {
            if (!sortedRooms[x].equals("e"))
            {
                System.out.println(sortedRooms[x]);
            }
        }
    }
}

/*References

https://stackoverflow.com/questions/886955/how-do-i-break-out-of-nested-loops-in-java
https://stackoverflow.com/questions/6171663/how-to-find-the-index-of-an-element-in-an-int-array/34173462
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/java_files_read.asp
https://stackoverflow.com/questions/20445900/comparing-two-string-and-sorting-them-in-alphabetical-order/41430230
 */