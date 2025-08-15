import java.util.*;

public class Depth {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val =x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        int result = depth(root);
        System.out.println(result);
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0 || arr[0]!=-1){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        int i=1;
        queue.offer(root);
        while(!queue.isEmpty() && i<arr.length){
            TreeNode curr = queue.poll();
            if(i<arr.length && arr[i]!= -1){
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

    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.left)+1;
        int r = depth(root.right)+1;
        return Math.max(l, r);
    }
}
