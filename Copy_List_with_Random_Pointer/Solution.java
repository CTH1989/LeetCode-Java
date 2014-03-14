/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.Hashtable;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Hashtable<Integer, RandomListNode> hash = new Hashtable<Integer, RandomListNode>();
        Hashtable<Integer, RandomListNode> _hash = new Hashtable<Integer, RandomListNode>();
        RandomListNode np = head, _head = new RandomListNode(0);
        RandomListNode pp = _head;
        while (np != null) {
            pp.label = np.label;
            hash.put(np.label, np);
            _hash.put(pp.label, pp);
            if (np.next != null) {
                pp.next = new RandomListNode(0);
                pp = pp.next;
            }
            np = np.next;
        }
        np = head; pp = _head;
        while (np != null) {
            if (np.random != null) {
                int label = np.random.label;
                RandomListNode _random = _hash.get(label);
                pp.random = _random;
            }
            np = np.next;
            pp = pp.next;
        }
        return _head;
    }
}
