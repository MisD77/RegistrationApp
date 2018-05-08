/*
   Homework 5
   Dikshya Acharya
   abstract class for itemtype as a part of factory design pattern
*/

public abstract class dikshyaUniversity
{

   abstract void typeRegistered();
   abstract boolean paysTuition();
   
   
   protected String firstName, lastName; 
   protected int id;
   
   public dikshyaUniversity(String f, String l, int id)
	{
		this.firstName = f;
      this.lastName = l;
      this.id = id;
	}
   
   public String getFirstName()
	{
		return firstName;
	}
   
   public void setFirstName(String n)
   {
      firstName = n;
   }
   
   public String getLastName()
	{
		return lastName;
	}
   
   public void setLastName(String n)
   {
      lastName = n;
   }
   
   public int getId()
   {
      return id;
   }
		
   public void setId(int id)
   {
      id = id;
   }
   
   @Override
   public String toString()
   {
      String s = this.getFirstName() + " "+ this.getLastName()+"  ["+this.getId()+"]";
      return s;
   }
   
   @Override
   public boolean equals(Object o)
   {
      boolean eq = false;
      if (o == null)
         eq = false;
      else
      {
         
         dikshyaUniversity person = (dikshyaUniversity) o;
         if (this.getId() == person.getId())
            eq = true;
      }   
     return eq;
   }


}