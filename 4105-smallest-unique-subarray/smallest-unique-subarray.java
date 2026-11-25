

class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;
    static final long BASE = 911382323L;

    long[] h1, h2, pow1, pow2;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];

        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Build prefix hashes
        for (int i = 0; i < n; i++) {

            h1[i + 1] = (h1[i] * BASE + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE + nums[i]) % MOD2;

            pow1[i + 1] = (pow1[i] * BASE) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE) % MOD2;
        }

        // Binary Search
        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Check whether a unique subarray of length len exists
    boolean check(int[] nums, int len) {

        int n = nums.length;

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            int l = i;
            int r = i + len;

            long hash1 = (h1[r] - h1[l] * pow1[len] % MOD1 + MOD1) % MOD1;

            long hash2 = (h2[r] - h2[l] * pow2[len] % MOD2 + MOD2) % MOD2;

            // Combine both hashes
            long key = hash1 * MOD2 + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check if any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
