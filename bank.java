package bank;

interface BankOperations 
{
    void credentialsCheck(String username, String password) throws InvalidCredentialsException;
    void credit(double amount);
    void debit(double amount) throws InsufficientBalanceException;
    void displayBalance();
    void exit();
}
class BankAccount implements BankOperations 
{
    private String username;
    private String password;
    private double balance;
		public BankAccount(String username, String password, double initialBalance) 
    {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }
		//@Override
    public void credentialsCheck(String inputUsername, String inputPassword) throws InvalidCredentialsException 
    {
        if (!username.equals(inputUsername) || !password.equals(inputPassword)) 
        {
            throw new InvalidCredentialsException("Invalid username or password. Please try again.");
        }
    }
		//@Override
    public void credit(double amount) 
    {
        balance += amount;
        System.out.println("Amount credited successfully. Updated balance: $" + balance);
    }
		//@Override
    public void debit(double amount) throws InsufficientBalanceException 
    {
        if (amount > balance) 
        {
            throw new InsufficientBalanceException("Insufficient balance. Please enter a valid debit amount.");
        }
        balance -= amount;
        System.out.println("Amount debited successfully. Updated balance: $" + balance);
    }
    //@Override
    public void displayBalance() 
    {
        System.out.println("Current Balance: $" + balance);
    }
    //@Override
    public void exit()
    {
        System.out.println("Exiting Bank Management System. Thank you!");
    }
}
class InvalidCredentialsException extends Exception 
{
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
class InsufficientBalanceException extends Exception 
{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class Bank
{
    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount("user123", "pass123", 1000.0);
        try 
        {
            userAccount.credentialsCheck("user123", "wrongpass");
            userAccount.credentialsCheck("user123", "pass123"); 

            userAccount.credit(500.0); 
            userAccount.debit(200.0); 
            userAccount.debit(1500.0); 

            userAccount.displayBalance(); 
        } 
        catch (InvalidCredentialsException | InsufficientBalanceException e) 
        {
            System.out.println("Error: " + e.getMessage());
        } 
        finally 
        {
            userAccount.exit(); 
        }
    }
}
