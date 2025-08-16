
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class validateBT {
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
        int [] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        boolean result = validBT(root);
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
    public static boolean validBT(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean validate(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        return validate(root.left, min, root.val) && validate(root.right, root.val,max);
    }
}
