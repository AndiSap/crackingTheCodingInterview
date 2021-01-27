package chapter3.StacksAndQueues;

import java.util.LinkedList;

/**
 * Animal shelter which holds both cats and dogs (in 2 linked lists), implement enqueue, dequeue, dequeueCat, dequeueDog
 */
enum Animal {
    CAT,
    DOG
}

public class AnimalQueue {
    LinkedList<Integer> cats;
    LinkedList<Integer> dogs;
    int orderNo;

    public AnimalQueue() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
        orderNo = 0;
    }

    public void enqueue(Animal animal) {
        orderNo++; // timestamp to return oldest animal
        if(animal == Animal.CAT)
            cats.add(orderNo);
        else
            dogs.add(orderNo);
    }

    public Animal dequeue() {
        if(cats.size() == 0) return dequeueDog();
        if(dogs.size() == 0) return dequeueCat();

        if(cats.peek() < dogs.peek())
            return dequeueCat();
        else
            return dequeueDog();
    }

    public Animal dequeueDog() {
        dogs.poll();
        return Animal.DOG;
    }

    public Animal dequeueCat() {
        cats.poll();
        return Animal.CAT;
    }
}
