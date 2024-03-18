import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(0);
        traversal(0, list, graph, l);
        return list;
    }

    private void traversal(int i, List<List<Integer>> list, int[][] graph, LinkedList<Integer> l) {

        if (i == graph.length - 1) {
            // l.add(graph[i].length - 1);
            Object tempo = l.clone();
            list.add((LinkedList) tempo);
            if (l.size() > 0) {
                l.remove(l.size() - 1);
            }
        } else if (graph[i].length == 0) {
            if (l.size() > 0) {
                l.remove(l.size() - 1);
            }
            return;
        } else {

            for (int j = 0; j < graph[i].length; j++) {
                l.add(graph[i][j]);
                traversal(graph[i][j], list, graph, l);
            }
            l.remove(l.size() - 1);
        }
    }
}