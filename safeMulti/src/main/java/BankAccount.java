/**
 * Created by kdeveloper on 11/18/16.
 */
public class BankAccount {
    private int balance;
    public BankAccount(int startBalance){
        balance=startBalance;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amout){
        balance+=amout;
    }
}
