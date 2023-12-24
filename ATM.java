import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String withdraw(double amount) {
        if (this.bankAccount.withdraw(amount)) {
            return "Withdrawal of $" + amount + " successful.";
        } else {
            return "Insufficient balance for withdrawal.";
        }
    }

    public String deposit(double amount) {
        if (this.bankAccount.deposit(amount)) {
            return "Deposit of $" + amount + " successful.";
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String checkBalance() {
        return "Your account balance is $" + this.bankAccount.checkBalance() + ".";
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000); // Starting balance of $1000
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            double amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    amount = scanner.nextDouble();
                    System.out.println("Please wait until your Transaction is being processed");
                    System.out.println(atm.withdraw(amount));

                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    amount = scanner.nextDouble();
                    System.out.println(atm.deposit(amount));
                    break;
                case 3:
                    System.out.println(atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Your Transaction is successful!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            System.out.println("Do you want to continue ?(yes/no):");
            String comtimue=scanner.next();
            if(!comtimue.equalsIgnoreCase("yes")) {
                System.out.println("your transaction is successful!");
                break;
            }
        }
    }
}
