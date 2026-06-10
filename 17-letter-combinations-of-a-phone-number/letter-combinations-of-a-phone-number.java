class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)
            return ans;

        String[] map = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, new StringBuilder(), ans, map);

        return ans;
    }

    void solve(int index,
               String digits,
               StringBuilder curr,
               List<String> ans,
               String[] map) {

        if(index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char ch : letters.toCharArray()) {

            curr.append(ch);

            solve(index + 1,
                  digits,
                  curr,
                  ans,
                  map);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}