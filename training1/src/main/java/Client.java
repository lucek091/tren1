import java.util.Scanner;

/**
 * Created by kdeveloper on 11/16/16.
 */
public class Client {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";

        if (n%2==1){
            ans="Werid";
        }
        else if (n%2==0 && n>=2 && n<=5){
            ans="Not Weird";
        }

        System.out.print(ans);


    }
}
