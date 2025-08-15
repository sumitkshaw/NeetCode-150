
import java.util.Scanner;


public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int temp = n;
        int res = 0;
        while(temp!=0){
            int d = temp%10;
            res = res*10 + d;
            temp = temp/10;
        }
        if(n == res){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
