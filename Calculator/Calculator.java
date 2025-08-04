package Calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String condition = "";
        do {
            
            System.out.print("Enter first Number: ");
            long number1 = sc.nextLong();
            System.out.println("Enter the Opeartion + , - , * , /");
            char operation = sc.next().charAt(0);
            System.out.print("Enter Second Number: " );
            long number2 = sc.nextLong();
        
            switch (operation) {
                case '+':
                    System.out.println(add(number1 , number2));
                    break;
                case '-' :
                    System.out.println(sub(number1 , number2));
                    break;
                case '*':
                    System.out.println(mul(number1 , number2));
                    break;
                case '/':
                    System.out.println(div(number1 , number2));
                    break;
                default:
                    System.out.println("Enter valid Operation");
                    break;
            }
            System.out.print("Do you want to continue? (y/n)");
            char response = sc.next().charAt(0);
            if(Character.toLowerCase(response) == 'n')
                condition = "n";
        } while (condition !="n");
        sc.close();
    }

    public static long add(long num1 , long num2 ){
        return num1+num2;
    }
    public static long sub(long num1 , long num2){
        return num1 - num2;
    }
    public static double mul(double num1 , double num2){
        return num1*num2;
    }
    public static double div(double num1 , double num2){
        return num1/num2;
    }
}
