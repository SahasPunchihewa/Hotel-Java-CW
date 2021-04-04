package Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelT4
{
    //Main method
    public static void main(String[] args)
    {
        //initialize variables
        Scanner input = new Scanner(System.in);
        String roomName = "";
        int roomNum = 0;
        HashMap<Integer, RoomT4> hotel=new HashMap<Integer, RoomT4>();
        HashMap<Integer, PersonT4> customer=new HashMap<Integer, PersonT4>();
        //call initialize method
        initialise (hotel,customer);
        //loop for repeating main menu
        mainloop:
        while (true)
        {
            //print menu legend
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Please Select One From Below List\nv - View All Rooms\na - Add a PersonT4\n" +
                    "e - Display Empty Rooms\nd - Delete PersonT4 From Room\nf - Find Room From PersonT4\n" +
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
                        addCustomer (hotel,customer);
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
                        deleteCustomer (hotel,customer);
                        break;
                    case "f" :
                        //find room number when customer name given
                        subloop = 0;
                        findRoom (hotel,customer);
                        break;
                    case "s" :
                        //saves customer data into a txt file
                        subloop = 0;
                        storeData (hotel,customer);
                        break;
                    case "l" :
                        //loads customer data from txt file
                        subloop = 0;
                        loadData (hotel,customer);
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
    private static void initialise(HashMap<Integer, RoomT4> hotelRef, HashMap<Integer, PersonT4> guestList)
    {
        //insert 'e' for all rooms
        for (int x = 0; x <8; x++ )
        {
            RoomT4 room=new RoomT4("e",0);
            PersonT4 guest=new PersonT4("e","e",0);
            hotelRef.put(x,room);
            guestList.put(x,guest);
        }
        System.out.println ( "initialise ");
    }
    //view all rooms method
    private static void viewAll(HashMap<Integer, RoomT4> hotelRoom)
    {
        //loops for all rooms
        for (int x = 0; x <8; x++ )
        {
            RoomT4 room=hotelRoom.get(x);
            String cName=room.getCusName();
            int cusNo=room.getNoCustomer();
            //checks for empty rooms
            if (cName.equals("e"))
            {
                System.out.println("RoomT4 " + x + " is empty");
            }
            else
            {
                System.out.println("Room " + x + " occupied by " + cName + " And Have "+ cusNo + " Guests");
            }
        }
    }
    //view empty rooms method
    private static int viewEmpty(HashMap<Integer, RoomT4> hotelRoom)
    {
        int rCount=0;
        //loop for find empty rooms
        for (int x = 0; x < 8; x++ )
        {
            RoomT4 room=hotelRoom.get(x);
            String rName=room.getCusName();
            //checks of the room is empty or not
            if (rName.equals("e"))
            {
                System.out.println("room " + x + " is empty");
                rCount++;
            }
        }
        return rCount;
    }
    //add customer method
    private static void addCustomer(HashMap<Integer, RoomT4> hRooms, HashMap<Integer, PersonT4> guestList)
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
                    RoomT4 tmproom=hRooms.get(rNumber);
                    if(!tmproom.getCusName().equals("e"))
                    {
                        System.out.println("This Room Is Booked Try Another One From Below !");
                        System.out.println();
                        int rCount=viewEmpty(hRooms);
                        if(rCount==0)
                        {
                            System.out.println("Sorry All The Rooms Are Booked You Will Be Added To The Queue\n");
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Enter First name :" ) ;
                        String fName = cInput.next();
                        System.out.println("Enter Last Name :" ) ;
                        String lName = cInput.next();
                        System.out.println("Enter Number Of Customers In The RoomT4 :" ) ;
                        int noCus = cInput.nextInt();
                        System.out.println("Enter Credit Card Number :" ) ;
                        double  cardNo= cInput.nextDouble();
                        System.out.println();
                        RoomT4 room = new RoomT4(fName,noCus);
                        PersonT4 guest=new PersonT4(fName,lName,cardNo);
                        hRooms.put(rNumber,room);
                        guestList.put(rNumber,guest);
                        break;
                    }
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
    private static void deleteCustomer(HashMap<Integer, RoomT4> hRooms, HashMap<Integer, PersonT4> guestList)
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter room number (0-7) to Delete A PersonT4" );
        int rNumber = cInput.nextInt();
        //checks is entered room is empty or not
        RoomT4 room=hRooms.get(rNumber);
        String rName=room.getCusName();
        if(rName.equals("e"))
        {
            System.out.println("This Room Is Already Empty");
        }
        else
        {
            RoomT4 newroom=new RoomT4("e",0);
            PersonT4 gusest=new PersonT4("e","e",0);
            hRooms.put(rNumber,newroom);
            guestList.put(rNumber,gusest);
            System.out.println("Successfully Deleted "+rName);
        }
    }
    //find room method
    private static void findRoom(HashMap<Integer, RoomT4> hRooms, HashMap<Integer, PersonT4> guestList)
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter PersonT4 Name :");
        String rName = cInput.next();
        for (HashMap.Entry<Integer, RoomT4> set : hRooms.entrySet())
        {
            RoomT4 room = set.getValue();
            int rNumber= set.getKey();
            int noCus=room.getNoCustomer();
            PersonT4 guest=guestList.get(rNumber);
            String lName=guest.getSurName();
            double cardNo=guest.getCreditCard();
            if(room.getCusName().equals(rName))
            {
                System.out.println("Room " + rNumber + " is occupied by " + rName + " " +lName+
                        "\n\tGuests : "+noCus+"\n\tCredit Card Number : "+cardNo);
            }
        }
    }
    //store data method
    private static void storeData(HashMap<Integer, RoomT4> hRooms, HashMap<Integer, PersonT4> guestList)
    {
        //create a file
        try
        {
            File rooms = new File("roomst4.txt");
            rooms.createNewFile();
            //saves data to the file
            try
            {
                FileWriter rWriter = new FileWriter("roomst4.txt");
                for (int x = 0; x < 8; x++ )
                {
                    RoomT4 room=hRooms.get(x);
                    PersonT4 guest=guestList.get(x);
                    rWriter.write(x + "|" + room.getCusName() +"|"+room.getNoCustomer()+
                            "|"+guest.getSurName()+ "|"+guest.getCreditCard()+"\n");
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
    private static void loadData(HashMap<Integer, RoomT4> hRooms, HashMap<Integer, PersonT4> guestList)
    {
        //imports text file
        try
        {
            File rooms = new File("roomst4.txt");
            Scanner txtReader = new Scanner(rooms);
            int i = 0;
            //reds file line by line
            while (txtReader.hasNextLine())
            {
                String[] room = txtReader.nextLine().split("\\|");
                System.out.println();
                RoomT4 room1=new RoomT4(room[1],Integer.parseInt(room[2]));
                PersonT4 guest=new PersonT4(room[1],room[3],Double.parseDouble(room[4]));
                hRooms.put(i,room1);
                guestList.put(i,guest);
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
    private static void sortData(HashMap<Integer, RoomT4> hRooms)
    {
        //create sort data array
        HashMap<Integer, RoomT4> sortedRooms = hRooms;
        for(int j = 0; j < 8; j++)
        {
            //compare values by name
            for (int i = 0; i < 7; i++)
            {
                RoomT4 room1=sortedRooms.get(i);
                RoomT4 room2=sortedRooms.get(i+1);
                String tmp = room1.getCusName();
                String tmp2 = room2.getCusName();
                if(tmp.compareTo(tmp2) >0)
                {
                    room1.setCusName(tmp2);
                    room2.setCusName(tmp);
                    sortedRooms.put(i,room1);
                    sortedRooms.put(i+1,room2);
                }
            }
        }
        //prints sorted names without empty values
        for (int x = 0; x < 8; x++ )
        {
            RoomT4 room=sortedRooms.get(x);
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