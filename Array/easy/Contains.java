import java.util.*;


public class Contains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean result = contains(arr);
        System.out.println(result);
    }
    public static boolean contains(int []nums){
        HashSet<Integer> seen=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(seen.contains(nums[i]))
            {
                return true;
            }
            else
            {
                seen.add(nums[i]);
            }
        }
        return false;
    }
    
    
}
