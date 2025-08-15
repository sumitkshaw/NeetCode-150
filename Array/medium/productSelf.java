import java.util.Scanner;

public class productSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        int [] result = pro(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+ " ");
        }
        sc.close();
    }
    public static int[] pro(int [] nums){
        int [] output = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            output[i] = 1;
        }
        int left = 1;
        for(int i=0;i<nums.length;i++){
            output[i]*= left;
            left *= nums[i];
        }
        int right =1;
        for(int i=nums.length-1; i>=0;i--){
            output[i]*=right;
            right*=nums[i];
        }
        return output;

    }
}
