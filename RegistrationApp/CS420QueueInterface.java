/*Homework 5
* Dikshya Acharya
*Queue interface for a CS420Queue class
*/

public interface CS420QueueInterface<T> {
	
	 void  enqueue(T itemType); // add the element at the rear of the queue
	 T dequeue(); //removes and returns the first element from the queue
	 boolean isFull(); //returns true is the queue is full
	 boolean isEmpty(); //returns true if the queue is empty
	 int length(); //returns the number of elements in this queue
}
