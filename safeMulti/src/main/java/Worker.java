/**
 * Created by kdeveloper on 11/18/16.
 */
public class Worker implements Runnable {
    private BankAccount account;
    public Worker(BankAccount account){
        this.account=account;
    }

    int endBalance;

    public void run(){
        for (int i=0; i<10; i++){
            int startBalance=account.getBalance();
            account.deposit(10);
            endBalance=account.getBalance();
            //System.out.println("["+i+"]");
        }
        System.out.println(endBalance);

    }

}
