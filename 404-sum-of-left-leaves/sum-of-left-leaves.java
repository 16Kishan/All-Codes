
class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
       return func(root,false);
    }
    public  int func(TreeNode root,boolean found){
         if(root==null){
            return 0;

        }
       
        if(root.left==null && root.right==null && found){
           return root.val;
         
        }
       int l= func(root.left,true);
       int r= func(root.right,false);
        return l+r;
       
    }
}