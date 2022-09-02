package p01;

import java.util.*;


/*
    TODO: 暂时无法解决输出问题。。。
 */


public class p01 {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        String line = in.nextLine();
        int[] nums = praseIntArray(line);

        // 2. get node
        TreeNode root = solution.constructMaximumBinaryTree(nums);

        // 3. print tree
        print2(root);
    }

    private static int[] praseIntArray(String line) {
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }


    private static void print(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    private static void print2(TreeNode root) {
        List<String> arr = new ArrayList<>();

        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.pollLast();
            if (cur == null) {
                arr.add("null");
                continue;
            }
            arr.add(cur.val + "");
            que.addLast(cur.right);
            que.addLast(cur.left);
        }

        // print arr
        for (String n : arr) {
            System.out.print(n + " ");
        }
    }

}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return null;
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int[] rootInfo = getMax(nums, left, right);
        TreeNode node = new TreeNode(rootInfo[1]);
        int rootIndex = rootInfo[0];

        node.left = buildTree(nums, left, rootIndex - 1);
        node.right = buildTree(nums, rootIndex + 1, right);

        return node;
    }

    private int[] getMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, max};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
