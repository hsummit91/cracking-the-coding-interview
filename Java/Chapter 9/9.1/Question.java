/* Question 9.1 A child is running up a staircase with n steps, and can hop either 1step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.

 */


public class Question {
    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
            //we assign -1 to all map[n],if it is changed, we can simply return the value without calculate it
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) +
                    countWaysDP(n - 2, map) +
                    countWaysDP(n - 3, map);
            return map[n];
        }
    }

    public static int countWaysRecursive(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            long t1 = System.currentTimeMillis();
            int[] map = new int[30 + 1];
            for (int j = 0; j < map.length; j++) {
                map[j] = -1;
            }
            int c1 = countWaysDP(i, map);
            long t2 = System.currentTimeMillis();
            long d1 = t2 - t1;

            long t3 = System.currentTimeMillis();
            int c2 = countWaysRecursive(i);
            long t4 = System.currentTimeMillis();
            long d2 = t4 - t3;
            System.out.println(i + " " + c1 + " " + c2 + " " + d1 + " " + d2);
        }
    }
}