//Homework 5
//Dikshya Acharya
//CS420Exception class

public class CS420Exception extends Exception
{
    //instance variables
    private int limit;
    private String message;

    //creates an exception with studentLimit and message
    public CS420Exception(int limit, String message)
    {
        this.limit = limit;
        this.message = message;
    }

    //getter methods for limit and message
    public int getLimit()
    {   
        return this.limit;
    }
    
    public String getMessage()
    {
        return this.message;
    }

}
