import java.util.*;
public class MostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = water(arr);
        System.out.println(result);
    }

    public static int water(int [] arr){
        int left = 0;
        int right = arr.length -1;
        int result = 0;

        while(left <right){
            int breadth = right - left;
            int area = breadth * Math.min(arr[left], arr[right]);
            result = Math.max(result,area);
            if(arr[left]>arr[right]){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }
    
}
