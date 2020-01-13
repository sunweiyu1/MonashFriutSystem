import java.util.ArrayList;

/**
 * Write a description of class PurchaseController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PurchaseController
{
    // instance variables - replace the example below with your own
    private ProductController productController;
    private Order cart;
    private ArrayList<Order> listOfOrders;
    private UserInterface ui;
    private OrderedProduct currentUnit;

    /**
     * Constructor for objects of class PurchaseController
     */
    public PurchaseController()
    {
        // initialise instance variables
        productController = new ProductController();
        cart = new Order();
        listOfOrders = new ArrayList();
        ui = new UserInterface();
        currentUnit = new OrderedProduct();
    }
    
    /**
     * Add items to shopping cart
     */
    public void addProductToCart()
    {
        System.out.println("");
        System.out.println("[ add new product to cart ]");
        
        //escape selection
        inputProductId();
        inputAmount();
        Product product = productController.getCurrentProduct();
        currentUnit.setProductName(product.getProductName());
        currentUnit.setProductType(product.getProductType());
        currentUnit.setLocation(product.getLocation());
        currentUnit.setSaleMethod(product.getSaleMethod());
        currentUnit.setPrice(product.getPrice());
        currentUnit.setInventory(product.getInventory());
        
        currentUnit.setInventory(currentUnit.getInventory() - currentUnit.getAmount());
        currentUnit.setCharge(currentUnit.getAmount() * currentUnit.getPrice());
        
        if (UserInterface.isConfirmed())
        {
            try
            {
                OrderedProduct p = (OrderedProduct)currentUnit.clone();
                cart.getOrder().add(p);
            }catch(CloneNotSupportedException e)
            {
                System.out.println("Clone Not Supported Exception.");
            }
        }
        
        currentUnit = new OrderedProduct();
        callCartMiniMenu();
    }
    
    /**
     * Edit details of items in cart
     */
    public void editCartDetail()
    {
        System.out.println("");
        System.out.println("[ edit product in cart ]");
        
        selectUnit();
        
        callCartDetailEditMenu();
        currentUnit.displayOrderedProductDetail();
        
        if (UserInterface.isConfirmed())
        {
            for (OrderedProduct unit : cart.getOrder())
                if (unit.getProductId().equals(currentUnit.getProductId()))
                {
                    currentUnit.setProductName(unit.getProductName());
                    currentUnit.setProductType(unit.getProductType());
                    currentUnit.setLocation(unit.getLocation());
                    currentUnit.setSaleMethod(unit.getSaleMethod());
                    currentUnit.setPrice(unit.getPrice());
                    currentUnit.setInventory(unit.getInventory());
                    currentUnit.setAmount(unit.getAmount());
                }           
        }
        
        currentUnit = new OrderedProduct();
        callCartSubmenu();
    }
    
    /**
     * Remove products from cart
     */
    public void removeProductFromCart()
    {
        System.out.println("");
        System.out.println("[ remove product from cart ]");
        
        selectUnit();
        ArrayList<OrderedProduct> listOfUnits = cart.getOrder();
        
        if (UserInterface.isConfirmed())
            for (int i = 0; i < listOfUnits.size(); i++)
                if (listOfUnits.get(i).getProductId().equals(currentUnit.getProductId()))
                    listOfUnits.remove(i);
            
        currentUnit = new OrderedProduct();
        callCartMiniMenu();
    }
    
    /**
     * Call cart mini menu
     */
    public void callCartMiniMenu()
    {
        ui.displayCartMiniMenu();
        
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
            case '1': addProductToCart(); break;
            case '2': 
                cart.displayOrderDetail(); 
                callCartSubmenu(); 
                break;
            case 'R': CustomerSuperController.callPurchaseMainMenu(); break; 
            case 'X': ui.close(); break;
            default: break; //do not have to do anything
        }
    }
    
    
    /**
     * Call cart detail edit menu
     */
    public void callCartDetailEditMenu()
    {
        ui.displayCartDetailEditMenu();
        
        String choices = "1RX";
        String choice = ui.askForMenuChoice();
        
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': editCartDetail(); break;
            case 'R': callCartMiniMenu(); break; 
            case 'X': ui.close(); break; 
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call cart submenu
     */
    public void callCartSubmenu()
    {
        ui.displayCartSubmenu();
        
        String choices = "123RX";
        String choice = ui.askForMenuChoice();
        
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': addProductToCart(); break;
            case '2': CustomerSuperController.createOrder(); break;
            case '3': 
                cart.displayOrderDetail(); 
                callCartSubmenu(); 
                break;
            case 'R': callCartMiniMenu(); break; 
            case 'X': ui.close(); break; 
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Request amount of items
     */
    public void inputAmount()
    {
        String input = "";
        input = ui.askForAmount();
        while (!isAmountValid(input))
        {
            System.out.println("Invalid product amount."); //Exception
            System.out.println("Please try again.");
            input = ui.askForAmount();
        }
        currentUnit.setAmount(Double.valueOf(input));
    }
    
    /**
     * Check whether input is a valid amount
     */
    public boolean isAmountValid(String input)
    {   
        input = input.trim();
        
        if (!UserInterface.isDoubleString(input))
            return false;
            
        if (Double.valueOf(input) <= 0.0 || Double.valueOf(input) > 100.0)
            return false;
        
        return true;
    }
    
    /**
     * Request product id 
     */
    public void inputProductId()
    {
        String input = ui.askForProductId();
        while (!ProductController.searchProduct(input))
        {
            System.out.println("Please try again.");
            input = ui.askForProductId();
        }
        currentUnit.setProductId(input);
    }
    
    /**
     * Search item from the cart
     */
    public boolean searchUnit(String productId)
    {
        boolean hasUnit = false;
        
        for (OrderedProduct unit : cart.getOrder())
            if (unit.getProductId().equals(productId))
                try
                {
                    hasUnit = true;
                    currentUnit = (OrderedProduct)unit.clone();
                    currentUnit.displayOrderedProductDetail();
                }catch(CloneNotSupportedException e)
                {
                    System.out.println("(Clone Not Supported Exception.");
                }
        
        if (!hasUnit)
            System.out.println("Not found.");
        return hasUnit;
    }
    
    /**
     * Select items from the cart
     */
    public void selectUnit()
    {
        boolean hasProduct = searchUnit(ui.askForProductId()); 
        while (!hasProduct)
        {
            System.out.println("Please try again.");
            hasProduct = searchUnit(ui.askForProductId());
        }
    }

    /**
     * Set product controller
     */
    public void setProductController(ProductController productController)
    {
        this.productController = productController;
    }
    
    /**
     * Set cart
     */
    public void setCart(Order cart)
    {
        this.cart = cart;
    }
    
    /**
     * Set order list
     */
    public void setListOfOrders(ArrayList<Order> listOfOrders)
    {
        this.listOfOrders = listOfOrders;
    }
    
    /**
     * Set current unit
     */
    public void setCurrentUnit(OrderedProduct unit)
    {
        currentUnit = unit;
    }
    
    /**
     * Set user interface
     */
    public void setUserInterface(UserInterface ui)
    {
        this.ui = ui;
    }
    
    /**
     * Return user interface
     */
    public UserInterface getUserInterface()
    {
        return ui;
    }
    
    /**
     * Return current unit
     */
    public OrderedProduct getCurrentUnit()
    {
        return currentUnit;
    }
    
    /**
     * Return order list
     */
    public ArrayList<Order> getListOfOrders()
    {
        return listOfOrders;
    }
    
    /**
     * Retrun product controller
     */
    public ProductController getProductController()
    {
        return productController;
    }
    
    /**
     * Return cart
     */
    public Order getCart()
    {
        return cart;
    }
       
    public void test()
    {
        productController.importTestData();
        productController.displayProductListDetail();
        
        Product product = productController.getListOfProduct().get(0);
        currentUnit.setProductId(product.getProductId());
        currentUnit.setProductName(product.getProductName());
        currentUnit.setProductType(product.getProductType());
        currentUnit.setLocation(product.getLocation());
        currentUnit.setSaleMethod(product.getSaleMethod());
        currentUnit.setPrice(product.getPrice());
        currentUnit.setInventory(product.getInventory());
        
        currentUnit.setInventory(currentUnit.getInventory() - currentUnit.getAmount());
        currentUnit.setCharge(currentUnit.getAmount() * currentUnit.getPrice());
        
        cart.getOrder().add(currentUnit);
        //callCartMiniMenu();
    }
}
