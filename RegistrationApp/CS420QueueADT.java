
/**
 * Homework 5
 * Dikshya Acharya
 * QueueADT class to store the itemTypes for waitlisting
 *
 */


public class CS420QueueADT<T> implements CS420QueueInterface<T>{
	//instance variables
	private T[] queueArray;
	private int first;
	private int last;
	private int numInQueue;
	
	// Constructors
	public CS420QueueADT() {
		queueArray = (T[]) new Object[4];
		first = 0;
		last = -1;
		numInQueue = 0;
	}
	
	//check whether the queue is empty
	public boolean isEmpty(){
		
		if (numInQueue == 0)
			return true;
		else
			return false;
	}
	
	//check whether the queue is full
	public boolean isFull() {
		if (numInQueue == queueArray.length)
			return true;
		else
			return false;	
	}
	
	//adds an itemType in the rear of the list
	public void enqueue(T itemType)
	{
		
		last = (last + 1) % queueArray.length;
		queueArray[last] = itemType;
		numInQueue++;
		System.out.println(itemType +" queued in the waitlist.");
      System.out.println();
		
      if (isFull())
			throw new RuntimeException("Sorry the waitlist is full at the moment");
		
	}
	
	//removes and returns an itemType at the front of the queue
	public T dequeue()
	{
		if (isEmpty())
			throw new RuntimeException("There is no one in waitlist currently.");
		else {
			T itemType = queueArray[first];
			first = (first + 1) % queueArray.length;
			numInQueue--;
			System.out.println(itemType + " removed from the waitlist");
         System.out.println();

			return itemType;
		}
	}
	
	//finds the number of itemTypes in the wait-list
	public int length()
	{
		return numInQueue;
	}
	
	//returns a string representation of the itemType on wait-list
	@Override
	public String toString() {
		String queueContent = "";
		
		for (int i = 0; i < numInQueue; i++)
		{
			int pos = (first + i) % queueArray.length;
            queueContent += queueArray[pos].toString()+"\n";
		}
		
		return queueContent;
		
	}
	

}
