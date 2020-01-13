
/**
 * Write a description of class OwnerSuperController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OwnerSuperController
{
    // instance variables - replace the example below with your own
    private static AccountController accountController;
    private static ProductController productController;
    private static PurchaseController purchaseController;
    private static UserInterface ui;

    /**
     * Constructor for objects of class OwnerSuperController
     */
    public OwnerSuperController()
    {
        // initialise instance variables
        accountController = new AccountController();
        productController = new ProductController();
        purchaseController = new PurchaseController();
        ui = new UserInterface();
    }

    /**
     * Constructor for objects of class OwnerSuperController
     */
    public OwnerSuperController(AccountController accC, ProductController proC, PurchaseController purC)
    {
        accountController = accC;
        productController = proC;
        purchaseController = purC;
        ui = new UserInterface();
    }
    
    /**
     * Call owner main menu
     */
    public void callOwnerMainMenu()
    {
        ui.displayOwnerMainMenu();
        
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
            case '1': productController.callProductMainMenu(); break;
            case '2': 
                accountController.displayCustomerListFullDetail();
                callOwnerAccountManageMenu(); 
                break;
            case '3': callReportMenu(); break; 
            case 'X': ui.close(); break;
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call report menu
     */
    public void callReportMenu()
    {
        ui.displayReportMenu();
        String choices = "12RX";
        String choice = ui.askForMenuChoice();
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': 
                System.out.println("report all the orders with details.");
                callOwnerMainMenu(); 
                break; //report all the orders with details
            case '2': 
                System.out.println("The function is not available now.");
                callOwnerMainMenu(); 
                break; 
            case 'R': callOwnerMainMenu(); break; 
            case 'X': ui.close(); break;
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call owner account manage menu
     */
    public void callOwnerAccountManageMenu()
    {
        ui.displayOwnerAccountManageMenu();
        
        String choices = "1234RX";
        String choice = ui.askForMenuChoice();
        
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': 
                accountController.addAccount(); 
                callOwnerAccountManageMenu(); 
                break;
            case '2': 
                accountController.editAccount(); 
                callOwnerAccountManageMenu(); 
                break;
            case '3': 
                accountController.removeAccountAsOwner(); 
                callOwnerAccountManageMenu(); 
                break;
            case '4': 
                accountController.displayCustomerListFullDetail(); 
                callOwnerAccountManageMenu(); 
                break;
            case 'R': callOwnerMainMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Return account controller
     */
    public static AccountController getAccountController()
    {
        return accountController;
    }
    
    /**
     * Set account controller
     */
    public static void setAccountController(AccountController aC)
    {
        accountController = aC;
    }
    
    /**
     * Return product controller
     */
    public static ProductController getProductController()
    {
        return productController;
    }
    
    /**
     * Set product controller
     */
    public static void setProductController(ProductController pC)
    {
        productController = pC;
    }
    
    /**
     * Return purchase controller
     */
    public static PurchaseController getPurchaseController()
    {
        return purchaseController;
    }
    
    /**
     * Set purchase controller
     */
    public static void setPurchaseController(PurchaseController pC)
    {
        purchaseController = pC;
    }
    
    /**
     * Return user interface
     */
    public UserInterface getUI()
    {
        return ui;
    }
    
    /**
     * Set user interface
     */
    public void setUI(UserInterface ui)
    {
        this.ui = ui;
    }
}
