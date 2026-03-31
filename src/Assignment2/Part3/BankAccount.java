package Assignment2.Part3;

public class BankAccount {
    String accountNumber;
    String holderName;
    double balance;
    String accountType;
    int transactionCount;

    // constructor — balance can't start negative
    BankAccount(String accountNumber, String holderName, double balance, String accountType) {
        if (balance < 0) {
            System.out.println("Error: starting balance can't be negative!");
            return;
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionCount = 0;
    }

    void deposit(double amt) {
        balance += amt;
        transactionCount++;
        System.out.println(holderName + " deposited $" + amt + " | New balance: $" + balance);
    }

    void withdraw(double amt) {
        // can't let them go negative
        if (amt > balance) {
            System.out.println("Sorry " + holderName + ", not enough funds to withdraw $" + amt);
            return;
        }
        balance -= amt;
        transactionCount++;
        System.out.println(holderName + " withdrew $" + amt + " | New balance: $" + balance);
    }

    void transfer(BankAccount target, double amt) {
        if (amt > balance) {
            System.out.println("Transfer failed — " + holderName + " doesn't have enough funds.");
            return;
        }
        balance -= amt;
        target.balance += amt;
        transactionCount++;
        target.transactionCount++;
        System.out.println(holderName + " transferred $" + amt + " to " + target.holderName);
    }

    void displayStatement() {
        System.out.println("\n--- Statement for " + holderName + " ---");
        System.out.println("Account #   : " + accountNumber);
        System.out.println("Type        : " + accountType);
        System.out.println("Balance     : $" + balance);
        System.out.println("Transactions: " + transactionCount);
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        BankAccount priya  = new BankAccount("ACC001", "Priya",  1000.0, "Savings");
        BankAccount karthik = new BankAccount("ACC002", "Karthik", 500.0, "Current");

        System.out.println("=== Running Transactions ===\n");

        priya.deposit(200);             // 1 - priya puts money in
        karthik.deposit(300);           // 2 - karthik puts money in
        priya.withdraw(150);            // 3 - priya takes some out
        karthik.withdraw(900);          // 4 - karthik tries to overdraft (should fail)
        priya.transfer(karthik, 400);   // 5 - priya sends karthik some money
        karthik.withdraw(100);          // 6 - karthik withdraws successfully now

        System.out.println("\n=== Final Account Statements ===");
        priya.displayStatement();
        karthik.displayStatement();
    }
}