import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        // initialise instance variables
    }
    
    /**
     * Close the whole interface and end up the system
     */
    public void close()
    {
        System.exit(0);
    }
    
    /**
     * start of Owner main menu
     */
    public void displayOwnerMainMenu()
    {
        System.out.println("");
        System.out.println("---- Owner Main Menu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. manage products");
        System.out.println("2. manage customer accounts");
        System.out.println("3. generate business report");
        System.out.println("X. exit the MFV system");
        System.out.println("-------------------------");
    }
    
    /**
     * display Report Menu
     */
    public void displayReportMenu() //we can give it up
    {
        System.out.println("");
        System.out.println("---- Report Menu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. report all the orders with details");
        System.out.println("2. generate a self-defined report");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("---------------------");
    }
    
    /**
     * display Owner Account Manage Menu
     */
    public void displayOwnerAccountManageMenu()
    {
        System.out.println("");
        System.out.println("---- Account Manage Menu For Owner ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. add a new account");
        System.out.println("2. edit an existed account");
        System.out.println("3. remove an existed account");
        System.out.println("4. view the list of accounts");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("---------------------------------------");
    }
    
    /**
     * display Owner Account Edit Menu
     */
    public void displayOwnerAccountEditMenu()
    {
        System.out.println("");
        System.out.println("---- Account Editor For Owner ----");
        System.out.println("Please select the detail part of your account to edit: ");
        System.out.println("1. Username (unique identifier)");
        System.out.println("2. Password");
        System.out.println("3. Name");
        System.out.println("4. Phone");
        System.out.println("5. Email");
        System.out.println("6. Address");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("----------------------------------");
    }
   
    /**
     * display Login Menu
     */
    public void displayLoginMenu()
    {
        System.out.println("");
        System.out.println("---- Login Menu ----");
        System.out.println("Please choose your login type: ");
        System.out.println("1. login as an owner");
        System.out.println("2. login as an customer");
        System.out.println("3. register a new customer account");
        System.out.println("X. exit the MFV system");
        System.out.println("--------------------");
    }
    
    /**
     * display Customer Main Menu
     */
    public void displayCustomerMainMenu()
    {
        System.out.println("");
        System.out.println("---- Customer Main Menu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. manage account");
        System.out.println("2. start viewing products");
        System.out.println("3. sign out");
        System.out.println("X. exit the MFV system");
        System.out.println("----------------------------");
    }
    
    /**
     * display Account Manage Menu
     */
    public void displayAccountManageMenu()
    {
        System.out.println("");
        System.out.println("---- Account Manage Menu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. edit account");
        System.out.println("2. unregister");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("-----------------------------");
    }
    
    /**
     * display Account Edit Menu
     */
    public void displayAccountEditMenu()
    {
        System.out.println("");
        System.out.println("---- Account Editor ----");
        System.out.println("Please select the detail part of your account to edit: ");
        System.out.println("1. Password");
        System.out.println("2. Name");
        System.out.println("3. Phone");
        System.out.println("4. Email");
        System.out.println("5. Address");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("------------------------");
    }
    
    /**
     * Request a user name
     */
    public String askForUsername()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your username: ");
        return scan.nextLine();
    }
    
    /**
     * Request first name of user
     */
    public String askForFirstname()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your firstname: ");
        return scan.nextLine();
    }
    
    /**
     * Request last name of user
     */
    public String askForLastname()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your lastname: ");
        return scan.nextLine();
    }
    
    /**
     * Request password of user
     */
    public String askForPassword()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your password: ");
        return scan.nextLine();
    }
    
    /**
     * Request address of user
     */
    public String askForAddress()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your address: ");
        return scan.nextLine();
    }
    
    /**
     * Request email of user
     */
    public String askForEmail()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your email address: ");
        return scan.nextLine();
    }
    
    /**
     * Request phone number of user
     */
    public String askForPhone()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your phone: ");
        return scan.nextLine();
    }
    
    /**
     * display Purchase Main Menu
     */
    public void displayPurchaseMainMenu()
    {
        System.out.println("");
        System.out.println("---- Monash Fruit & Vegetables ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. search product by product id");
        System.out.println("2. search product by name");
        System.out.println("3. search product by type");
        System.out.println("4. search product by location");
        System.out.println("5. view the entire product list");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("-----------------------------------");
    }
    
    /**
     * display Cart Mini Menu
     */
    public void displayCartMiniMenu()
    {
        System.out.println("");
        System.out.println("---- Cart Main Menu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. add product to cart");
        System.out.println("2. view cart");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("------------------------");
    }
    
    /**
     * display Cart Submenu
     */
    public void displayCartSubmenu()
    {
        System.out.println("");
        System.out.println("---- Cart Submenu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. edit cart");
        System.out.println("2. place order");
        System.out.println("3. keep browsing");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("----------------------");
    }
    
    /**
     * display Cart Detail Edit Menu
     */
    public void displayCartDetailEditMenu()
    {
        System.out.println("");
        System.out.println("---- Unit Editor ----");
        System.out.println("Please select the attribute of unit to edit: ");
        System.out.println("1. Amount");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("------------------------");
    }
    
    /**
     * Request amount of items
     */
    public String askForAmount()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the amount for a product to be ordered:");
        return scan.nextLine();
    }
    
    /**
     * display Product Main Menu
     */
    public void displayProductMainMenu()
    {
        System.out.println("");
        System.out.println("---- Product Management ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. view the product list");
        System.out.println("2. add a new product to the list");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("----------------------------");
    }
    
    /**
     * display Product List Submenu
     */
    public void displayProductListSubmenu()
    {
        System.out.println("");
        System.out.println("---- Product List Submenu ----");
        System.out.println("Please select the service from: ");
        System.out.println("1. add a new product to the list");
        System.out.println("2. remove a product from the list");
        System.out.println("3. edit details for a product");
        System.out.println("4. view the list of products");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("------------------------------");
    }
    
    /**
     * display Product Detail Edit Menu
     */
    public void displayProductDetailEditMenu()
    {
        System.out.println("");
        System.out.println("---- Product Editor ----");
        System.out.println("Please select the attribute of product to edit: ");
        System.out.println("1. Name");
        System.out.println("2. Type");
        System.out.println("3. Location");
        System.out.println("4. Price");
        System.out.println("5. Sale method");
        System.out.println("6. Shelf life");
        System.out.println("7. Inventory");
        System.out.println("R. return to the previous menu");
        System.out.println("X. exit the MFV system");
        System.out.println("------------------------");
    }
    
    /**
     * Request menu choice
     */
    public String askForMenuChoice()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your choice: ");
        return scan.nextLine();
    }
    
    /**
     * Request confirmation for users
     */
    public static String askForConfirmation()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please confirm before the system changes the list of the product: [Y/N]");
        System.out.println("The system will return to the previous menu if \"N\" is chosen.");
        return scan.nextLine();
    }
    
    /**
     * Request product id 
     */
    public String askForProductId()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the Id for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Request product name 
     */
    public String askForProductName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the name for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Request product type
     */
    public String askForProductType()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the type for the product: ");
        System.out.println("The types can be: \"vegetable\", \"fruit\" and \"others\"");
        return scan.nextLine();
    }
    
    /**
     * Request product location
     */
    public String askForProductLocation()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the location for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Request product price
     */
    public String askForProductPrice()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the price (AUD) for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Request product sale method 
     */
    public String askForProductSaleMethod()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the sale method for the product: ");
        System.out.println("The sale methods can be: \"kg\", \"ml\" and \"each\"");
        return scan.nextLine();
    }
    
    /**
     * Request product shelf life
     */
    public String askForProductShelfLife()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the shelf life (days) for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Request product inventory
     */
    public String askForProductInventory()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the inventory for the product: ");
        return scan.nextLine();
    }
    
    /**
     * Check whether input is valid choice
     */
    public static boolean isChoiceValid(String choices, String choice)
    {
        choice = choice.trim();
        
        if (choice.length() != 1)
            return false;
        
        for (int i = 0; i < choices.length(); i++)
            if (choice.charAt(0) == (choices.charAt(i)))
                return true;
        
        return false;   
    }
    
    /**
     * Check whether input is a valid confirmation
     */
    public static boolean isConfirmationValid(String choice)
    {
        choice = choice.trim().toUpperCase();
        
        if (choice.length() != 1)
            return false;
        
        if (!choice.equals("Y") && !choice.equals("N"))
            return false;   
            
        return true;
    }
    
    
    /**
     *  Confirm the changes
     */
    public static boolean isConfirmed()
    {
        String input = "";
        boolean result = false;
        input = askForConfirmation();
        while (!isConfirmationValid(input))
        {
            System.out.println("Invalid confirmation input."); //Exception
            System.out.println("Please try again.");
            input = askForConfirmation();
        }

        switch (input.trim().toUpperCase().charAt(0))
        {
            case 'Y': result = true; break;
            case 'N': result = false; break;
            default: break;
        }
        
        return result;
    }
    
    /**
     * Check whether the input is double
     */
    public static boolean isDoubleString(String input)
    {
        input = input.trim();
        
        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i))) 
                continue;
                
            if (input.charAt(i) != '.')
                return false;
        }
        
        return true;
    }
    
    public static String askForCardNumber()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your card number");
        return scan.nextLine();
    }

    public static String askForPaymentPassword()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your password");
        return scan.nextLine();
    }

    public static void PaymentSuccessfully()
    {
        System.out.println("Successfulpayment");
        System.out.println("-----------");
    }

    public static void PaymentFail()
    {
        System.out.println("Sorry, something wrong,please try again.");
    }
    /*
     * end of methods for valid human-computer interaction
     */
    
    //public static void main(String[] args){;}
}
