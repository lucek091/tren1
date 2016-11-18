import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by kdeveloper on 11/17/16.
 */
public class Client {

    public static void main(String[] args) {
//
//        Client test=new Client();
//
//        MathOperation addition=(a,b)->a+b;
//
//        MathOperation division=(a,b)->a/b;
//
//       int x= operate(2,5,addition);
//        System.out.println(x);

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder s=new StringBuilder();

        for (int i=0; i<t; i++){
            s.append("t");
        }

        int k=0;

        for (int j=1; j<=t; j++){
            s.replace(s.length()-j, s.length()-k,"#");

            System.out.println(s);
            k++;
        }



    }

    private static int operate (int a, int b, MathOperation operationType){
        return operationType.operation(a,b);
    }


//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//
//        List<String> nums = Arrays.asList(scanner.nextLine().split(" "));
//
//        int sum = nums.stream().map((s) -> {
//            return Integer.parseInt(s);
//        }).mapToInt((integer) -> integer.intValue()).sum();
//
//
//        int sum2 = nums.stream().map(Integer::parseInt).mapToInt(Integer::intValue).sum();
//
//        System.out.println(sum);



}
