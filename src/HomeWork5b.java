

/**
 * (10pts) An integer pp is a period of a string s if s=tt...tu(t repeats p times, and u is a prefix of t).
 * The period of s is the largest such integer p. For example, if s=ababababababa, then 2,3,6 are periods of s, and
 * we refer to 6 as the period of s.
 * <p>
 * Created by Surag on 3/1/17.
 */
public class HomeWork5b {

    public static void main(String[] args) {
        String z1 = "ababababababa";
        String z2 = "aaaaaaaaaaaa";
        String z3 = "abababab";
        String z4 = "abababababx";
        String z6 = "abababxyabababxyababa";
        String z7 = "abababababaaaababab";
        String z8 = "abcdefabcdefabcd";
        System.out.println(getPeriod(z1));
        System.out.println(getPeriod(z2));
        System.out.println(getPeriod(z3));
        System.out.println(getPeriod(z4));
        System.out.println(getPeriod(z6));
        System.out.println(getPeriod(z7));
        System.out.println(getPeriod(z8));
    }

    private static int getPeriod(String s) {
        System.out.println(s);
        int[] z = findZvalue(s);
        printArr(z);
        int t = s.length();
        int jump = 1;
        for (int i = 0; i < z.length; i = i + jump) {
            if (z[i] != 0) {
                if (z[i] + i == s.length()) {
                    int x = s.length() - z[i];
                    if (x < t) {
                        t = x;
                        jump = x;
                    }
                } else {
                    jump = 1;
                    t = s.length();
                }
            }
        }
        System.out.println("|t| = " + t);
        System.out.println("t = " + s.substring(0, t));
        String u = s.substring((int) (s.length() / t) * t, s.length());
        System.out.println("u = " + u);
        int k = s.length() / t;
        System.out.println("period = " + k);
        return k;
    }


    private static void printArr(int[] z) {
        System.out.print(z.length + " : ");
        for (int n : z) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static int[] findZvalue(String s) {
        int[] z = new int[s.length()];
        int l = 0, r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i > r) {
                int j = 0;
                while (i + j < s.length() && s.charAt(j + i) == s.charAt(j)) {
                    j++;
                }
                z[i] = j;
                l = i;
                r = i + j - 1;
            } else if (z[i - l] < r - l + 1) {
                z[i] = z[i - l];
            } else {
                int j = 0;
                while (j + i < s.length() && s.charAt(j + i) == s.charAt(j)) {
                    j++;
                }
                z[i] = j;
                l = i;
                r = i + j - 1;
            }
        }
        return z;
    }
}
