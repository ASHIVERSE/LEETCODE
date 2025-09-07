
class Solution {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            ans[i] = "";
        }

        int i = 0; // index for input string

        while (i < s.length()) {
            // go down
            for (int index = 0; index < numRows && i < s.length(); index++) {
                ans[index] += s.charAt(i++);
            }
            // go up diagonally
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                ans[index] += s.charAt(i++);
            }
        }

        String res = "";
        for (String str : ans) {
            res += str;
        }

        return res;
    }
}
