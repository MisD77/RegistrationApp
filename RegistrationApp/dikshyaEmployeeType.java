/*
   Homework 5
   Dikshya Acharya
   concrete class dikshyaStudentType which extends abstract class
*/

public class dikshyaEmployeeType extends dikshyaUniversity{
   
   private String first, last;
   private int id;
   
   public dikshyaEmployeeType(String first, String last, int id)
   {
      super(first, last, id);
   }
   
   
   @Override
   public void typeRegistered()
   {
      System.out.println("Employee registered.");
   }
   
   @Override
   public boolean paysTuition()
   {
      return false;
   }
        
}