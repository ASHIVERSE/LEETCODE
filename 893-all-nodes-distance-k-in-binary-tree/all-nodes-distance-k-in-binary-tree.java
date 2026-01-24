/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode curr = q.poll();

        if (curr.left != null) {
            parentMap.put(curr.left, curr); // child → parent
            q.add(curr.left);
        }

        if (curr.right != null) {
            parentMap.put(curr.right, curr); // child → parent
            q.add(curr.right);
        }
    }
}

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        q.add(target);
        visited.put(target, true);

        int currLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (currLevel == k) break;

            currLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.containsKey(curr.left)) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && !visited.containsKey(curr.right)) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }

                if (parentMap.containsKey(curr) &&
                    !visited.containsKey(parentMap.get(curr))) {
                    q.add(parentMap.get(curr));
                    visited.put(parentMap.get(curr), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}
