import java.util.Scanner;
public interface Checking{

    static String CheckInput(String option1, String option2, String option3, String option4, String check, String InputType){
        Scanner in = new Scanner(System.in);
        while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2) && !check.equalsIgnoreCase(option3) && !check.equalsIgnoreCase(option4)){
            System.out.println("Wrong input.Enter again the "+ InputType+":");
            check = in.nextLine();
        }
        return check;
    }

    static String CheckInput(String option1, String option2, String option3, String check, String InputType){
        Scanner in = new Scanner(System.in);
        while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2) && !check.equalsIgnoreCase(option3)){
            System.out.println("Wrong input.Enter again the "+ InputType+":");
            check = in.nextLine();
        }
        return check;
    }


    static String CheckInput(String option1, String option2,String check, String InputType){
        Scanner in = new Scanner(System.in);
        while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2)){
            System.out.println("Wrong input.Enter again the "+ InputType+":");
            check = in.nextLine();
        }
        return check;
    }
}