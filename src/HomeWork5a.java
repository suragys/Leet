/**
 * (10 pts.) Write a linear-time algorithm bool IsCircularRotation(string s, string t) to determine whether t is
 * obtained by shifting each letter of s by some distance d (wrapping around when necessary).
 * For example arc and car are cyclic rotations of each other.
 * <p>
 * Created by surag on 3/3/17.
 */
public class HomeWork5a {

    public static void main(String[] args) {

        String s = "car";
        String t = "arc";
        System.out.println(isCircularRotation(s, t));
    }

    private static boolean isCircularRotation(String s, String t) {
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        s = s + s;
        String comp = t + " # " + s;
        int[] z = findZValue(comp);
        for (int i = t.length() + 1; i < z.length; i++) {
            if (z[i] == t.length()) return true;
        }
        return false;
    }

    private static int[] findZValue(String s) {
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
