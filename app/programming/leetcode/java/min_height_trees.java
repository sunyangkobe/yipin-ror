public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Set<Integer> vertices = new HashSet<>();
    Set<Integer>[] treeMap = new Set[n];
    for (int i = 0; i < n; i ++) {
      treeMap[i] = new HashSet<Integer>();
        vertices.add(i);
      }
      for (int i = 0; i < edges.length; i ++) {
        treeMap[edges[i][0]].add(edges[i][1]);
        treeMap[edges[i][1]].add(edges[i][0]);
      }

      while (vertices.size() > 2) {
        Set<Integer> leaves = new HashSet<>();
        for (Integer v : vertices) {
          if (treeMap[v].size() == 1) {
            leaves.add(v);
          }
        }
        
        for (Integer leaf : leaves) {
          for (Integer connectedNode : treeMap[leaf]) {
            treeMap[connectedNode].removeAll(leaves);
          }
        }
      vertices.removeAll(leaves);
    }
    return new ArrayList(vertices);
  }
}