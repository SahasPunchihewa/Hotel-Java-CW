package Task4;

import java.util.HashMap;

public class RQueue
{
    static int size=8;
    static int front=-1;
    static int rear=-1;
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
            if(front==-1)
            {
                front=0;
            }
        }
    }

    public static Room deQueueRoom()
    {
        Room room;
        if(front!=-1)
        {
            room=hRooms[front];
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else
            {
                front=(front+1)%size;
            }
        }
        else
        {
            room=new Room("e",0);
        }
        return room;
    }
    public static Person deQueuePerson()
    {
        Person customer;
        if(front!=-1)
        {
            customer=guest[front];
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else
            {
                front=(front+1)%size;
            }
        }
        else
        {
            customer=new Person("e","e",0);
        }
        return customer;
    }

}

/*
Refernces

https://www.programiz.com/dsa/circular-queue
 */
