import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a description of class CustomerSuperController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerSuperController
{
    // instance variables - replace the example below with your own
    private static AccountController accountController;
    private static ProductController productController;
    private static PurchaseController purchaseController;
    private static UserInterface ui;

    /**
     * Constructor for objects of class CustomerSuperController
     */
    public CustomerSuperController()
    {
        // initialise instance variables
        accountController = new AccountController();
        productController = new ProductController();
        purchaseController = new PurchaseController();
        ui = new UserInterface();
    }
    
    /**
     * Constructor for objects of class CustomerSuperController
     */
    public CustomerSuperController(AccountController accC, ProductController proC, PurchaseController purC)
    {
        accountController = accC;
        productController = proC;
        purchaseController = purC;
        ui = new UserInterface();
    }
    
    /**
     * Create an order
     */
    public static void createOrder()
    {
        Order order = new Order();
        order.setOrderState("offered");
        order.setCustomerId(accountController.getCurrentCustomer().getUsername());
        order.setOrder(purchaseController.getCart().getOrder());        
        String orderId = "";
        orderId += order.getCustomerId();
        orderId += " - ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
        orderId += dateFormat.format(new Date());
        order.setOrderId(orderId);
        
        if (UserInterface.isConfirmed())
            purchaseController.getListOfOrders().add(order);
        
        purchaseController.getListOfOrders().get(
            purchaseController.getListOfOrders().size() - 1 ).displayOrderDetail();
            ui.askForCardNumber();
            ui.askForPaymentPassword();
            ui.PaymentSuccessfully();
    }
    
    /**
     * Call purchase main menu
     */
    public static void callPurchaseMainMenu()
    {
        ui.displayPurchaseMainMenu();
        
        String choices = "12345RX";
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
                productController.selectProduct();
                productController.getCurrentProduct().displayProductDetail();
                purchaseController.callCartMiniMenu();
                break;
            case '2': 
                productController.selectProduct(productController.searchProductIdByName()); 
                purchaseController.callCartMiniMenu();
                break;
            case '3': 
                productController.selectProduct(productController.searchProductIdByType()); 
                purchaseController.callCartMiniMenu();
                break;
            case '4': 
                productController.selectProduct(productController.searchProductIdByLocation()); 
                purchaseController.callCartMiniMenu();
                break;
            case '5': 
                productController.displayProductListDetail(); 
                purchaseController.callCartMiniMenu();
                break;
            case 'R': accountController.callCustomerMainMenu(); break; 
            case 'X': break; //wait to be finished
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
     * Set purchase controller
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
