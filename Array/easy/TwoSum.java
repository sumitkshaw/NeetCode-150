
import java.util.HashMap;
import java.util.Scanner;


public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int t = sc.nextInt();
        int [] result = sum2(arr,t);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+ " ");
        }
        sc.close();
    }
    public static int [] sum2(int []arr, int target){
        HashMap<Integer,Integer> hp = new HashMap<>();
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            int compliment = target - arr[i];

            if(hp.containsKey(compliment)){
                return new int[]{hp.get(compliment), i};
            }
            else{
                hp.put(arr[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    
}
