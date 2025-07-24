class Solution {
    public int maximumGain(String s, int abScore, int baScore) {
        int totalScore = 0;
        char[] strArray = s.toCharArray();
        int length = strArray.length;

        // \U0001f4a5 Prioritize the higher scoring pair
        char firstChar = 'a', secondChar = 'b';
        int firstCount = 0, secondCount = 0;

        // \U0001f504 Swap if "ba" has more score than "ab"
        if (abScore < baScore) {
            int temp = abScore;
            abScore = baScore;
            baScore = temp;
            firstChar = 'b';
            secondChar = 'a';
        }

        for (int i = 0; i < length; i++) {
            if (strArray[i] == firstChar) {
                firstCount++;
            } else if (strArray[i] == secondChar) {
                if (firstCount > 0) {
                    firstCount--;
                    totalScore += abScore;
                } else {
                    secondCount++;
                }
            } else {
                // \U0001f527 Resolve remaining lower-scoring pairs
                totalScore += Math.min(firstCount, secondCount) * baScore;
                firstCount = 0;
                secondCount = 0;
            }
        }

        // ✅ Handle leftovers
        totalScore += Math.min(firstCount, secondCount) * baScore;

        return totalScore;
    }
}