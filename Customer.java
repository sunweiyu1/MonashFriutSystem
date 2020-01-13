
/**
 * Store all atrributes of customers
 */
public class Customer implements Cloneable
{
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String email;
    private String phone; 
    
    /**
     * Customer constructor
     * set the intial state
     */
    public Customer()
    {
        username = "";
        firstname = "";
        lastname = "";
        password = "";
        address = "";
        email = "";
        phone = "";
    }
    
     /**
     * Customer constructor
     * set the intial state
     */
    public Customer(String username, String firstname, String lastname, String password, String address, String email, String phone)
    {
        setUsername(username);
        setFirstname(firstname);
        setLastname(lastname);
        setPassword(password);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
    }

    /**
     * Return the user name of the customer
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Return the first name of the customer
     */
    public String getFirstname()
    {
        return firstname;
    }

    /**
     * Return the last name of the customer
     */
    public String getLastname()
    {
        return lastname;
    }

    /**
     * Return the password of the customer
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Return the address of the customer
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Return the email of the customer
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Return the phone number of the customer
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Set the user name of the customer
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Set the first name of the customer
     */
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    /**
     * Set the last name of the customer
     */
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    /**
     * Set the password of the customer
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Set the address of the customer
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Set the email of the customer
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Set the phone number of the customer
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    /**
     * Set the user name of the customer
     */
    public void displayCustomerDetail()
    {
        System.out.println("{ Customer Detail }");
        System.out.println("Username: "+ getUsername()); 
        System.out.println("Firstname: " + getFirstname() );
        System.out.println("Lastname: " + getLastname() );
        System.out.println("Address: " + getAddress() );
        System.out.println("Email: " + getEmail() );
        System.out.println("Phone: " + getPhone() );
    }
    
    /**
     * Display detailed information of customer
     */
    public void displayCustomerFullDetail()
    {
        System.out.println("{ Customer Detail }");
        System.out.println("Username: " + getUsername()); 
        System.out.println("Password: " + getPassword());
        System.out.println("Firstname: " + getFirstname() );
        System.out.println("Lastname: " + getLastname() );
        System.out.println("Address: " + getAddress() );
        System.out.println("Email: " + getEmail() );
        System.out.println("Phone: " + getPhone() );
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
