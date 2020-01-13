import java.util.ArrayList;

/**
 * Write a description of class ProductController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductController
{
    private static ArrayList<Product> listOfProducts;
    private static Product currentProduct;
    private UserInterface ui;

    /**
     * Constructor for objects of class ProductController
     */
    public ProductController()
    {
        // initialise instance variables
        listOfProducts = new ArrayList();
        currentProduct = new Product();
        ui = new UserInterface();
    }
    
    /**
     * Add product to the array list
     */
    public void addProduct()
    {
        System.out.println("");
        System.out.println("[ add new product ]");
        
        //escape selection
        inputProductId();
        inputProductName();
        inputProductType();
        inputProductLocation();
        inputProductShelfLife();
        inputProductSaleMethod();
        inputProductPrice();
        inputProductInventory();

        currentProduct.displayProductDetail();
        
        if (UserInterface.isConfirmed()) //input = "Y"
        {
            try
            {
                Product p = (Product)currentProduct.clone();
                listOfProducts.add(p);
            }catch(CloneNotSupportedException e)
            {
                System.out.println("Clone Not Supported Exception.");
            }
        }
        
        currentProduct = new Product();
        callProductMainMenu();
    }
    
    /**
     * Search product in array list by prodcut id 
     */
    public static boolean searchProduct(String productId)
    {
        boolean hasProduct = false; 
        
        for (Product product : listOfProducts)
            if (product.getProductId().equals(productId))
                try
                {
                    hasProduct = true;
                    currentProduct = (Product)product.clone();
                    currentProduct.displayProductDetail();
                }catch(CloneNotSupportedException e)
                {
                    System.out.println("(Clone Not Supported Exception.");
                }
        
        if (!hasProduct)
            System.out.println("Not found.");
        return hasProduct;
    }
    
    /**
     * Search product in array list by product name
     */
    public String searchProductIdByName()
    {
        String input = ui.askForProductName();
        String output = "";
        
        for (Product p : listOfProducts)
            if (p.getProductName().equals(input))
                output = p.getProductId();
        
        return output;
    }
    
    /**
     * Search product in array list by product type
     */
    public String searchProductIdByType()
    {
        String input = ui.askForProductType();
        String output = "";
        
        for (Product p : listOfProducts)
            if (p.getProductType().equals(input))
                output = p.getProductId();
        
        return output;
    }
    
    /**
     * Search products in array list by location
     */
    public String searchProductIdByLocation()
    {
        String input = ui.askForProductLocation();
        String output = "";
        
        for (Product p : listOfProducts)
            if (p.getLocation().equals(input))
                output = p.getProductId();
        
        return output;
    }
    
    /**
     * Select products by product id 
     */
    public void selectProduct(String productId)
    {
        for (Product p : listOfProducts)
            try
            {
                currentProduct = (Product)p.clone();
                currentProduct.displayProductDetail();
            }catch(CloneNotSupportedException e)
            {
                System.out.println("(Clone Not Supported Exception.");
            }
    }
    
    /**
     * Select product
     */
    public void selectProduct()
    {
        boolean hasProduct = searchProduct(ui.askForProductId()); 
        while (!hasProduct)
        {
            System.out.println("Please try again.");
            hasProduct = searchProduct(ui.askForProductId());
        }
    }
    
    /**
     * Edit products
     */
    public void editProduct()
    {
        System.out.println("");
        System.out.println("[ edit product ]");
        
        selectProduct();

        callProductDetailEditMenu();
        currentProduct.displayProductDetail();
        
        if (UserInterface.isConfirmed()) //input = "Y"
            for (Product product : listOfProducts)
                if (product.getProductId().equals(currentProduct.getProductId()))
                {
                    product.setProductName(currentProduct.getProductName());
                    product.setProductType(currentProduct.getProductType());
                    product.setLocation(currentProduct.getLocation());
                    product.setPrice(currentProduct.getPrice());
                    product.setSaleMethod(currentProduct.getSaleMethod());
                    product.setInventory(currentProduct.getInventory());
                    product.setShelfLife(currentProduct.getShelfLife());
                }
        
        currentProduct = new Product();
        callProductMainMenu();
    }
    
    /**
     * Remove products
     */
    public void removeProduct()
    {   
        System.out.println("");
        System.out.println("[ remove product ]");
        
        selectProduct();
        
        if (UserInterface.isConfirmed()) //input = "Y"
            for (int i = 0; i < listOfProducts.size() ; i++)
                if (listOfProducts.get(i).getProductId().equals(currentProduct.getProductId()))
                    listOfProducts.remove(i);
        
        currentProduct = new Product();
        callProductMainMenu();
    }
    
    /**
     * Call product main menu
     */
    public void callProductMainMenu()
    {
        ui.displayProductMainMenu();
        
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
                displayProductListDetail(); 
                callProductListMenu();
                break;
            case '2': addProduct(); break;
            case 'R': CustomerSuperController.getAccountController().callCustomerMainMenu(); break; 
            case 'X': ui.close(); break; 
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call product menu for owner
     */
    public void callProductListMenu()
    {
        ui.displayProductListSubmenu();
        
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
            case '1': addProduct(); break;
            case '2': removeProduct(); break;
            case '3': editProduct(); break;
            case '4': displayProductListDetail(); callProductListMenu(); break;
            case 'R': callProductMainMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call product edit menu
     */
    private void callProductDetailEditMenu()
    {
        ui.displayProductDetailEditMenu();
        
        String choices = "1234567RX";
        String choice = ui.askForMenuChoice();
        
        while (!UserInterface.isChoiceValid(choices, choice))
        {
            System.out.println("The input value for menu choice is invalid."); //Exception
            System.out.println("Please try again.");
            choice = ui.askForMenuChoice();
        }
        
        switch (choice.trim().toUpperCase().charAt(0))
        {
            case '1': inputProductName(); break;
            case '2': inputProductType(); break;
            case '3': inputProductLocation(); break;
            case '4': inputProductPrice(); break;
            case '5': inputProductSaleMethod(); break;
            case '6': inputProductShelfLife(); break;
            case '7': inputProductInventory(); break;
            case 'R': callProductMainMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Request product id 
     */
    public void inputProductId()
    {
        String input = ui.askForProductId();
        while (isProductIdOccupied(input))
        {
            System.out.println("Occupied product id."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductId();
        }
        currentProduct.setProductId(input);
    }
    
    private boolean isProductIdOccupied(String input)
    {   
        for (Product product : listOfProducts)
            if (input.equals(product.getProductId()))
                return true;
        
        return false;
    }
    
    /**
     * Request product name
     */
    public void inputProductName()
    {
        String input = ui.askForProductName();
        currentProduct.setProductName(input);
    }
    
    /**
     * Request product type
     */
    public void inputProductType()
    {
        String input = ui.askForProductType();
        while (!isTypeValid(input))
        {
            System.out.println("Invalid product type."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductType();
        }
        currentProduct.setProductType(input);
    }
    
    /**
     * Check input of product type whether is valid
     */
    private boolean isTypeValid(String input)
    {
        ArrayList<String> typeSet = new ArrayList();
        input = input.trim();
        
        typeSet.add("vegetable");
        typeSet.add("fruit");
        typeSet.add("others");
        
        for (String type : typeSet)
            if (input.equals(type))
                return true;
                
        return false;
    }
    
    /**
     * Request product location
     */
    public void inputProductLocation()
    {
        String input = ui.askForProductLocation();
        currentProduct.setLocation(input);
    }
    
    /**
     * Request product price
     */
    public void inputProductPrice()
    {
        String input = ui.askForProductPrice();
        while (!isPriceValid(input))
        {
            System.out.println("Invalid price."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductPrice();
        }
        currentProduct.setPrice(Double.valueOf(input));
    }
    
    /**
     * Check whether input price is valid 
     */
    private boolean isPriceValid(String input) //dollars
    {
        input = input.trim();
        
        if (!UserInterface.isDoubleString(input))
            return false;
        
        if (Double.valueOf(input) < 0.0 || Double.valueOf(input) > 10000.0)
            return false;
        
        return true;
    }
    
    /**
     * Request sale method 
     */
    public void inputProductSaleMethod()
    {
        String input = ui.askForProductSaleMethod();
        while (!isSaleMethodValid(input))
        {
            System.out.println("Invalid sale method."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductSaleMethod();
        }
        currentProduct.setSaleMethod(input);
    }
    
    /**
     * Check whether input is a valid sale method
     */
    private boolean isSaleMethodValid(String input)
    {
        ArrayList<String> saleMethodSet = new ArrayList();
        input = input.trim();
        
        saleMethodSet.add("kg");
        saleMethodSet.add("each");
        saleMethodSet.add("ml");
        
        for (String saleMethod : saleMethodSet)
            if (input.equals(saleMethod))
                return true;

        return false;
    }
    
    
    /**
     * Request shelf life of the products
     */
    public void inputProductShelfLife()
    {
        String input = ui.askForProductShelfLife();
        while (!isShelfLifeValid(input))
        {
            System.out.println("Invalid shelf life."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductShelfLife();
        }
        currentProduct.setShelfLife(Integer.valueOf(input));
    }
    
    /**
     * Check whether input is a valid shelf life
     */
    private boolean isShelfLifeValid(String input) //days
    {
        input = input.trim();
        
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                return false;
                
        if (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 1000)
            return false;
        
        return true;
    }
    
    /**
     * Request product inventory
     */
    public void inputProductInventory()
    {
        String input = ui.askForProductInventory();
        while (!isInventoryValid(input))
        {
            System.out.println("Invalid inventory."); //Exception
            System.out.println("Please try again.");
            input = ui.askForProductInventory();
        }
        currentProduct.setInventory(Double.valueOf(input));
    }
    
    /**
     * Check whether input is a valid inventory
     */
    private boolean isInventoryValid(String input)
    {
        input = input.trim();
        
        if (!UserInterface.isDoubleString(input))
            return false;
            
        if (Double.valueOf(input) < 0.0 || Double.valueOf(input) > 10000.0)
            return false;
        
        return true;
    }
    
    /**
     * Set product list
     */
    public void setListOfProduct(ArrayList<Product> listOfProducts)
    {
        this.listOfProducts = listOfProducts;
    }
    
    /**
     * Set current product 
     */
    public void setCurrentProduct(Product currentProduct)
    {
        this.currentProduct = currentProduct;
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
     * Return product list
     */
    public ArrayList<Product> getListOfProduct()
    {
        return listOfProducts;
    }
    
    /**
     * Return current product
     */
    public Product getCurrentProduct()
    {
        return currentProduct;
    }
    
    /**
     * Display entire product list
     */
    public void displayProductListDetail()
    {
        System.out.println("");
        System.out.println("{ Product List Detail }");
        for (Product product : listOfProducts)
            product.displayProductDetail();
    }
    
    /**
     * Import data
     */
    public void importTestData()
    {
        Product p1 = new Product();
        p1.setProductId("0001");
        p1.setProductName("Lemon");
        p1.setProductType("fruit");
        p1.setLocation("VIC");
        p1.setSaleMethod("kg");
        p1.setPrice(18.0);
        p1.setShelfLife(20);
        p1.setInventory(450.5);
        
        Product p2 = new Product();
        p2.setProductId("0002");
        p2.setProductName("Onion");
        p2.setProductType("Vegetable");
        p2.setLocation("TAS");
        p2.setSaleMethod("kg");
        p2.setPrice(2.0);
        p2.setShelfLife(15);
        p2.setInventory(90.0);
        
        listOfProducts.add(p1);
        listOfProducts.add(p2);
    }
}
