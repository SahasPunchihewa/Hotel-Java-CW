package Task4;

public class RQueue
{
    static int size=8;
    static int front=0;
    static int rear=0;
    static Room[] hRooms =new Room[size];
    static Person[] guest =new Person[size];

    public static void enQueue(Room room,Person customer)
    {
        if((front==0)&&(rear==(size-1)))
        {
            System.out.println("Sorry The Queue Is Full !\n");
        }
        else
        {
            rear=(rear+1)%size;
            hRooms[rear] = room;
            guest[rear]=customer;
        }
    }

    public Room deQueue()
    {
        Room room=hRooms[front];
        front=(front+1)%size;
        return room;
    }

}
