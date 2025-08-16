
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BalancedBT {
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
        TreeNode root = buildTree(arr);
        boolean result = balanced(root);

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
            if(i<arr.length && arr[i]!=-1){
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static boolean balanced(TreeNode root){
        if(height(root)!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if(left == -1){
            return -1;
        }
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right)>1){
            return -1;
        }
        else{
            return Math.max(left, right)+1;
        }
    }
}
