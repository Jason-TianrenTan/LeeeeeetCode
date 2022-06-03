import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int pos;
        int flag = 0;
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j)) && (pos = map.get(s.charAt(j))) >= i)
                i = pos + 1;
            map.put(s.charAt(j), j);
            if (j - i + 1 > max)
                max = j - i + 1;
        }
        return max;
    }

    public Main() {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static void main(String[] args) {
        new Main();
    }
}
