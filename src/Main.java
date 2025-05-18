import Api.ApiConnection;
import Calculations.CurrencyConverter;
import Models.Message;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ApiConnection connection = new ApiConnection();
        CurrencyConverter converter = new CurrencyConverter();
        Message menu = new Message();

        while (true) {
            menu.printMenu();
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