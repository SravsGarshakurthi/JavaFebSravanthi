package Assignment1;

public class BillAbove500 {
    public static void main(String[] args) {
        // All 5 items — subtotal will be 649 (> 500)
        final double RICE  = 250;
        final double OIL   = 180;
        final double BREAD = 45;
        final double MILK  = 90;
        final double EGGS  = 84;

        double total = RICE + OIL + BREAD + MILK + EGGS; // 649.00
        System.out.printf("Subtotal: Rs. %.2f%n", total);

        // GST: 5% because subtotal > 500
        double gst = (total > 500) ? total * 0.05 : 0;
        total += gst;
        System.out.printf("GST (5%%): Rs. %.2f%n", gst);

        // Discount: 10% because total after GST > 600
        double discount = (total > 600) ? total * 0.10 : 0;
        total -= discount;
        System.out.printf("Discount (10%%): Rs. %.2f%n", discount);

        System.out.printf("TOTAL: Rs. %.2f%n", total);
    }
}
