
/**
 * Write a description of class Product here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Product implements Cloneable
{
    private String productId;
    private String productName;
    private String productType;
    private String location;
    private String saleMethod;
    private int shelfLife;
    private double price;
    private double inventory;
    
    /**
     * Contructor of product class
     */
    public Product()
    {
        productId = "0000";
        productName = "None";
        productType = "vegetable";
        location = "None";
        saleMethod = "each";
        shelfLife = 1;
        price = 0.0;
        inventory = 0.0;
    }
    
    /**
     * Set Product id 
     */
    public void setProductId(String productId)
    {
        this.productId = productId;
    }
    
    /**
     * Set product name 
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    /**
     * Set product type
     */
    public void setProductType(String productType)
    {
        this.productType = productType;
    }
    
    /**
     * Set product location
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    /**
     * Set sale method 
     */
    public void setSaleMethod(String saleMethod)
    {
        this.saleMethod = saleMethod;
    }
    
    /**
     * Set shelf life
     */
    public void setShelfLife(int shelfLife)
    {
        this.shelfLife = shelfLife;
    }
    
    /**
     * Set price of products
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /**
     * Set inventory of products
     */
    public void setInventory(double inventory)
    {
        this.inventory = inventory;
    }
    
    /**
     * Returm product id 
     */
    public String getProductId()
    {
        return productId;
    }
    
    /**
     * Return product name 
     */
    public String getProductName()
    {
        return productName;
    }
    
    /**
     * Return product typoe
     */
    public String getProductType()
    {
        return productType;
    }
    
    /**
     * Return location of products
     */
    public  String getLocation()
    {
        return location;
    }
    
    /**
     * Return sale method of products
     */
    public String getSaleMethod()
    {
        return saleMethod;
    }
    
    /**
     * Return shelf life of products
     */
    public int getShelfLife()
    {
        return shelfLife;
    }
    
    /**
     * Return price of products
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Return inventory of products
     */
    public double getInventory()
    {
        return inventory;
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    /**
     * Display product details
     */
    public void displayProductDetail()
    {
        System.out.println("{ Product Detail }");
        System.out.println("Product Id: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Type: " + productType);
        System.out.println("Location: " + location);
        System.out.println("Price: " + price);
        System.out.println("Shelf Life: " + shelfLife);
        System.out.println("Inventory: " + inventory + " (" + saleMethod + ")");
    }
}
