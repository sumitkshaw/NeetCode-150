
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LCA {
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
        int [] arr2 = new int[2];
        for(int i=0;i<2;i++){
            if(i==0){
                System.out.print("p:" + " " );
                arr2[0] = sc.nextInt();
            }
            if(i==1){
                System.out.print("q:" + " ");
                arr2[1] = sc.nextInt();
            }
        }
        TreeNode root = buildTree(arr);
        TreeNode p = new TreeNode(arr2[0]);
        TreeNode q = new TreeNode(arr2[1]);

        TreeNode result = lca(root, p,q);
        System.out.println(result.val);
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

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            return validate(root, q,p);
        }
        else{
            return validate(root,p,q);
        }
    }
    private static TreeNode validate(TreeNode root, TreeNode left, TreeNode right){
        if(root.val>right.val){
            return validate(root.left, left,right);
        }
        if(root.val<left.val){
            return validate(root.right, left , right);
        }
        return root;
    }
}

