import java.util.*;
public class DiameterBT {
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
        int result = dia(root);
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
            if(i<arr.length && arr[i]== -1){
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
    private static int maxDiameter = 0;

    private static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left+right);
        return Math.max(left,right)+1;

    }
    public static int dia(TreeNode root) {
        height(root);
        return maxDiameter;
    }

}