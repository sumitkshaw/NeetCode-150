import java.util.*;
public class InvertBT {
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
        TreeNode result = invertTree(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(result);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            
            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();
                System.out.print(curr.val + " ");
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
        }
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0 || arr[0]==-1){
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
}
