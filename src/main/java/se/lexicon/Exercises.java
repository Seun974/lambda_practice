package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> listOfALlEriks = P -> P.getFirstName().equals("Erik");
        System.out.println(storage.findMany(listOfALlEriks));

        System.out.println("----------------------");
    }

    /*
        2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> femalesInCollection = females -> females.getGender().equals(Gender.FEMALE);
        System.out.println(storage.findMany(femalesInCollection));

        System.out.println("----------------------");
    }

    /*
        3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> bornAfterAndInclude = bornAfter -> bornAfter.getBirthDate().isAfter(LocalDate.parse("2000-01-01"));
        System.out.println(storage.findMany(bornAfterAndInclude));
        System.out.println("----------------------");
    }

    /*
        4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> findOnePerson = person -> person.getId() == 123;
        System.out.println(storage.findOne(findOnePerson));
        System.out.println("----------------------");

    }

    /*
        5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> personWithId = C -> C.getId() == 456;
        Function<Person, String> joinedString = a ->{
            String name = a.getFirstName();
            LocalDate dob = a.getBirthDate();
            String result = name.concat(String.valueOf(dob));
            return  result;
        };
        System.out.println(storage.findOneAndMapToString(personWithId,joinedString));


        System.out.println("----------------------");
    }

    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message){
        System.out.println(message);
        //Write your code here
        //Predicate<Person> personWithLetter = p -> p.getFirstName().startsWith("E") && p.getLastName().startsWith("E");
        Predicate<Person> personWithLetter = p -> p.getGender().equals(Gender.MALE) && p.getFirstName().startsWith("E") && p.getLastName().startsWith("E");
        Function<Person, String> joinedValue = people ->{
            String name =  people.getFirstName();
            String name2 = people.getLastName();
            return name.concat(" : " + name2);
        };
        System.out.println(storage.findManyAndMapEachToString(personWithLetter, joinedValue));

        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> personBelowTen = per -> per.getAge() < 10;
        Function<Person, String> personName = kids -> {
            String name =  kids.getFirstName();
            String name2 = kids.getLastName();
            return name.concat(" : " + name2);
        };
        System.out.println(storage.findManyAndMapEachToString(personBelowTen, personName));

        System.out.println("----------------------");
    }

    /*
        8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message){
        System.out.println(message);
        //Write your code here
        Predicate<Person> peopleFirstName = fName -> fName.getFirstName().contains("Ulf");
        Consumer<Person> personConsumer = person -> System.out.println::(person.toString().contains("ulf"));


        System.out.println(storage.findAndDo(peopleFirstName, System.out::println));

        System.out.println("----------------------");
    }

    /*
        9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message){
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message){
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message){
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message){
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message){
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
