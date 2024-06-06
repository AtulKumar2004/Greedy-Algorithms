import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem { // You can also solve this problem on SPOJ platform
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer CostVer[] = { 2, 1, 3, 1, 4 };
        Integer CostHor[] = { 4, 1, 2 };

        Arrays.sort(CostVer, Collections.reverseOrder());
        Arrays.sort(CostHor, Collections.reverseOrder());

        int h = 0, v = 0; // pointers
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < CostHor.length && v < CostVer.length) {
            if (CostVer[v] <= CostHor[h]) { // horizontal cut
                cost += (CostHor[h] * vp);
                h++;
                hp++;
            } else { // vertical cut
                cost += (CostVer[v] * hp);
                v++;
                vp++;
            }
        }
        while (h < CostHor.length) {
            cost += (CostHor[h] * vp);
            h++;
            hp++;
        }
        while (v < CostVer.length) {
            cost += (CostVer[v] * hp);
            v++;
            vp++;
        }

        System.out.println("Minimum cost of cuts = " + cost);
    }
}
