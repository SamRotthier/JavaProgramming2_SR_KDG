import be.kdg.java2.Model.Monster;
import be.kdg.java2.data.Data;
import be.kdg.java2.generics.PriorityQueue;
import java.util.*;

public class Demo_2 {
    public static void main(String[] args) {

        PriorityQueue<String> myQueue = new PriorityQueue<>();
        myQueue.enqueue("Tokio", 2);
        myQueue.enqueue("Denver", 5);
        myQueue.enqueue("Rio", 2);
        myQueue.enqueue("Oslo", 3);
        System.out.println("Overzicht van de PriorityQueue:");
        System.out.println(myQueue.toString());
        System.out.println("aantal: " + myQueue.getSize());
        System.out.println("positie van Tokio: " + myQueue.search("Tokio"));
        System.out.println("positie van Nairobi: " + myQueue.search("Nairobi"));
        for(int i = 0; i < 4; i++) {
            System.out.println("Dequeue: " + myQueue.dequeue());
        }
        System.out.println("Size na dequeue: " + myQueue.getSize());


        myQueue = new PriorityQueue<>();
        Random random = new Random();
        for (Monster monster : Data.getData()) {
            myQueue.enqueue(String.valueOf(monster), random.nextInt(5)+1);
        }
        System.out.println("Overzicht van de PriorityQueue:");
        System.out.println(myQueue);
        System.out.println("aantal: " + myQueue.getSize());
        System.out.printf("positie van %s: %d\n\n", Data.getData().get(8).getName(), myQueue.search(String.valueOf(Data.getData().get(8))));;
        int size = myQueue.getSize();
        for(int i = 0; i < size; i++) {
            System.out.println("Dequeue: " + myQueue.dequeue());
        }
        System.out.println("\nSize na dequeue: " + myQueue.getSize());

        //var
        myQueue = new PriorityQueue<>();
        random = new Random();
        for (var game : Data.getData())
            myQueue.enqueue(String.valueOf(game), random.nextInt(5)+1);
        System.out.println("Overzicht van de PriorityQueue:");
        System.out.println(myQueue);
        System.out.println("aantal: " + myQueue.getSize());
        System.out.printf("positie van %s: %d\n\n", Data.getData().get(5).getName(), myQueue.search(String.valueOf(Data.getData().get(5))));;
        size = myQueue.getSize();
        for(var i = 0; i < size; i++){
            System.out.println("Dequeue: " + myQueue.dequeue());
        }
        System.out.println("\nSize na dequeue: " + myQueue.getSize());

    }
}
