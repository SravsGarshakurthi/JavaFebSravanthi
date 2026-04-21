package Assignment1;

public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius = 25.0;

        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println("Celsius:    " + celsius + " °C");
        System.out.println("Fahrenheit: " + fahrenheit + " °F");
        System.out.println("Kelvin:     " + kelvin + " K");
    }
}
