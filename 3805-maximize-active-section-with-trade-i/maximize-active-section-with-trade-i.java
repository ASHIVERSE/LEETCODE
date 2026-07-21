class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
         int initialOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                initialOnes++;
        }

        String t = "1" + s + "1";

        List<Character> chars = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;

        while (i < t.length()) {
            char ch = t.charAt(i);
            int j = i;

            while (j < t.length() && t.charAt(j) == ch)
                j++;

            chars.add(ch);
            len.add(j - i);

            i = j;
        }

        int maxProfit = 0;

        for (i = 1; i < chars.size() - 1; i++) {

            if (chars.get(i) == '1'
                    && chars.get(i - 1) == '0'
                    && chars.get(i + 1) == '0') {

                int profit = len.get(i - 1) + len.get(i + 1);
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return initialOnes + maxProfit;
    }
}