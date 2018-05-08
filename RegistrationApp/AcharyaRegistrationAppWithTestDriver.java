/*Homework 5
* Dikshya Acharya
* Application class for CSListADT using Generics, Pattern and a Business solution
* Application lets students and employees to register for an event in university
* Reads  data from the file and adds and removes different itemTypes, and registers them for an event.
* Uses two adts, List adt and stack adt, List adt to store all the itemTypes registered for the event, and queueInterface to faciliate the waitlisting for the event.
* The wailist starts working once the limit of the listAdt is reached and the priority for registration to an event is given based on first in, first out.
*/

import java.util.*;
import java.io.*;
public class AcharyaRegistrationAppWithTestDriver
{

    public static void main(String[] args) 
    {
        dikshyaUniversity dikshyaType;
        CS420ListADT <dikshyaUniversity> myEvent = CS420ListADT.getCS420ListADTInstance(); //list to registers for event
        CS420QueueADT<dikshyaUniversity> eventWaitlist = new CS420QueueADT(); //queue for waitlisted 
        dikshyaUniversityBaseFactory factory;
        System.out.println();
        System.out.println();
        System.out.println("******************************************************");
        System.out.println("       Welcome to CS-420Event Registration            ");
        System.out.println("******************************************************");
        System.out.println();
        System.out.println("Total students/employees registered so far: " + myEvent.size());
        System.out.println();
        boolean stop = false; 
        boolean removeSuccess;
        boolean addSuccess;
        Scanner data; 
        Scanner kb = new Scanner(System.in);
        
        
        try
            {
               File f = new File("studentData.txt");
               data = new Scanner(f);
              
               
               while (data.hasNext())
               {      
                     String type = data.next();
                     String firstName = data.next();
                     String lastName = data.next();
                     int id = data.nextInt();
                     
                     factory = new dikshyaUniversityFactory();
                     dikshyaType = factory.createItemType(type, firstName, lastName, id);
      
                    
                      
                      addSuccess = myEvent.add(dikshyaType); //adds the student(name and id) to the list
                      if(addSuccess) 
                      {
                        dikshyaType.typeRegistered();
                        System.out.println("Pays Tuition: "+ dikshyaType.paysTuition());
                        System.out.println();
                      }
                     
                    System.out.println("Registered: "+ myEvent.size());
                    System.out.println("In waitlist: "+ eventWaitlist.length());
                    System.out.println();
                              
               }
               
               data.close();
               
         }
         catch(CS420Exception ex)
         {
             System.out.println(ex.getMessage()+" "+ex.getLimit() + " students registered. ");   
             System.out.println();
         }
         catch (FileNotFoundException e)
         {
            System.out.println("File not found");
         }
         System.out.println("The Event List registered:");
         System.out.println(myEvent);
         
         /*
         * creating a waitlist for student who cannot register so that they can later get 
         * space when someone withdraws their name from the event
         */
         
         stop = false;
         System.out.println();
         System.out.println("*******************************************************");
         System.out.println("           Welcome to the waitlist portal");
         System.out.println("*******************************************************");
         System.out.println();


        
         do
         {
            try
            {
               System.out.println("Please sign up for the waiting list.");
               System.out.println();
               System.out.print("Are you a [student] or [employee]: ");
               String type = kb.next();
          
               System.out.print("Enter the first name: ");
               String firstName = kb.next();
               
               System.out.print("Enter the last name: ");
               String lastName = kb.next();
               
               System.out.print("Enter your id: ");
               int id = kb.nextInt();
               System.out.println();
               
               factory = new dikshyaUniversityFactory();
               dikshyaType = factory.createItemType(type, firstName, lastName, id);
                  
               //Adds itemType to the waitlist using enqueue
               eventWaitlist.enqueue(dikshyaType);               
               System.out.println();
               System.out.print("Add more? Enter: [1] to continue / [2] to stop: ");
   
               int action1 = kb.nextInt();
               switch (action1)
               {
                  case 1:
                     stop = false;
                     break;
                     
                 case 2:
                     stop = true;
                     break;
                                  
                 default: continue;          

               }
            }  
            
            catch (IllegalArgumentException ex)
            {
               System.out.println(ex.getMessage());
               System.out.println();
               stop = false;
               kb.nextLine();
            }
            
            //catches the exception thrown when queue reaches the maximum limit      
            catch(RuntimeException ex)
            {
                System.out.println(ex.getMessage());   
                System.out.println("Wait-List portal Closed.");
                stop = true;
            }
        }while(!stop);
        
        System.out.println();
        System.out.println("First come, first serve.");
        System.out.println();
        System.out.println("The wait-list in queue:");
        System.out.println(eventWaitlist);
       
        
        /*
        * removes the student from the CS420ListADT and at the same time add 
        * student from CS420QueueADT(in waitlist) to the list CS420ListADT
        */
        System.out.println();
        System.out.println("*******************************************************");
        System.out.println("   Welcome to the withdraw portal for CS420 event!");
        System.out.println("*******************************************************");
        System.out.println();


        stop = false;
        do{
    
           try{
               
               System.out.print("Are you a [student] or [employee]: ");
               String type = kb.next();
          
               System.out.print("Enter the first name: ");
               String firstName = kb.next();
               
               System.out.print("Enter the last name: ");
               String lastName = kb.next();
               
               System.out.print("Enter your id: ");
               int id = kb.nextInt();
               System.out.println();
               
               factory = new dikshyaUniversityFactory();
               dikshyaType = factory.createItemType(type, firstName, lastName, id);
                  
               
              removeSuccess = myEvent.remove(dikshyaType); 
               while (myEvent.size() != 10)
               {
                    System.out.println("Adding the first person from the waitlist[CS420QueueADT] to eventlist[CS420ListADT]");
                    dikshyaType = eventWaitlist.dequeue();
                    addSuccess = myEvent.add(dikshyaType);
                    if (addSuccess)
                    { 
                        dikshyaType.typeRegistered();
                        System.out.println("Pays Tuition: "+ dikshyaType.paysTuition());
                        System.out.println();
                    }
         
               }
               
               System.out.println("Registered: "+ myEvent.size());
               System.out.println("In waitlist: "+ eventWaitlist.length());
               System.out.println();
                
           }
           
           catch(RuntimeException ex)
           {
               System.out.println(ex.getMessage());
               stop = false;
           }
           
           catch(CS420Exception ex)
           {
                System.out.println(ex.getLimit() + " students registered. " + ex.getMessage()); 
                System.out.println("Try again when the space is left");
                stop = false;  
           }
            System.out.print("Withdraw more? Enter: [1] to continue / [2] to stop: ");
   
            int action1 = kb.nextInt();
            switch (action1)
            {
               case 1:
                  stop = false;
                  break;
                  
              case 2:
                  stop = true;
                  break;
                               
              default: continue;          

            }     

        }while(!stop);
        
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("                Event List");
        System.out.println("**********************************************");
        System.out.println("The total registered for the event: "+ myEvent.size());
        System.out.println();
        System.out.println(myEvent);
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("                Wait List");
        System.out.println("**********************************************");
        System.out.println("The total waitlisted for the event: "+ eventWaitlist.length());
        System.out.println();
        System.out.println(eventWaitlist);
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("                Thank you");
        System.out.println("**********************************************");
                   
    }//mainApp ends

}
