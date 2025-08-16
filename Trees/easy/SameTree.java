
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SameTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr =  new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int n1 = sc.nextInt();
        int [] nums =  new int[n1];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        TreeNode p = buildTree(arr);
        TreeNode q = buildTree(nums);
        boolean result = same(p , q);

        System.out.println(result);
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0 || arr[0]==-1 ){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;

        while(!queue.isEmpty() && i<arr.length){
            TreeNode curr = queue.poll();

            if(i<arr.length && arr[i]!=-1){
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;
            if(!queue.isEmpty() && arr[i]!=-1){
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static boolean same(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p!=null && q!=null && q.val == p.val){
            return same(p.left, q.left) && same(p.right, q.right);
        }
        return false;
    }
}
