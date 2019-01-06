package hourrank;

import java.util.*;

public class Team {

    static Set<Integer> getTeam(int a, int b, int x) {
        Set<Integer> result = new HashSet<>();

        for (int i = a; i <= b; i++) {
            if (1 == i) {
                continue;
            }
            result.add(i);
        }

        Set<Integer> toRemove = new HashSet<>();
        for (int p : result) {
            if (toRemove.contains(p)) {
                continue;
            }

            for (int i = 2; i * p <= b; i++) {
                toRemove.add(i * p);
            }
        }
        result.removeAll(toRemove);

        Iterator<Integer> it = result.iterator();
        while (result.size() > x && it.hasNext()) {
            it.next();
            it.remove();
        }

        if (x == result.size()) {
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            Set<Integer> team = getTeam(a, b, x);
            if (null == team) {
                System.out.println("-1");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Integer i : team) {
                    sb.append(String.format("%d ", i));
                }
                System.out.println(sb.toString().trim());
            }

        }
        in.close();
    }
}
