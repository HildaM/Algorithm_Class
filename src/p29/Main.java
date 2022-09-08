package p29;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Solution5().countArrangement(in.nextInt()));
    }
}


// dfs
class Solution1 {
    public int countArrangement(int n) {
        return dfs(n, 1, new boolean[n + 1]);
    }

    private int dfs(int n, int i, boolean[] visited) {
        if (i > n) return 1;

        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % i == 0 || i % num == 0)) {
                visited[num] = true;
                ans += dfs(n, i + 1, visited);
                visited[num] = false;
            }
        }

        return ans;
    }
}


// dfs + 状态 压缩
/*
    n == 15，有限数字，可以使用位运算进行标记！
 */
class Solution2 {
    public int countArrangement(int n) {
        return dfs(n, 1, 0);
    }

    private int dfs(int n, int i, int visited) {
        if (i > n) return 1;

        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (((1 << num) & visited) == 0 && (num % i == 0 || i % num == 0)) {
                ans += dfs(n, i + 1, (1 << num) | visited);
            }
        }

        return ans;
    }
}


// dfs + 状态压缩 + 记忆化搜索
class Solution3 {
    public int countArrangement(int n) {
        int[][] memo = new int[n + 1][1 << n];
        return dfs(n, 1, 0, memo);
    }

    private int dfs(int n, int i, int visited, int[][] memo) {
        if (i > n) return 1;

        if (memo[i][visited] != 0) return memo[i][visited];

        int ans = 0;
        // 因为memo数组从0开始索引，所以需要配合该特性，num - 1
        for (int num = 1; num <= n; num++) {
            if (((1 << (num - 1)) & visited) == 0 && (num % i == 0 || i % num == 0)) {
                ans += dfs(n, i + 1, (1 << (num - 1)) | visited, memo);
            }
        }

        memo[i][visited] = ans;

        return ans;
    }
}


// dp + 状态压缩
class Solution4 {
    // dp[i][visited]: 填入第i个数并且访问状态为visited时优美排序的数目
    // dp来源与dfs的记忆化memo！！！回溯的记忆化操作，可以与动态规划互相转换
    // dp[i][visited] = Sum(dp[i - 1][visited去掉一个1])

    public int countArrangement(int n) {
        int mask = 1 << n;
        int[][] dp = new int[n + 1][mask];    // memo数组改名为dp即可
        dp[0][0] = 1;   // 相当于dfs的最深遍历层数，需要返回1

        for (int i = 1; i <= n; i++) {
            // 逐个遍历mask
            for (int visited = 0; visited < mask; visited++) {
                // 只有当visited的位数与i相同时，才可以计算
                if (Integer.bitCount(visited) == i) {
                    for (int num = 1; num <= n; num++) {
                        // 与dfs相反，此处表示当前位置放入了指定数字
                        if (
                                ((1 << (num - 1)) & visited) != 0 &&
                                        (num % i == 0 || i % num == 0)
                        ) {
                            // 1 << (num - 1) 表示第 num 位是1，取反就是这位是0，其他都是1
                            // 再与 visited 与运算表示打掉 visited 这位的 1
                            dp[i][visited] += dp[i - 1][(~(1 << (num - 1))) & visited];
                        }
                    }

                }
            }
        }

        return dp[n][mask - 1];
    }
}

// dp 优化
class Solution5 {
    public int countArrangement(int n) {
        int mask = 1 << n;
        int[] dp = new int[mask];
        dp[0] = 1;

        for (int visited = 0; visited < mask; visited++) {
            int i = Integer.bitCount(visited);
            for (int num = 1; num <= n; num++) {
                if (
                        ((1 << (num - 1)) & visited) != 0 &&
                                (num % i == 0 || i % num == 0)
                ) {
                    dp[visited] += dp[visited & ~(1 << (num - 1))];
                }
            }
        }

        return dp[mask - 1];
    }
}