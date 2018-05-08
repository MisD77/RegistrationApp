/*
   Homework 5
   Dikshya Acharya
   Factory method implementation in a concrete dikshyaUniversityFactory, 
   which will be the concreate creator of the application.
*/


public class dikshyaUniversityFactory extends dikshyaUniversityBaseFactory
{
   public dikshyaUniversity createItemType(String type, String fname, String lname, int id)
   {          
       dikshyaUniversity whoAmI;
        switch (type.toLowerCase())
        {
            case "student":
                whoAmI = new dikshyaStudentType(fname,lname,id);
                break;
            case "employee":
                whoAmI = new dikshyaEmployeeType(fname,lname,id);
                break;
            default: throw new IllegalArgumentException("No such type in university.");
        }
        return whoAmI; 
   }
      
}
