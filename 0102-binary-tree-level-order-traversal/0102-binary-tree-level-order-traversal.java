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
 import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root,0,list);
        return list;
    }

    public static void dfs(TreeNode node, int depth,List<List<Integer>> list){
        // node left, right 있으면 저장
        // 루트의 자식들 출력
        // 가지치기를 해야하나? left, right 둘다 
        if(node==null) return;
        if(depth == list.size()){
            list.add(new ArrayList<>());
        }
        list.get(depth).add(node.val);
        dfs(node.left,depth+1,list);
        dfs(node.right,depth+1,list);
    }
}