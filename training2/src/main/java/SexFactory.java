/**
 * Created by kdeveloper on 11/17/16.
 */
public class SexFactory {

    public Person getPerson(String name, Person.Sex gender, String emailAdress, int age){
        if (gender==null) return null;
        if (gender==Person.Sex.MALE) return new Man(name,gender, emailAdress, age);
        else if (gender==Person.Sex.FEMALE) return new Woman(name, gender, emailAdress,age);

        return null;
    }
}
