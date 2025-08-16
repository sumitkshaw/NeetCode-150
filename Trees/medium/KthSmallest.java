
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class KthSmallest {
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
        int k = sc.nextInt();
        TreeNode root = buildTree(arr);
        int result = kth(root, k);
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
    static TreeNode result = null;
    static int count = 0;
    public static int kth(TreeNode root,int k){
        helper(root, k);
        return result.val;
    }
    public static void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left,k);
        count++;
        if(count == k){
            result = root;
            return;
        }
        helper(root.right, k);
    }
}
