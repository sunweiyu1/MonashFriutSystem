import java.util.ArrayList;
/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Order
{
    private String orderId;
    private String customerId;
    private ArrayList<OrderedProduct> order;
    private String orderState;

    /**
     * Constructor of order class
     */
    public Order()
    {
        orderId = "";
        customerId = "";
        order = new ArrayList();
        orderState = "not offered";
    }

    /**
     * Set order id 
     */
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    /**
     * Return order id 
     */
    public String getOrderId()
    {
        return orderId;
    }

    /**
     * Set customer id 
     */
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    /**
     * Return customer id 
     */
    public String getCustomerId()
    {
        return customerId;
    }

    /**
     * Set order list
     */
    public void setOrder(ArrayList<OrderedProduct> order)
    {
        this.order = order;
    }

    /**
     * Return order list
     */
    public ArrayList<OrderedProduct> getOrder()
    {
        return order;
    }

    /**
     * Return order states
     */
    public String getOrderState()
    {
        return orderState;
    }

    /**
     * Set order state
     */
    public void setOrderState(String orderState)
    {
        this.orderState = orderState;
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    /**
     * Displau order detail
     */
    public void displayOrderDetail()
    {
        System.out.println("");
        System.out.println("{ Order Detail }");
        System.out.println("Order Id: " + orderId);
        System.out.println("Customer Id: " + customerId);
        for (OrderedProduct product : order)
            product.displayOrderedProductDetail();
        System.out.println("Order State: " + orderState);
    }
}
