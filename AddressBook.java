package addressbook;

/**
 * The AddressBook class manages a collection of Person objects.
 * An AddressBook object will allow the programmer to add, delete, or
 * search for a Person object in the address book. The user can
 * specify the size of the address book when it is created.
 * Default size is set to 50 Person objects. This class will follow
 * the single-task object (STO or cohesion) principle. 
 * 
 * NOTE: this class uses a fixed array to demonstrate the handling of 
 *       an array overflow condition. 
 * 
 * @author Alberto Fernandez Saucedo
 */

class AddressBook {

    private static final int DEFAULT_SIZE = 50;
    private static final int NOT_FOUND = -1;
    private Person[] entry;
    
    private int count;  // number of elements in the array,
                        // which is also the position at which to add
                        // the next Person object
    
    
    // Constructors 
    public AddressBook(){
        this(DEFAULT_SIZE);
    }
    
    public AddressBook(int size){
        
        count = 0;
        
        if(size <= 0){
            throw new IllegalArgumentException("Size must be positive.");
        }
        
        entry = new Person[size];
        
        System.out.print("array of " + size + " is created. "); // TEMP for testing
    }
    
    public void add(Person newPerson){
        
        assert count >= 0 && count <= entry.length;
        
        if(count == entry.length){
            expand();
        }
        
        entry[count] = newPerson;
        count++;
        
        System.out.println("Size of array: " + entry.length); // TEMP for testing
    }
    
    public Person search(String searchName){
        Person foundPerson;
        int index = 0;
        
        assert count>= 0 && count <= entry.length;
        
        while (index < count && 
                !searchName.equals(entry[index].getName())){
            
            index++;
                    
        }
        
        if (index == count){
          
            foundPerson = null;
        
        }else{
            foundPerson = entry[index];
        }
        
        return foundPerson;     
    }
    
    private void expand(){
        
        int newSize = entry.length * 2; // double the size of entry (array)
        Person[] temp = new Person[newSize];
        
        for(int i = 0; i < entry.length; i++){
            temp[i] = entry[i];
        }
        
        entry = temp;
        
    }
    
    private int findIndex(String searchName){
        
        int index = 0;
        
        assert count >= 0 && count <= entry.length;
        
        while (index < count &&
                !searchName.equals(entry[index].getName())){
            
            index++;
        }
        
        if (index == count){
            index = NOT_FOUND;
        }
        
        return index;
    }
    
    public boolean delete(String searchName){
        
        boolean status;
        int index;
        
        index = findIndex(searchName);
        
        if (index == NOT_FOUND){
            
            status = false;
            
        }else{
            
            entry[index] = entry[count - 1];
            
            status = true;
            count--;
            
            assert count >= 0 && count <= entry.length;
            
        }
        
        return status;
    }
}
