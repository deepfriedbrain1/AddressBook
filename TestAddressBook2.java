package addressbook;

/**
 *TestAddressBook2 class used to test Step 2 Test Data
 * 
 * // Step 2 Test Data //
 *--Test Sequence--                 --Purpose--
 * Create the array of size 4       Test array is created correctly
 * Add four Person objects          Test Person objects are added correctly
 * Add fifth Person object          Test that the new array is created and the 
 *                                  Person object is added correctly to new
 *                                  array.
 * 
 * @author Alberto Fernandez Saucedo
 */
class TestAddressBook2 {
    
    public static void main(String[] args){
        
        AddressBook myBook;
        Person person;
        
        myBook = new AddressBook(4);
        
        for (int i = 0; i < 4; i++){
            person = new Person("Person" + i, 'U', 1);
            myBook.add(person);
        }
        
        person = new Person("fifth person", 'U', 1);
        myBook.add(person);
        
    }
}
