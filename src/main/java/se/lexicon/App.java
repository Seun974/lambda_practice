package se.lexicon;

import java.util.Scanner;

import static se.lexicon.Exercises.*;


public class App 
{

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static void main( String[] args )
    {

        boolean done = false;
        String message = "Running exercise...";
        do{
            System.out.println(menu());
            System.out.print("Choose from 1-13: ");
            int number = getInt();
            switch (number){
                case 0:
                    done = true;
                    break;
                case 1:

                    Exercises.exercise1("Exercise 1");

                    break;
                case 2:
                    Exercises.exercise2("Exercise 2");
                    break;
                case 3:
                    Exercises.exercise3("Exercise 3");
                    break;
                case 4:
                    Exercises.exercise4("Exercise 4");
                    break;
                case 5:
                    Exercises.exercise5("Exercise 5");
                    break;
                case 6:
                    Exercises.exercise6("Exercise 6");
                    break;
                case 7:
                    Exercises.exercise7("Exercise 7");
                    break;
                case 8:
                    Exercises.exercise8("Exercise 8");
                    break;
                case 9:
                    exercise9(message + number);
                    break;
                case 10:
                    exercise10(message + number);
                    break;
                case 11:
                    exercise11(message + number);
                    break;
                case 12:
                    exercise12(message + number);
                    break;
                case 13:
                    exercise13(message + number);
                    break;
            }


        }while(!done);
        SCANNER.close();
    }



    public static String menu(){
        StringBuilder stringBuilder = new StringBuilder("Please make a choice: \n");
        stringBuilder.append("0.\tQuit\n");
        stringBuilder.append("1.\tFind everyone that has firstName: “Erik” using findMany().\n");
        stringBuilder.append("2.\tFind all females in the collection using findMany().\n");
        stringBuilder.append("3.\tFind all who are born after (and including) 2000-01-01 using findMany().\n");
        stringBuilder.append("4.\tFind the Person that has an id of 123 using findOne().\n");
        stringBuilder.append("5.\tFind the Person that has an id of 456 and convert to String with following content:\n" +
                "            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().\n");
        stringBuilder.append("6.\tFind all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().\n");
        stringBuilder.append("7.\tFind all people who are below age of 10 and convert them to a String like this:\n" +
                "            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.\n");
        stringBuilder.append("8.\tUsing findAndDo() print out all people with firstName “Ulf”.\n");
        stringBuilder.append("9.\tUsing findAndDo() print out everyone who have their lastName contain their firstName.\n");
        stringBuilder.append("10.\tUsing findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.\n");
        stringBuilder.append("11.\tUsing findAndSort() find everyone whose firstName starts with A sorted by birthDate.\n");
        stringBuilder.append("12.\tUsing findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.\n");
        stringBuilder.append("13.\tUsing findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.\n");
        return stringBuilder.toString();
    }

    public static int getInt(){
        int number = 0;
        boolean validNumber = false;
        while(!validNumber){
            try{
                number = Integer.parseInt(SCANNER.nextLine().trim());
                validNumber = number >= 0 && number < 14;
            }catch (NumberFormatException ex){
                System.out.println("Not a integer");
            }
            if(!validNumber){
                System.out.println("Try again");
            }
        }

        return number;
    }
}
