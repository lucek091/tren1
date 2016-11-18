import java.io.IOException;
import java.util.*;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import java.util.logging.Formatter;


public class Client {

    static Logger logger=Logger.getLogger("com.Client");



    public static void main(String[] args){

        long startTime=System.nanoTime();
        long startTime2=System.currentTimeMillis();

        String[] inFiles={"/home/kdeveloper/tren1/CollectionsLambda/file1.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file2.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file3.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file4.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file5.txt"};

        String[] outFiles={"/home/kdeveloper/tren1/CollectionsLambda/file1.out.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file2.out.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file3.out.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file4.out.txt",
                "/home/kdeveloper/tren1/CollectionsLambda/file5.out.txt"};

        Thread[] threads=new Thread[inFiles.length];
             int z=0;
        while(z<100){

            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                threads[i] = new Thread(adder);
                threads[i].start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            z++;
        }

        long stopTime=System.nanoTime();
        long stopTime2=System.currentTimeMillis();

        long elapsedTime=stopTime-startTime;
        long elapsedTime2=stopTime2-startTime2;

        //STOP OF THE CONCURRENCY//

        long startTime3=System.nanoTime();
        long startTime4=System.currentTimeMillis();

        int k=0;
        while(k<100) {
            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);

                try {
                    adder.doAdd();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
            k++;
        }

        long stopTime3=System.nanoTime();
        long stopTime4=System.currentTimeMillis();

        long elapsedTime3=stopTime3-startTime3;
        long elapsedTime4=stopTime4-startTime4;

        ///////////THREAD POOL MAX 2 THREADS///////////

        long startTime5=System.nanoTime();
        long starTime6=System.currentTimeMillis();

        ExecutorService es= Executors.newFixedThreadPool(2);

        for (int i=0; i<inFiles.length; i++){
            Adder adder=new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }

        try {
            es.shutdown();
            es.awaitTermination(60,TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long stopTime5=System.nanoTime();
        long stopTime6=System.currentTimeMillis();

        long elapsedTime5=stopTime5-startTime5;
        long elapsedTime6=stopTime6-starTime6;


        logger.setUseParentHandlers(false);
        try{
            FileHandler fh=new FileHandler("/home/kdeveloper/tren1/CollectionsLambda/MyLogFile.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter=new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("elapsed time WITH concurrency [NANO]: "+String.valueOf(elapsedTime));
            logger.info("elapsed time WITH concurrency [CURRENT]: "+String.valueOf(elapsedTime2));
            logger.info("elapsed time WITHOUT concurrency [NANO]: "+String.valueOf(elapsedTime3));
            logger.info("elapsed time WITHOUT concurrency [CURRENT]: "+String.valueOf(elapsedTime4));
            logger.info("elapsed time WITH concurrency 2 THREADS MAX [NANO]: "+String.valueOf(elapsedTime5));
            logger.info("elapsed time WITH concurrency 2 THREADS MAX [CURRENT]: "+String.valueOf(elapsedTime6));

        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }

//        logger.setUseParentHandlers(false);
//        FileHandler fh;
//
//        try{
//            //fh=new FileHandler("%t/MyLogFile.txt");
//            fh=new FileHandler("/home/kdeveloper/tren1/CollectionsLambda/MyLogFile.txt");
//            logger.addHandler(fh);
//            SimpleFormatter formatter=new SimpleFormatter();
//            fh.setFormatter(formatter);
//
//            //logger.info("My first log");
//        } catch (SecurityException e){
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        //logger.info("Hi how are u?");



//        Handler handler=new ConsoleHandler();
//        Formatter formatter=new SimpleFormatter();
//        handler.setFormatter(formatter);
//        logger.addHandler(handler);
//        logger.setLevel(Level.INFO);
//        logger.log(Level.INFO, "We are logging!");
//
//
//
//        Person Janusz=new Person("Janusz", "Kowalski", 20);
//        Person Piotr=new Person("Piotr", "Stempin", 22);
//        Person Lukasz=new Person("Lukasz", "Obama", 25);
//        Person Adrian=new Person("Adrian", "Adamski", 27);
//
//        List<Person> personList=new ArrayList<>();
//        personList.add(Janusz);
//        personList.add(Piotr);
//        personList.add(Lukasz);
//        personList.add(Adrian);
//        logger.info("list created");
//
//        System.out.println(personList);
//
//        Comparator<Person> cmpAge=(Person p1, Person p2)->p2.getAge()-p1.getAge();
//        Comparator<Person> cmpFirstName=(p1,p2)->p1.getFirstName().compareTo(p2.getFirstName());
//        logger.info("two comparators created");
//
//        Collections.sort(personList, cmpAge);
//        System.out.println(personList);
//
//        Collections.sort(personList, cmpFirstName);
//        System.out.println(personList);

    }
}
