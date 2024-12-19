import java.util.Scanner;
public class TemperatureConverter {                                                            
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Enter your choice (1-6): ");
        int choice = scanner.nextInt();
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        switch (choice) {
            case 1:
                System.out.println(temperature + "°C = " + celsiusToFahrenheit(temperature) + "°F");
                break;
            case 2:
                System.out.println(temperature + "°F = " + fahrenheitToCelsius(temperature) + "°C");
                break;
            case 3:
                System.out.println(temperature + "°C = " + celsiusToKelvin(temperature) + "K");
                break;
            case 4:
                System.out.println(temperature + "K = " + kelvinToCelsius(temperature) + "°C");
                break;
            case 5:
                System.out.println(temperature + "°F = " + fahrenheitToKelvin(temperature) + "K");
                break;
            case 6:
                System.out.println(temperature + "K = " + kelvinToFahrenheit(temperature) + "°F");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
 }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}