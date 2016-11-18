import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kdeveloper on 11/18/16.
 */
public class Client {
    public static void main(String[] args){
        ExecutorService es= Executors.newFixedThreadPool(2);
        BankAccount account=new BankAccount(100);

        for (int i=0; i<5; i++){
            Worker Andrzej=new Worker(account);
            //System.out.println("for  z clienta"+i);
            es.submit(Andrzej);
        }



        es.shutdown();


    }
}
