package Assignment1;

public class BillBelow500 {
    public static void main(String[] args) {
        // Fewer items — subtotal will be 379 (< 500)
        final double RICE  = 250;
        final double BREAD = 45;
        final double EGGS  = 84;

        double total = RICE + BREAD + EGGS; // 379.00
        System.out.printf("Subtotal: Rs. %.2f%n", total);

        // GST: 0% because subtotal < 500
        double gst = (total > 500) ? total * 0.05 : 0;
        total += gst;
        System.out.printf("GST (0%%): Rs. %.2f%n", gst);

        // Discount: 0% because total < 600
        double discount = (total > 600) ? total * 0.10 : 0;
        total -= discount;
        System.out.printf("Discount (0%%): Rs. %.2f%n", discount);

        System.out.printf("TOTAL: Rs. %.2f%n", total);
    }
}
