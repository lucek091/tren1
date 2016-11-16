import sun.util.resources.LocaleData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kdeveloper on 11/16/16.
 */
public class Person {

    public enum Sex{
        MALE, FEMALE
    }

    String name;


    Sex gender;
    String emailAddress;
    int age;

    public Person(String name, Sex gender, String emailAdress, int age){
        this.name=name;
        this.gender=gender;
        this.emailAddress=emailAdress;
        this.age=age;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Person> personsOlderThan(List<Person> persons, int age){
        List<Person> personsOlderThan=new ArrayList<Person>();
        for (Person p:persons) {
            if (p.getAge()>=age){
                personsOlderThan.add(p);
            }
        }
        return personsOlderThan;
    }

    public static void printArrayList(List<Person> persons){
        for (Person p : persons){
            System.out.println(p);
        }

    }

    public static void printEligblePersons(List<Person> persons, CheckPerson tester){
        for (Person p: persons){
            if (tester.test(p)){
                System.out.println(p);
            }
        }

    }

    public static void sumTwoAges(Person p1, Person p2){
        IAddable<Integer> addAges=(Integer p3, Integer p4)->p3+p4;

        System.out.print(addAges.add(p1.getAge(), p2.getAge()));

    }






}
