package Assignment2.Part8;

// abstract superclass — cannot be instantiated directly
abstract class Payment {
    double amount;
    String payerName;

    Payment(double amount, String payerName) {
        this.amount    = amount;
        this.payerName = payerName;
    }

    // abstract method — every subclass MUST override this
    abstract void processPayment();

    // concrete method — same for all subclasses
    void displayReceipt() {
        System.out.println("----------------------------");
        System.out.println("Payer  : " + payerName);
        System.out.println("Amount : Rs." + amount);
        System.out.println("Status : Payment Processed");
        System.out.println("----------------------------");
    }
}

// CashPayment subclass
class CashPayment extends Payment {

    CashPayment(double amount, String payerName) {
        super(amount, payerName);
    }

    @Override
    void processPayment() {
        System.out.println("Cash payment of Rs." + amount + " received.");
    }
}

// CardPayment subclass
class CardPayment extends Payment {
    String cardNumber; // full card number stored privately
    String bankName;

    CardPayment(double amount, String payerName, String cardNumber, String bankName) {
        super(amount, payerName);
        this.cardNumber = cardNumber;
        this.bankName   = bankName;
    }

    // show only last 4 digits
    String getLast4Digits() {
        return cardNumber.substring(cardNumber.length() - 4);
    }

    @Override
    void processPayment() {
        System.out.println("Card payment of Rs." + amount + " processed.");
        System.out.println("Bank: " + bankName + " | Card ending in: " + getLast4Digits());
    }
}

// UPIPayment subclass
class UPIPayment extends Payment {
    String upiId;

    UPIPayment(double amount, String payerName, String upiId) {
        super(amount, payerName);
        this.upiId = upiId;
    }

    @Override
    void processPayment() {
        System.out.println("Processing...");
        System.out.println("UPI payment of Rs." + amount + " from " + upiId + " — Success");
    }
}

// EMIPayment subclass
class EMIPayment extends Payment {
    int months;

    EMIPayment(double amount, String payerName, int months) {
        super(amount, payerName);
        this.months = months;
    }

    @Override
    void processPayment() {
        double monthlyInstallment = amount / months;
        System.out.println("EMI payment started.");
        System.out.println("Total: Rs." + amount + " | Months: " + months + " | Monthly EMI: Rs." + monthlyInstallment);
    }
}

class PaymentMain {

    public static void main(String[] args) {

        // Payment p = new Payment(1000, "Ravi");
        // ERROR: Payment is abstract — you cannot create an object of an abstract class
        // because it has an abstract method processPayment() with no body.
        // Java doesn't know what to do when processPayment() is called on it.
        // Only concrete subclasses that implement processPayment() can be instantiated.

        Payment[] payments = new Payment[4];
        payments[0] = new CashPayment(500,   "Murugan");
        payments[1] = new CardPayment(2000,  "Priya",   "1234567890123456", "HDFC");
        payments[2] = new UPIPayment(1500,   "Karthik", "karthik@upi");
        payments[3] = new EMIPayment(12000,  "Divya",   6);

        System.out.println("=== Processing All Payments ===\n");

        for (int i = 0; i < payments.length; i++) {
            payments[i].processPayment();
            payments[i].displayReceipt();
            System.out.println();
        }
    }
}