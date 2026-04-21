package Assignment1;

public class TrafficLight {
    public static void main(String[] args) {

        String light = "Red";  // Change to "Yellow" or "Green" to test

        System.out.println("Light: " + light);

        // Switch statement for action
        switch (light) {
            case "Red":
                System.out.println("Action: STOP - Do not proceed.");
                break;
            case "Yellow":
                System.out.println("Action: CAUTION - Prepare to stop.");
                break;
            case "Green":
                System.out.println("Action: GO - Proceed safely.");
                break;
            default:
                System.out.println("Action: UNKNOWN signal - treat as Red.");
                break;
        }

        // Ternary: Safe to go only if light is Green
        boolean safeToGo = light.equals("Green") ? true : false;
        System.out.println("Safe to go: " + safeToGo);
    }
}
