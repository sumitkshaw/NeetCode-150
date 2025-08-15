import java.util.*;
public class TrappingRain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = rainwater(arr);
        System.out.println(result);
    }
    public static int rainwater(int [] arr){
        int l = 0;
        int r = arr.length-1;
        int leftMax= arr[l];
        int rightMax = arr[r];
        int water = 0;

        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                water += leftMax - arr[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                water += rightMax - arr[r];
            }
        }
        return water;
    }
}
