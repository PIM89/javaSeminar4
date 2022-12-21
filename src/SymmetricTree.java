import java.util.LinkedList;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.add(root);
        stack2.add(root);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode q = stack1.poll();
            TreeNode p = stack2.poll();
            if (q == null && p == null) {
                continue;
            }
            if (q == null || p == null || q.val != p.val) {
                return false;
            }
            stack1.add(q.left);
            stack1.add(q.right);
            stack2.add(p.right);
            stack2.add(p.left);
        }
        return true;
    }
}
