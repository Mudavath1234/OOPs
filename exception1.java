import java.util.InputMismatchException;
import java.util.Scanner;

public class exception1 
{
    public static void main(String[] args) 
    {
    		Scanner scanner = new Scanner(System.in);
				try 
        {
            System.out.print("Enter a numeric value: ");
            double numericInput =scanner.nextDouble();
            System.out.println("You entered: " + numericInput);
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Error: Please enter a valid numeric value.");
        } 
    }
}
