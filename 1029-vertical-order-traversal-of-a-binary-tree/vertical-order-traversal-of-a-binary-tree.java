/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            TreeNode node=p.node;
            int row=p.row;
            int col=p.col;

            if(!map.containsKey(col))
            {
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(row))
            {
                map.get(col).put(row,new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);
            if(node.left!=null)
            {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }
            if(node.right!=null)
            {
                q.offer(new Pair(node.right,row+1,col+1));
            }
            
        }
        List<List<Integer>> ans=new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

    List<Integer> colList = new ArrayList<>();

    for (PriorityQueue<Integer> pq : rows.values()) {
        while (!pq.isEmpty()) {
            colList.add(pq.poll());
        }
    }

    ans.add(colList);
}
     return ans;
    }
}