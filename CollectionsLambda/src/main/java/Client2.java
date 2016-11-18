import java.util.concurrent.*;

/**
 * Created by kdeveloper on 11/18/16.
 */
public class Client2 {
    public static void main(String[] args){

        long timeStart=System.nanoTime();

        String[] inFiles={"/home/kdeveloper/tren1/CollectionsLambda/file1.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file2.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file3.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file4.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file5.txt"};

        ExecutorService es= Executors.newFixedThreadPool(1);
        Future<Integer>[] results=new Future[inFiles.length];

        for (int i=0; i<inFiles.length; i++){
            Adder2 adder2=new Adder2(inFiles[i]);
            results[i]=es.submit(adder2);
        }

        for (Future<Integer> result: results){
            try {
                int value=result.get();
                System.out.println("Total: "+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                Throwable adderEx=e.getCause();
            }

        }

        long timeStop=System.nanoTime();
        long elapsedTime=timeStop-timeStart;

        System.out.println(elapsedTime);
    }
}
