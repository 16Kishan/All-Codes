class Solution {
  public int maxDepth(Node node) {
    if (node == null) return 0;
    
    var max = 0;

    for (var child : node.children)
      max = Math.max(max, maxDepth(child));

    return max + 1;
  }
}