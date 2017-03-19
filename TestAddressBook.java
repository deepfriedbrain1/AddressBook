
package addressbook;
import java.util.*;

/**
 * TestAddressBook is a test class to verify that AddressBook objects are 
 * created correctly. 
 * 
 * // Step 1 Test Data //
 * --Data Value--   --Purpose--
 * Negative #'s     Test the invalid data
 * 0                Test the end case of invalid data
 * 1                Test the end case of valid data
 * >= 1             Test the normal cases
 * 
 * @author Alberto Fernandez Saucedo
 */
class TestAddressBook { // Step 1 TEST MAIN : TEST CONSTRUCTORS
    
    public static void main(String[] args){
        
        AddressBook myBook;
        String inputStr;
        int size;
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            
            System.out.print("Array size: ");
            inputStr = scanner.next();
            
            if (inputStr.equalsIgnoreCase("stop")){
                break;
            }
            
            size = Integer.parseInt(inputStr);
            
            try{
                
                myBook = new AddressBook(size);
            
            }catch(IllegalArgumentException e){
                System.out.println("Exception Thrown: size = " + size);
            }
        }
    }
    

}
