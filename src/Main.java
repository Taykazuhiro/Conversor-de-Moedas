import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ApiConnection connection = new ApiConnection();
        CurrencyConverter converter = new CurrencyConverter();

        String menu = "************* Welcome *************\n" +
                "1) Dollar > Brazilian Real\n" +
                "2) Brazilian Real > Dollar\n" +
                "3) Dollar > Pound Sterling\n" +
                "4) Pound Sterling > Dollar\n" +
                "5) Dollar > Chilean Peso\n" +
                "6) Chilean Peso > Dollar\n" +
                "7) Leave\n" +
                "****** Select a number *******\n";

        while (true) {
            System.out.println(menu);
            int option = 0;
            // tentativa de leitura e tratamento de erro de inserção de valor.
            try {
                option = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid format. Bye");
                break;
            }
            // break do while caso entre a opção 7 - leave
            if (option == 7) {
                System.out.println("Bye!");
                break;
            }
            // nova tentativa para fazer a conversão e tratativa de erro de conversão
            try{
                System.out.println("Enter the amount you want to convert:");
                double value = 0;
                value = reader.nextDouble();
                reader.nextLine();
                double result = converter.convert(option, value);
                System.out.printf("Result: %.2f\n", result);
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Error: " + e + " Insert just numbers.");
                reader.nextLine();
            }
        }
    }
}