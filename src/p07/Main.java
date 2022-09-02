package p07;

import java.util.*;
public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        String line = in.nextLine();
        String[] arr = line.split(" ");
        for (String n : arr) {
            list.add(Integer.parseInt(n));
        }

        Collections.sort(list);
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
