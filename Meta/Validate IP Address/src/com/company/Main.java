package com.company;

public class Main {

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            if (queryIP.endsWith("."))
                return "Neither";
            String[] parts = queryIP.split("\\.");
            if (parts.length != 4)
                return "Neither";
            for (String part : parts) {
                if (!validateNumber(part))
                    return "Neither";
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            if (queryIP.endsWith(":"))
                return "Neither";
            String[] parts = queryIP.split(":");
            if (parts.length != 8)
                return "Neither";
            for (String part : parts) {
                if (!validateHex(part))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validateNumber(String str) {
        char[] chs = str.toCharArray();
        if (chs.length < 1 || chs.length > 3)
            return false;
        if (chs.length > 1 && chs[0] == '0')
            return false;
        for (char ch : chs) {
            if (ch > '9' || ch < '0')
                return false;
        }
        int val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    }

    private boolean validateHex(String str) {
        char[] chs = str.toCharArray();
        if (chs.length > 4 || chs.length < 1)
            return false;
        for (char ch : chs) {
            if (!( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F') ))
                return false;
        }
        return true;
    }

    public void work() {
        System.out.println(validIPAddress("11111111111111111111111111111111111111111.2.3.4."));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
