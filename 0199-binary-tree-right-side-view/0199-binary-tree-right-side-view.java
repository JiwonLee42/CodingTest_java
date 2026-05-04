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
    public List<Integer> rightSideView(TreeNode root) {

        // 오른쪽에서 바라보면 오른쪽에 있는 노드만 보임
        // 노드의 값을 순서대로 
        // 루트가 주어질 때, 위에서 아래 순서대로 보이는 노드 값 반환
        // 위에서부터 순서대로 
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0);
        return list;

    }

    public static void dfs(TreeNode node, List<Integer> list, int depth) {
        if(node == null) return;
        if(depth == list.size()){
            list.add(node.val);
        }
        dfs(node.right,list, depth + 1);
        dfs(node.left,list, depth + 1);
    }
}

// 루트 -> 오른쪽이 없다면 왼쪽 루트노드 + 오른쪽 루트 / 오른쪽이 있다면 오른쪽, 오른쪽 