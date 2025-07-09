class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int windowSize = k + 1;
        int maxFree = 0;
        int currentSum = 0;

        for (int i = 0; i <= n; i++) {
            currentSum += gaps[i];
            if (i >= windowSize) {
                currentSum -= gaps[i - windowSize];
            }
            if (i >= windowSize - 1) {
                maxFree = Math.max(maxFree, currentSum);
            }
        }

        return maxFree;
    }
}
