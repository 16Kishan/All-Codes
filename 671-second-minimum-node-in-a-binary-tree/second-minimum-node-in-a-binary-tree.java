
class Solution {
   public int findSecondMinimumValue(TreeNode root) {
	if(root==null || root.right==null || root.left==null) return -1;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);
	Integer secondMin = null;
	while(!q.isEmpty()) {
		TreeNode curr = q.poll();
		if(curr.right!=null) q.offer(curr.right);
		if(curr.left!=null) q.offer(curr.left);
		if(curr.val!=root.val) {
			if(secondMin==null) secondMin = curr.val;
			else secondMin = Math.min(secondMin, curr.val);
		}
	}
	return secondMin==null? -1 : secondMin;
}
}