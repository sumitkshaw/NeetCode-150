
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Subroot {
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
        for(int i=0;i<n1;i++){
            nums[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        TreeNode subroot = buildTree(nums);
        boolean result = same(root , subroot);

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
    public static boolean same(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return true;
        }
        if(root.val == subRoot.val){
            if(findsub(root, subRoot)){
                return true;
            }
        }
        return same(root.left, subRoot) || same(root.right, subRoot);
    }

    public static boolean findsub(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot == null) return true;

        if(root==null || subRoot == null || subRoot.val != root.val) return false;

        
        if(root.val == subRoot.val){
            return findsub(root.right, subRoot.right) && findsub(root.left, subRoot.left);
        }
        return false;
    }
}
