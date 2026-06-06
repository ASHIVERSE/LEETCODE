import java.util.*;

class Solution {

    // Largest Rectangle in Histogram
    private int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i <= n; i++) {

            while(!st.isEmpty() &&
                  (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];

                int rightSmall = i;

                int leftSmall = st.isEmpty() ? -1 : st.peek();

                int width = rightSmall - leftSmall - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for(int i = 0; i < rows; i++) {

            // Build histogram
            for(int j = 0; j < cols; j++) {

                if(matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            // Find largest rectangle in current histogram
            maxArea = Math.max(maxArea,
                               largestRectangleArea(heights));
        }

        return maxArea;
    }
}