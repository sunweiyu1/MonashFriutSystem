
/**
 * Write a description of class OrderedProduct here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderedProduct extends Product
{
    // instance variables - replace the example below with your own
    private double amount;
    private double charge;

    /**
     * Constructor for objects of class OrderedProduct
     */
    public OrderedProduct()
    {
        // initialise instance variables
        super();
        amount = 0.0;
        charge = 0.0;
    }

    /**
     * Set amount of items
     */
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    
    /**
     * Set charge
     */
    public void setCharge(double charge)
    {
        this.charge = charge;
    }
    
    /**
     * Return amount
     */
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * Return charge
     */
    public double getCharge()
    {
        return charge;
    }
    
    /**
     * Display order product details
     */
    public void displayOrderedProductDetail()
    {
        System.out.println("{ Ordered Product Detail }");
        System.out.println("Product Id: " + getProductId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Location: " + getLocation());
        System.out.println("Price: " + getPrice() );
        System.out.println("Amount: " + amount + " (" + getSaleMethod() + ")");
        System.out.println("Charge: " + charge);
    }
}
