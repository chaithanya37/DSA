
class Solution {
    public int maxValue(int[][] events, int k) {

        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        int n = events.length;

    
        Integer[][] dp = new Integer[n][k + 1];

        return dfs(events, 0, k, dp);
    }

    private int findNext(int[][] events, int index) {
        int left = index + 1, right = events.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > events[index][1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int dfs(int[][] events, int index, int k, Integer[][] dp) {
        if (index == events.length || k == 0) return 0;
        if (dp[index][k] != null) return dp[index][k];


        int skip = dfs(events, index + 1, k, dp);
        int nextIndex = findNext(events, index);
        int take = events[index][2] + dfs(events, nextIndex, k - 1, dp);

        return dp[index][k] = Math.max(skip, take);
    }
}
