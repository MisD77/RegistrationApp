//Homework 5
//Dikshya Acharya
//CS420ListInterface class using generic dtaa types

public interface CS420ListInterface<T>{
    int size();
    boolean contains(T itemType); //checks if the student with given id exists in the list
    boolean add (T itemType) throws CS420Exception; //adds the student type into the list and returns true
    boolean remove(T itemType); // removes student type from the list and returns true
    @Override
    String toString(); // returns a string representation of the list
}