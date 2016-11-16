import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by kdeveloper on 11/16/16.
 */
public class Client {
    public static void main (String[]args){

        Person Ewa=new Person("Ewa", Person.Sex.FEMALE, "ewa@gmail.com", 20);
        Person Lukasz=new Person("Lukasz", Person.Sex.MALE, "lukasz@gmail.com", 25);
        Person Janusz=new Person("Janusz", Person.Sex.MALE, "Janusz@gmail.com", 30);
        Person Kasia=new Person("Kasia", Person.Sex.FEMALE, "ewa@gmail.com", 35);
        Person Alicja=new Person("Alicja", Person.Sex.FEMALE, "alicja@gmail.com", 40);
        Person Piotr=new Person("Piotr", Person.Sex.MALE, "Piotr@gmail.com", 45);
        Person Karol=new Person("Karol", Person.Sex.MALE, "Karol@gmail.com", 50);
        Person Natalia=new Person("Natalia", Person.Sex.FEMALE, "Natalia@gmail.com", 55);

        List<Person> personList=new ArrayList<Person>();
        personList.add(Ewa);
        personList.add(Lukasz);
        personList.add(Janusz);
        personList.add(Kasia);
        personList.add(Alicja);
        personList.add(Piotr);
        personList.add(Karol);
        personList.add(Natalia);

        //Person.printArrayList(Person.personsOlderThan(personList, 30));

        //Person.printEligblePersons(personList, new CheckPersonEligible());

        //Person.printEligblePersons(personList, (Person p)-> p.getGender() ==Person.Sex.MALE &&p.getAge()>=20);

        Person.sumTwoAges(Ewa,Lukasz);

//        IAddable<Integer> agesAdder=(Person p1, Person p2)->p1.getAge()+p2.getAge();
//
//        Person.sumTwoAges(Ewa, Lukasz, (Person p1, Person p2)->p1.getAge()+p2.getAge());

    }


}
