import java.util.Scanner;

public class Calculator {


    static int add(int a, int b)
    {
        return a + b;
    }


    static int subtract(int a, int b)
    {
        return a - b;
    }

    static int multiply(int a, int b)
    {
        return a * b;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter operation (+, -, *): ");
        char op = sc.next().charAt(0);

        int result = 0;


        if (op == '+')
        {
            result = add(num1, num2);
        } else if (op == '-')
        {
            result = subtract(num1, num2);
        } else if (op == '*')
        {
            result = multiply(num1, num2);
        } else
        {
            System.out.println("Invalid operation!");
            System.exit(0);
        }

        System.out.println("Result: " + result);


    }
}