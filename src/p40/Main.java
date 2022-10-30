package p40;

import java.util.*;

/**
 * Description:
 * date: 2022/10/28 上午 9:30
 *
 * @author Four
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] str = in.nextLine().trim().split(" ");
        int[] nums = new int[str.length];
        int idx = 0;
        for (String s : str) {
            if (s.length() == 0 || s.equals(" ")) continue;
            nums[idx++] = Integer.parseInt(s);
        }

        System.out.println(new Solution().canMeasureWater(nums[0], nums[1], nums[2]));
    }
}

class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;

        State initState = new State(0, 0);

        Deque<State> que = new ArrayDeque<>();  que.offer(initState);
        Set<State> visted = new HashSet<>();    visted.add(initState);

        while (!que.isEmpty()) {
            State head = que.poll();

            int curX = head.getX();
            int curY = head.getY();

            // 判断当前水量是否能满足z
            if (curX == z || curY == z || curX + curY == z) return true;

            // 从当前状态获取下一个状态的所有可能
            List<State> nextStates = getNextStates(curX, curY, x, y);

            for (State nextState : nextStates) {
                if (!visted.contains(nextState)) {
                    que.offer(nextState);
                    visted.add(nextState);
                }
            }
        }

        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
        // 最多有8个状态
        List<State> nextStates = new ArrayList<>(8);

        // 操作一
        State s1 = new State(x, curY);
        State s2 = new State(curX, y);

        // 操作二
        State s3 = new State(0, curY);
        State s4 = new State(curX, 0);

        // 操作四
        State s5 = new State(curX - (y - curY), y);
        State s6 = new State(0, curX + curY);
        State s7 = new State(x, curY - (x - curX));
        State s8 = new State(curX + curY, 0);

        // 判断上述状态转移是否合理
        // 当水壶未满，才需要装满
        if (curX < x) nextStates.add(s1);
        if (curY < y) nextStates.add(s2);

        // 当水壶有水，才可以倒出来
        if (curX > 0) nextStates.add(s3);
        if (curY > 0) nextStates.add(s4);

        // 有剩余才能倒
        if (curX > y - curY) nextStates.add(s5);
        if (curY > x - curX) nextStates.add(s7);

        // 倒过去不满
        if (curX + curY < y) nextStates.add(s6);
        if (curX + curY < x) nextStates.add(s8);

        return nextStates;
    }


    private class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
