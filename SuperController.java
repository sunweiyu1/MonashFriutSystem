
/**
 * Write a description of class SuperController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperController
{
    // instance variables - replace the example below with your own
    private static OwnerSuperController ownerSuperC;
    private static CustomerSuperController custSuperC;
    private static UserInterface ui;

    /**
     * Constructor for objects of class SuperController
     */
    public SuperController()
    {
        // initialise instance variables
        ownerSuperC = new OwnerSuperController();
        custSuperC = new CustomerSuperController();
        ui = new UserInterface();
    }
    
    /**
     * Return customer super controller
     */
    public static CustomerSuperController getCustSuperC()
    {
        return custSuperC;
    }
    
    /**
     * Call login menu
     */
    public static void callLoginMenu()
    {
        ui.displayLoginMenu();
        
        String choices = "123X";
        String choice = ui.askForMenuChoice();
        
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': loginAsOwner(); break;
            case '2': custSuperC.getAccountController().login(); break;
            case '3': custSuperC.getAccountController().register(); break;
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Log in function for owner
     */
    public static void loginAsOwner()
    {
        System.out.println("");
        System.out.println("[ login as owner]");
        
        custSuperC.getAccountController().inputPassword();
        
        if (custSuperC.getAccountController().isOwnerPasswordMatched(custSuperC.getAccountController().getCurrentCustomer().getPassword()))
        {
            custSuperC.getAccountController().setCurrentCustomer(new Customer());
        }
        else
        {
            custSuperC.getAccountController().setCurrentCustomer(new Customer());
            callLoginMenu();
        }
        
        ownerSuperC.callOwnerMainMenu();
    }

    /**
     * 
     */
    public void test()
    {
        custSuperC.getAccountController().importTestData();
        custSuperC.getProductController().importTestData();
        ownerSuperC.setAccountController(custSuperC.getAccountController());
        ownerSuperC.setProductController(custSuperC.getProductController());
        ownerSuperC.setPurchaseController(custSuperC.getPurchaseController());
        
        callLoginMenu();
    }

}
