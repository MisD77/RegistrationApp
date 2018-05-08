/*
   Homework 5
   Dikshya Acharya
   concrete class dikshyaStudentType which extends abstract class
*/


public class dikshyaStudentType extends dikshyaUniversity{
   
   private String first, last;
   private int id;
   
   public dikshyaStudentType(String first, String last, int id)
   {
      super(first, last, id);
   }
   
   @Override
   public void typeRegistered()
   {
      System.out.println("Student registered.");
   }
   
   @Override
   public boolean paysTuition()
   {
      return true;
   }
   
   
        
}