import com.google.gson.Gson;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiConnection connection = new ApiConnection();
        String menu = "************* Welcome *************\n" +
                "1) Dollar > Brazilian Real\n" +
                "2) Brazilian Real > Dollar\n" +
                "3) Dollar > Pound Sterling\n" +
                "4) Pound Sterling > Dollar\n" +
                "5) Dollar > Chilean Peso\n" +
                "6) Chilean Peso > Dollar\n" +
                "7) Leave\n" +
                "****** Select a number *******\n";
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println(menu);
            int option = reader.nextInt();

            if (option == 7) {
                System.out.println("Bye!");
                break;
            }

            System.out.println("Enter the amount you want to convert:");
            double value = reader.nextDouble();

            ConversationRates data = connection.BuscaCambio("USD");
            Map<String, Double> taxes = data.getConversion_rates();
            double result = 0;

            switch (option) {
                case 1 -> result = value * taxes.get("BRL");
                case 2 -> result = value / taxes.get("BRL");
                case 3 -> result = value * taxes.get("GBP");
                case 4 -> result = value / taxes.get("GBP");
                case 5 -> result = value * taxes.get("CLP");
                case 6 -> result = value / taxes.get("CLP");
                default -> System.out.println("Opção inválida.");
            }

            if (option >= 1 && option <= 6) {
                System.out.printf("Result: %.2f\n", result);
            }
        }
    }
}