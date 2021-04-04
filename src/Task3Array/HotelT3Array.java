package Task3Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelT3Array
{
    //Main method
    public static void main(String[] args)
    {
        //initialize variables
        Scanner input = new Scanner(System.in);
        String roomName = "";
        int roomNum = 0;
        String[][] hotel = new String[8][4];
        //call initialize method
        initialise (hotel);
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
    private static void initialise( String hotelRef[][] )
    {
        //insert 'e' for all rooms
        for (int x = 0; x <8; x++ )
        {
            for(int i=0;i<4;i++)
            {
                hotelRef[x][i] = "e";
            }
        }
        System.out.println ( "initialise ");
    }
    //view all rooms method
    private static void viewAll(String hotelRoom[][])
    {
        //loops for all rooms
        for (int x = 0; x <8; x++ )
        {
            //checks for empty rooms
            if (hotelRoom[x][0].equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
            else
            {
                System.out.println("room " + x + " occupied by " + hotelRoom[x][0]+" "+hotelRoom[x][1]);
            }
        }
    }
    //view empty rooms method
    private static void viewEmpty(String hotelRoom[][])
    {
        //loop for find empty rooms
        for (int x = 0; x < 8; x++ )
        {
            //checks of the room is empty or not
            if (hotelRoom[x][0].equals("e"))
            {
                System.out.println("room " + x + " is empty");
            }
        }
    }
    //add customer method
    private static void addCustomer(String hRooms[][])
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
                    System.out.println("Enter First name :" ) ;
                    String fName = cInput.next();
                    System.out.println("Enter Last Name :" ) ;
                    String lName = cInput.next();
                    System.out.println("Enter Number Of Customers In The Room :" ) ;
                    int noCus = cInput.nextInt();
                    System.out.println("Enter Credit Card Number :" ) ;
                    double  cardNo= cInput.nextDouble();
                    System.out.println();
                    hRooms[rNumber][0] = fName ;
                    hRooms[rNumber][1] = lName ;
                    hRooms[rNumber][2] = String.valueOf(noCus) ;
                    hRooms[rNumber][3] = String.valueOf(cardNo) ;
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
    private static void deleteCustomer(String hRooms[][])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter room number (0-7) to Delete A PersonT4" );
        int rNumber = cInput.nextInt();
        //checks is entered room is empty or not
        if(hRooms[rNumber][0].equals("e"))
        {
            System.out.println("This Room Is Already Empty");
        }
        else
        {
            String rname = hRooms[rNumber][0];
            hRooms[rNumber][0] = "e";
            System.out.println("Successfully Deleted "+rname);
        }
    }
    //find room method
    private static void findRoom(String hRooms[][])
    {
        Scanner cInput = new Scanner(System.in);
        System.out.println("Enter PersonT4 Name :");
        String rName = cInput.next();
        for(int i=0;i<8;i++)
        {
            if(hRooms[i][0].equals(rName))
            {
                System.out.println("Room " + i + " is occupied by " + rName+" "+hRooms[i][1]+"\n" +
                        "\tGuests : "+hRooms[i][2]+"\n\tCredit Card Number : "+hRooms[i][3]);
            }
        }
    }
    //store data method
    private static void storeData(String hRooms[][])
    {
        //create a file
        try
        {
            File rooms = new File("roomst3arr.txt");
            rooms.createNewFile();
            //saves data to the file
            try
            {
                FileWriter rWriter = new FileWriter("roomst3arr.txt");
                for (int x = 0; x < 8; x++ )
                {
                    rWriter.write(x + "|" + hRooms[x][0] + "|" + hRooms[x][1] + "|" +
                            "" + hRooms[x][2] + "|" + hRooms[x][3] +"\n");
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
    private static void loadData(String hRooms[][])
    {
        //imports text file
        try
        {
            File rooms = new File("roomst3arr.txt");
            Scanner txtReader = new Scanner(rooms);
            int i = 0;
            //reds file line by line
            while (txtReader.hasNextLine())
            {
                String[] room = txtReader.nextLine().split("\\|");
                hRooms[i][0] = room[1];
                hRooms[i][1] = room[2];
                hRooms[i][2] = room[3];
                hRooms[i][3] = room[4];
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
    private static void sortData(String hRooms[][])
    {
        //create sort data array
        String[][] sortedRooms = hRooms;
        for(int j = 0; j < sortedRooms.length; j++)
        {
            //compare values by name
            for (int i = 0; i < sortedRooms.length-1; i++)
            {
                String tmpfn = sortedRooms[i][0];
                String tmpfn2 = sortedRooms[i+1][0];
                String tmpln = sortedRooms[i][1];
                String tmpln2 = sortedRooms[i+1][1];
                String tmpcn = sortedRooms[i][2];
                String tmpcn2 = sortedRooms[i+1][2];
                String tmpcarn = sortedRooms[i][3];
                String tmpcarn2 = sortedRooms[i+1][3];
                if(tmpfn.compareTo(tmpfn2) >0)
                {
                    sortedRooms[i][0] = tmpfn2;
                    sortedRooms[i+1][0] = tmpfn;
                    sortedRooms[i][1] = tmpln2;
                    sortedRooms[i+1][1] = tmpln;
                    sortedRooms[i][2] = tmpcn2;
                    sortedRooms[i+1][2] = tmpcn;
                    sortedRooms[i][3] = tmpcarn2;
                    sortedRooms[i+1][3] = tmpcarn;
                }
            }
        }
        //prints sorted names without empty values
        for (int x = 0; x < 8; x++ )
        {
            if (!sortedRooms[x][0].equals("e"))
            {
                System.out.println(sortedRooms[x][0]);
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