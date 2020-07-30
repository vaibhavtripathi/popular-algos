import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Huffman {
    private Node root = null;
    private Map<Character, String> codes = new HashMap<>();

    public String encode(String s) {
        String coded = "";
        for (int i = 0; i < s.length(); i++) {
            coded += codes.get(s.charAt(i));
        }
        return coded;
    }

    public void process(Node root, String code) {
        if (root == null) {
            return;
        }
        if (root.ch == '.') {
            process(root.left, code + "0");
            process(root.right, code + "1");
            return;
        }
        this.codes.put(root.ch, code);
    }

    public Huffman(String s) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : m.keySet()) {
            queue.add(new Node(ch, m.get(ch)));
        }
        while (queue.size() > 1) {
            Node least = queue.poll();
            Node secondLeast = queue.poll();
            Node sum = new Node(least.count + secondLeast.count);
            sum.left = least;
            sum.right = secondLeast;
            queue.offer(sum);
        }
        this.root = queue.poll();
        process(this.root, "");
    }

    public static void main(String[] args) {
        String input = "aebbceea";
        Huffman h = new Huffman(input);
        String encoded = h.encode("abce");
        System.out.println(encoded);   
    }

    private class Node implements Comparable<Node> {
        char ch = '.';
        int count;
        Node left;
        Node right;

        public Node(int count) {
            this.count = count;
        }

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public int compareTo(Node n) {
            return this.count - n.count;
        }
    }
}