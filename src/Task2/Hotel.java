package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel
{
    //Main method
    public static void main(String[] args)
    {
        //initialize variables
        Scanner input = new Scanner(System.in);
        String roomName = "";
        int roomNum = 0;
        Room hotel[]=new Room[8];
        //call initialize method
        initialise (hotel);
        //loop for repeating main menu
        mainloop:
        while (true)
        {
            //print menu legend
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Please Select One From Below List\nv - View All Rooms\na - Add a Person\n" +
                    "e - Display Empty Rooms\nd - Delete Person From Room\nf - Find Room From Person\n" +
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
    private static void initialise(Room hotelRef[])
    {
        //insert 'e' for all rooms
        for (int x = 0; x <8; x++ )
        {
            Room room=new Room("e");
            hotelRef[x]=room;
        }
        System.out.println ( "initialise ");
    }
    //view all rooms method
    private static void viewAll(Room hotelRoom[])
    {
        //loops for all rooms
        for (int x = 0; x <8; x++ )
        {
            Room room=hotelRoom[x];
            String cName=room.getCusName();
            //checks for empty rooms
            if (cName.equals("e"))
            {
                System.out.println("Room " + x + " is empty");
            }
            else
            {
                System.out.println("Room " + x + " occupied by " + cName);
            }
        }
    }
    //view empty rooms method
    private static void viewEmpty(Room hotelRoom[])
    {
        //loop for find empty rooms
        for (int x = 0; x < 8; x++ )
        {
            Room room=hotelRoom[x];
            String rName=room.getCusName();
            //checks of the room is empty or not
            if (rName.equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
        }
    }
    //add customer method
    private static void addCustomer(Room hRooms[])
    {
        //loop for get correct input
        while (true)
        {
            Scanner cInput=new Scanner(System.in);
            System.out.println("Enter room number (0-7)" );
            try
            {
                int rNumber = cInput.nextInt();
                //checks is room number is between 0 and 5
                if((rNumber >= 0) && (rNumber <= 7))
                {
                    System.out.println("Enter name for room " + rNumber +" :" ) ;
                    String rName = cInput.next();
                    Room room = new Room(rName);
                    hRooms[rNumber]=room;
                    break;
                }
                //if room number is out of range above will be looped
                else
                {
                    System.out.println("Please Enter Number Between 0 and 7)");
                }
            }
            catch(InputMismatchException e)
            {
                //e.printStackTrace();
                System.out.println("Please Enter Valid Input");
            }

        }
    }
    //delete customer method
    private static void deleteCustomer(Room hRooms[])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter room number (0-7) to Delete A PersonT4" );
        int rNumber = cInput.nextInt();
        //checks is entered room is empty or not
        Room room=hRooms[rNumber];
        String rName=room.getCusName();
        if(rName.equals("e"))
        {
            System.out.println("This Room Is Already Empty");
        }
        else
        {
            Room newroom=new Room("e");
            hRooms[rNumber]=newroom;
            System.out.println("Successfully Deleted "+rName);
        }
    }
    //find room method
    private static void findRoom(Room hRooms[])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter Person Name :");
        String rName = cInput.next();
        for (int x=0;x<8;x++)
        {
            Room room = hRooms[x];
            if(room.getCusName().equals(rName))
            {
                System.out.println("Room " + x + " is occupied by " + rName);
            }
        }
    }
    //store data method
    private static void storeData(Room hRooms[])
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
                for (int x = 0; x < 8; x++ )
                {
                    Room room=hRooms[x];
                    rWriter.write(x + "|" + room.getCusName() + "\n");
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
    private static void loadData(Room hRooms[])
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
                Room room1=new Room(room[1]);
                hRooms[i]=room1;
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
    private static void sortData(Room hRooms[])
    {
        //create sort data array
        Room sortedRooms[] = hRooms;
        for(int j = 0; j < 8; j++)
        {
            //compare values by name
            for (int i = 0; i < 7; i++)
            {
                Room room1=sortedRooms[i];
                Room room2=sortedRooms[i+1];
                String tmp = room1.getCusName();
                String tmp2 = room2.getCusName();
                if(tmp.compareTo(tmp2) >0)
                {
                    room1.setCusName(tmp2);
                    room2.setCusName(tmp);
                    sortedRooms[i]=room1;
                    sortedRooms[i+1]=room2;
                }
            }
        }
        //prints sorted names without empty values
        for (int x = 0; x < 8; x++ )
        {
            Room room=sortedRooms[x];
            if (!room.getCusName().equals("e"))
            {
                System.out.println(room.getCusName());
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