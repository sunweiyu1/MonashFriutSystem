import java.util.ArrayList;

/**
 * Write a description of class AccountController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AccountController
{
    // instance variables - replace the example below with your own
    private ArrayList<Customer> customerList;
    private Customer currentCustomer;
    private UserInterface ui;

    /**
     * Constructor for objects of class AccountController
     */
    public AccountController()
    {
        // initialise instance variables
        customerList = new ArrayList();
        currentCustomer = new Customer();
        ui = new UserInterface();
    }
    
    /**
     * Set current customer
     */
    public void setCurrentCustomer(Customer cus)
    {
        currentCustomer = cus;
    }
    
    /**
     * Return current customer 
     */
    public Customer getCurrentCustomer()
    {
        return currentCustomer;
    }

    /**
     * Set customer list
     */
    public void setCustomerList(ArrayList<Customer> customerList)
    {
        this.customerList = customerList;
    }
    
    /**
     * Return customer list
     */
    public ArrayList<Customer> getCustomerList() 
    {
        return customerList;
    }
 
    /**
     * Check input whether matches owner password
     */
    public boolean isOwnerPasswordMatched(String input)
    {
        return input.equals("IamtheOwner123");
    }
    
    /**
     * Login function for customers
     */
    public void login()
    {
        System.out.println("");
        System.out.println("[ login as customer ]");
        inputUsername();
        if (!isUsernameOccupied(currentCustomer.getUsername()))
        {
            System.out.println("Username not found.");
            System.out.println("");
            SuperController.callLoginMenu();
        }
        inputPassword();
        if (isPasswordMatched(currentCustomer.getPassword()))
        {
            for (Customer cust : customerList)
                if (currentCustomer.getUsername().equals(cust.getUsername()))
                    cust.displayCustomerDetail();
            
            callCustomerMainMenu();
        }        
        else
            SuperController.callLoginMenu();
    }
    
    /**
     * Check input whether matches the customer password
     */
    public boolean isPasswordMatched(String pw)
    {
        for (Customer cust : customerList)
            if (currentCustomer.getUsername().equals(cust.getUsername()))
                if (pw.equals(cust.getPassword()))
                    return true;
        return false;
    }
    
    /**
     * Edit account information of customers
     */
    public void editAccount()
    {
        System.out.println("");
        System.out.println("[ edit account ]");
        callAccountEditMenu();
        currentCustomer.displayCustomerDetail();        
        if (UserInterface.isConfirmed())
            for (Customer cus : customerList)
                if (cus.getUsername().equals(currentCustomer.getUsername()))
                {
                    cus.setPassword(currentCustomer.getPassword());
                    cus.setFirstname(currentCustomer.getFirstname());
                    cus.setLastname(currentCustomer.getLastname());
                    cus.setAddress(currentCustomer.getAddress());
                    cus.setEmail(currentCustomer.getEmail());
                    cus.setPhone(currentCustomer.getPhone());
                }                
        currentCustomer = new Customer();
        callCustomerMainMenu();
    }
    
    /**
     * Edit account information for owner
     */
    public void editAccountAsOwner()
    {
        System.out.println("");
        System.out.println("[ edit account as owner ]");        
        callOwnerAccountEditMenu();        
        if (UserInterface.isConfirmed())
            for (Customer cus : customerList)
                if (cus.getUsername().equals(currentCustomer.getUsername()))
                {
                    cus.setUsername(currentCustomer.getUsername());
                    cus.setPassword(currentCustomer.getPassword());
                    cus.setFirstname(currentCustomer.getFirstname());
                    cus.setLastname(currentCustomer.getLastname());
                    cus.setAddress(currentCustomer.getAddress());
                    cus.setEmail(currentCustomer.getEmail());
                    cus.setPhone(currentCustomer.getPhone());
                }                
        currentCustomer = new Customer();
    }
    
    
    /**
     * Add new customer in customer list and check whether user name is occupied
     */
    public void addAccount()
    {
        System.out.println("");
        System.out.println("[ add account ]");
        inputUsername();
        while (isUsernameOccupied(currentCustomer.getUsername()))
        {
            System.out.println("Username is occupied.");
            System.out.println("Please try again");
            inputUsername();
        }
        inputPassword();
        inputFirstName();
        inputLastName();
        inputAddress();
        inputEmail();
        inputPhone();        
        currentCustomer.displayCustomerDetail();        
        if (UserInterface.isConfirmed()) //input = "Y"
        {
            try
            {
                Customer c = (Customer)currentCustomer.clone();
                customerList.add(c);
            }catch(CloneNotSupportedException e)
            {
                System.out.println("Clone Not Supported Exception.");
            }
        }        
        currentCustomer = new Customer();
    }
    
    /**
     * Register function for customers
     */
    public void register()
    {
        System.out.println("");
        System.out.println("[ register ]");
        addAccount();
        SuperController.callLoginMenu();
    }
    
    /**
     * Remove customer account from customer list 
     */
    public void removeAccount()
    {
        System.out.println("");
        System.out.println("[ remove account ]"); 
        inputPassword();       
        if (UserInterface.isConfirmed())
            for (int i = 0; i < customerList.size(); i++)
                if (customerList.get(i).getUsername().equals(currentCustomer.getUsername()))
                    customerList.remove(i);                  
        currentCustomer = new Customer();
    }
    
    /**
     * Owner removes customer account from cutomer list
     */
    public void removeAccountAsOwner()
    {
        System.out.println("");
        System.out.println("[ remove account as owner ]");
        inputUsername();
        while (!isUsernameOccupied(currentCustomer.getUsername()))
        {
            System.out.println("Username is not found.");
            System.out.println("Please try again");
            inputUsername();
        }
        
        if (UserInterface.isConfirmed())
            for (int i = 0; i < customerList.size(); i++)
                if (customerList.get(i).getUsername().equals(currentCustomer.getUsername()))
                    customerList.remove(i);         
        currentCustomer = new Customer();
    }
    
    /**
     * Customer unregister from system
     */
    public void unregister()
    {
        System.out.println("");
        System.out.println("[ unregister ]");
        removeAccount();
        SuperController.callLoginMenu();
    }
    
   /**
    * Request a user name and check the validation
    */
    public void inputUsername()//*******
    {
        String input = ui.askForUsername();
        while (!isUsernameValid(input.trim()))//*******
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your username should between 0-10 number or character. Please try again.");
            input = ui.askForUsername();
        }
        currentCustomer.setUsername(input);
    }
    
    /**
     * Check whether input user name is valid
     */
    private boolean isUsernameValid(String input)
    {
        return input.trim().length() > 0 && input.trim().length() < 10;
    }
    
    private boolean isUsernameOccupied(String input)
    {   
        for (Customer cust : customerList)
            if (input.equals(cust.getUsername()))
                return true;
        
        return false;
    }
    
    /**
     * Request first name and check the validation
     */
    public void inputFirstName()
    {
        String input = ui.askForFirstname();
        while (!isNameValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your Firstname should between 1-10 characters. Please try again.");
            input = ui.askForFirstname();
        }
        currentCustomer.setFirstname(input);
    }
    
    /**
     * Request last name and check the validation
     */
    public void inputLastName()
    {
        String input = ui.askForLastname();
        while (!isNameValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your Lastname should between 1-10 characters. Please try again.");
            input = ui.askForLastname();
        }
        currentCustomer.setLastname(input);
    }
    
   /**
    * Check whether input name is valid
    */
    public boolean isNameValid(String input)
    {
        return input.matches("^[a-zA-Z]{1,10}$");
    }
    
    /**
     * Request password and check the validation 
     */
    public void inputPassword()
    {
        String input = ui.askForPassword();
        while (!isPasswordValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your password should have more than 1 number and character, 8-16 bits. Please try again.");
            input = ui.askForPassword();
        }
        currentCustomer.setPassword(input);
    }
    
    /**
     * Check the validation of password
     */
    public boolean isPasswordValid(String input)
    {
        return input.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$");
    }
    
    /**
     * Request address and check the validation
     */
    public void inputAddress()
    {
        String input = ui.askForAddress();
        while (!isAddressValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your address should between 4-30 bits. Please try again.");
            input = ui.askForAddress();
        }
        currentCustomer.setAddress(input);
    }
    
    /**
     * Check whether address is valid
     */
    public boolean isAddressValid(String input)
    {
        return input.matches("[0-9A-Za-z_]{4,30}");
    }
    
    /**
     * Request email and check the validation
     */
    public void inputEmail()
    {
        String input = ui.askForEmail();
        while (!isEmailValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your Email should likes 'xxxx@xxxx.xxx'. Please try again.");
            input = ui.askForEmail();
        }
        currentCustomer.setEmail(input);
    }
    
    /**
     * Check whether the input is valid
     */
    public boolean isEmailValid(String input)
    {
        return input.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    }
    
    /**
     * Request phone number and check the validation
     */
    public void inputPhone()
    {
        String input = ui.askForPhone();
        while (!isPhoneValid(input))
        {
            System.out.println("Invalid input."); //Exception
            System.out.println("Your phone should have only 10 numbers. Please try again.");
            input = ui.askForPhone();
        }
        currentCustomer.setPhone(input);
    }
    
    /**
     * Check whether the input is valid
     */
    public boolean isPhoneValid(String input)
    {
        return input.matches("[0-9]{10,10}");
    }
    
    /**
     * Call main menu of customers
     */
    public void callCustomerMainMenu()
    {
        ui.displayCustomerMainMenu();
        
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
            case '1': callAccountManageMenu(); break;
            case '2': CustomerSuperController.callPurchaseMainMenu(); break;//
            case '3': SuperController.callLoginMenu(); break;
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call main account manage menu for customers
     */
    public void callAccountManageMenu()
    {
        ui.displayAccountManageMenu();
        
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
            case '1': editAccount(); break;
            case '2': unregister(); break;
            case 'R': callCustomerMainMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    

    /**
     * Call account edit menu for customer
     */
    public void callAccountEditMenu()
    {
        ui.displayAccountEditMenu();
        
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
            case '1': inputPassword(); break;
            case '2': 
                inputFirstName(); 
                inputLastName(); 
                break;
            case '3': inputPhone(); break;
            case '4': inputEmail(); break;
            case '5': inputAddress(); break;
            case 'R': callAccountManageMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Call account edit menu for owner
     */
    public void callOwnerAccountEditMenu()
    {
        ui.displayOwnerAccountEditMenu();
        
        String choices = "123456RX";
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
                inputUsername(); 
                while (isUsernameOccupied(currentCustomer.getUsername()))
                {
                    System.out.println("Username is occupied.");
                    System.out.println("Please try again");
                    inputUsername();
                }
                break;
            case '2': inputPassword(); break;
            case '3': 
                inputFirstName(); 
                inputLastName(); 
                break;
            case '4': inputPhone(); break;
            case '5': inputEmail(); break;
            case '6': inputAddress(); break;
            case 'R': callAccountManageMenu(); break; 
            case 'X': ui.close(); break; //wait to be finished
            default: break; //do not have to do anything
        }
    }
    
    /**
     * Display customer list for owner
     */
    public void displayCustomerListDetail()
    {
        System.out.println("");
        System.out.println("{ Customer List Detail }");
        for (Customer cust : customerList)
            cust.displayCustomerDetail();
    }
    
    /**
     * Display detail information for individual customers
     */
    public void displayCustomerListFullDetail()
    {
        System.out.println("");
        System.out.println("{ Customer List Detail }");
        for (Customer cust : customerList)
            cust.displayCustomerFullDetail();
    }
    
    /**
     * Test data 
     */
    public void importTestData()
    {
        Customer cus = new Customer();
        cus.setUsername("Bacon");
        cus.setPassword("abcd1234");
        cus.setFirstname("Fronsis");
        cus.setLastname("Bacon");
        cus.setAddress("abcd1234");
        cus.setEmail("abc123@abc123.com");
        cus.setPhone("123465789");
        
        customerList.add(cus);
        //callLoginMenu();
    }
    
}
