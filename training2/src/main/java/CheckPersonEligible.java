/**
 * Created by kdeveloper on 11/16/16.
 */
public class CheckPersonEligible implements CheckPerson {
    public boolean test (Person p){
        return p.gender==Person.Sex.MALE && p.getAge()>10 && p.getAge()<50;
    }
}
