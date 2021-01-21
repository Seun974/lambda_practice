package se.lexicon.data;


import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Create implementations for all methods. I have already provided an implementation for the first method *
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl(){
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance(){
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for(Person person : personList){
            if(filter.test(person)){
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for(Person person : personList) {
            if (filter.test(person)) {
              for(Person person1 : personList){
                  if(person1.equals(person)){
                      return person;
                  }
              }
            }
        }

        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        String result = null;
        for (Person person : personList) {
            if (filter.test(person)) {
                for (Person person1 : personList) {
                    if (person1.equals(person)) {
                        personToString.apply(person1);
                        String name = "Name: " + person1.getFirstName();
                        LocalDate dob = person1.getBirthDate();
                        result = name.concat(" born " + dob);
                        return result;
                    }
                } } }
        return result;
    }


    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString){
        List<String> strings = new ArrayList<>();
        List<Person> result = new ArrayList<>();
        for (Person person : personList){
            if(filter.test(person)){
                result.add(person);
                personToString.apply(person);
                String name = person.getFirstName();
                String lastName = person.getLastName();
                int age = person.getAge();
                String combined = name.concat(" " + lastName + " " + age + " Years.");
                strings.add(combined);

            }

            }
        return strings;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer){
        for (Person person : personList) {
            if (filter.test(person)) {
                for (Person person1 : personList) {
                    if (person1.equals(person)) {
                        String name = person.getFirstName();
                        String otherName = person.getLastName();
                        String combined = name.concat(" " + name + " " + otherName);
                        System.out.println(combined);

                    }
                }
            }
        }
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator){
        List<Person> result = new ArrayList<>();
        for(Person person : personList){
            if(comparator.equals(person)){
                result.sort(Comparator.comparing(Person::getFirstName));
            }
        }
        return result;

    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator){
        List<Person> result = new ArrayList<>();
        for(Person person : personList){
            if(filter.test(person)){
                result.sort(comparator);
            }
        }
        return result;
    }

}
