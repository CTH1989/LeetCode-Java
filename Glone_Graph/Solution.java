/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.Hashtable;
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode ans = null;
        if (node == null)
            return null;
        if (node.neighbors.size() == 0) {
            ans = new UndirectedGraphNode(node.label);
            return ans;
        }
        Hashtable<Integer, Integer> visit = new Hashtable<Integer, Integer>();
        Hashtable<Integer, UndirectedGraphNode> mark = new Hashtable<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        que.offer(node);
        
        while (!que.isEmpty()) {
            UndirectedGraphNode np = que.poll();
            if (!visit.containsKey(np.label)) {
                UndirectedGraphNode pp = null;
                if (mark.containsKey(np.label))
                    pp = mark.get(np.label);
                else {
                    pp = new UndirectedGraphNode(np.label);
                    mark.put(pp.label, pp);
                }
                if (ans == null)
                    ans = pp;
                for (UndirectedGraphNode Ele : np.neighbors) {
                    if (mark.containsKey(Ele.label)) {
                        pp.neighbors.add(mark.get(Ele.label));
                    } else {
                        UndirectedGraphNode tp = new UndirectedGraphNode(Ele.label);
                        mark.put(Ele.label, tp);
                        pp.neighbors.add(tp);
                    }
                    if (!visit.containsKey(Ele.label))
                        que.offer(Ele);
                }
                visit.put(np.label, 1);
            }
        }
        
        return ans;
    }
}
