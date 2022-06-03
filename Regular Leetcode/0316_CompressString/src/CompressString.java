public class CompressString {
    public String compressString(String S) {
        int length = S.length();
        if (length == 0)
            return "";
        char current = S.charAt(0);
        int count = 1;
        String ret = current + "";
        for (int i = 1; i < length; i++) {
            char now = S.charAt(i);
            if (now == current) {
                count++;
            } else {
                ret += count;
                count = 1;
                current = now;
                ret += current;
            }

            if (ret.length() >= length)
                return S;
        }
        ret += count;
        if (ret.length() >= length)
            return S;
        return ret;
    }

    public CompressString() {
        System.out.println(compressString("a"));
    }

    public static void main(String[] args) {
        new CompressString();
    }
}
