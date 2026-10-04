class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m == 0) {
            return 0;
        }

        if (m > n) {
            return -1;
        }

        long MOD = 1_000_000_007L;
        long BASE = 10;

        long patternHash = 0;
        long windowHash = 0;

        // 10^(m-1)
        long highestPower = 1;
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }

        // Pattern hash
        for (int i = 0; i < m; i++) {
            patternHash =
                (patternHash * BASE + needle.charAt(i)) % MOD;
        }

        // First window hash
        for (int i = 0; i < m; i++) {
            windowHash =
                (windowHash * BASE + haystack.charAt(i)) % MOD;
        }

        // Sliding window
        for (int i = 0; i <= n - m; i++) {

            // Hash matched
            if (patternHash == windowHash) {

                // Verify actual characters
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }

            // Calculate next window hash
            if (i < n - m) {

                // Remove outgoing character
                windowHash =
                    (windowHash
                    - haystack.charAt(i) * highestPower) % MOD;

                // Make positive
                if (windowHash < 0) {
                    windowHash += MOD;
                }

                // Shift and add incoming character
                windowHash =
                    (windowHash * BASE + haystack.charAt(i + m)) % MOD;
            }
        }

        return -1;
    }
}