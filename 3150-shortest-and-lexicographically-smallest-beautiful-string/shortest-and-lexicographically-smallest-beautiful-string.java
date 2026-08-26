class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
          // Store positions of all 1s
        ArrayList<Integer> ones = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // Not enough 1s
        if (ones.size() < k) {
            return "";
        }

        String answer = "";

        // Consider every group of k consecutive 1s
        for (int i = 0; i <= ones.size() - k; i++) {

            int start = ones.get(i);
            int end = ones.get(i + k - 1);

            String current = s.substring(start, end + 1);

            if (answer.equals("") ||
                current.length() < answer.length() ||
                (current.length() == answer.length()
                 && current.compareTo(answer) < 0)) {

                answer = current;
            }
        }

        return answer;
    }
}