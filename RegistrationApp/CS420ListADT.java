//Homework 5
//Dikshya Acharya
//CS420ListADT class using generic data type


public class CS420ListADT<T> implements CS420ListInterface<T>
{
   
	// Instance variables
   private T[] CS420List;
	private int count;
   //Creating a private static variable of the singleton CS420ListADT class 
   private static CS420ListADT singleInstance;

   // Creating a singleton class for CS420ListADT
	// Creating a private and single default constructors for CS420ListADT
	private CS420ListADT()
	{
      this.CS420List = (T[]) new Object[20];
      this.count = 0;
	}
   
   // Creating a get/accessor method that returns an instance of class created above
   public static CS420ListADT getCS420ListADTInstance(){
   
      if (singleInstance == null)
      {
         singleInstance = new CS420ListADT();
      
      }
      return singleInstance;
   }
   
   //returns the size of the list
	public int size()
	{
		return this.count;
	}
	
   //checks weather the itemType is in the list
   public boolean contains(T itemType)
	{
      boolean isPresent = false;
      for (int i = 0; i < this.count; i++){
         if (this.CS420List[i].equals(itemType))
            isPresent = true;
      }      
      return isPresent;
   }	
   

   //Adds itemType the list
	public boolean add(T itemType) throws CS420Exception
   {
      boolean isFound = contains(itemType);
      boolean success = false;
      
      //adds to the list if not found in the list before
      if (size() == 10)// default 5, but change this to 15 when using with TestDriverApp.
         {
             throw new CS420Exception(size(), "Maximum limit reached!");
         }

      if(!isFound)
      {
         
         success = true;
         CS420List[count] = itemType;
         count++;  
         System.out.println(itemType + " added to the event list.");
                   
      }
      
      else
      {
         System.out.println("Add error. Same Id exists");
         System.out.println("Cannot add to the list.");
         System.out.println();
      }
       return success;
   }
	
   
   //removes itemType from the list
	public boolean remove(T itemType)
	{
      boolean isFound = contains(itemType);
      boolean success = false;
      
      if (isFound)
      {
         for (int i = 0; i < count; i++)
         {
            if (this.CS420List[i].equals(itemType))
            {
               this.CS420List[i] = this.CS420List[count-1];
               this.CS420List[count-1] = null;
               count--;
            }
         }
         System.out.println("Withdraw Successful");
         success = true;
      }
      
      else
      {
         System.out.println("Cannot withdraw, person not found.");
         System.out.println();
      }     
   
      return success;
   }
   
   //String representation of the itemType
	@Override
	public String toString()
	{
		String listContent = "";
      for (int i= 0; i < this.count; i++)
         listContent += this.CS420List[i].toString()+"\n"; 
      
      return listContent;
	}
}
