import java.util.Scanner;

class Bank {
    String accName;
    int accNum;
    double balance;

    Bank(String accName, int accNum, double depositAmount) {
        this.accName = accName;
        this.accNum = accNum;
        this.balance = depositAmount;
        System.out.println("Account created successfully!");
    }


    void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        }
        else
        {
            System.out.println("Invalid deposit amount!");
        }
    }


    void withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Invalid withdrawal amount!");
        }
        else if (balance - amount < 1000)
        {
            System.out.println("Withdrawal failed! Minimum balance of 1000 must be maintained.");
        } else
        {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }


    void printBalanceSheet()
    {
        System.out.println("--------- Balance Sheet ---------");
        System.out.println("Account Holder Name: " + accName);
        System.out.println("Account Number     : " + accNum);
        System.out.println("Current Balance    : ₹" + balance);

    }
}

public class BankAccount
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter Initial Deposit Amount: ");
        double amount = sc.nextDouble();
        Bank account = new Bank(name, accNum, amount);
        int choice;
        do
        {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit ");
            System.out.println("2. Withdraw ");
            System.out.println("3. Balance ");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    break;
                case 3:
                    account.printBalanceSheet();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
