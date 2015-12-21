import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Trie {
	
	private Node root = new Node();
	
	class Node {		
		char prefix;
		boolean terminal = false;
		Map<Character, Node> nodes = new HashMap<>();
	}
	
	public void addWord(String word) {
		Node node = root;
		while (!word.isEmpty()) {
			char prefix = word.charAt(0);
			Node next = node.nodes.get(prefix);
			if (next == null) {
				next = new Node();
				next.prefix = prefix;
				node.nodes.put(prefix, next);
			}
			
			word = word.substring(1);
			node = next;
		}
		
		node.terminal = true;
	}
	
	public List<String> findByPrefix(String prefix) {
		List<String> words = new ArrayList<>();
		findByPrefix(root, prefix, "", words);
		
		if (prefix.isEmpty() && root.terminal) {
			words.add("");
		}
		
		return words;
	}
	
	private void findByPrefix(Node node, String prefix, String word, List<String> words) {
		word += node.prefix;
		if (!prefix.isEmpty()) {
			Node next = node.nodes.get(prefix.charAt(0));
			if (next != null) {
				findByPrefix(next, prefix.substring(1), word, words);
			}
		} else {
			if (node.terminal) {				
				words.add(word);
			}
			for (Node child : node.nodes.values()) {
				findByPrefix(child, prefix, word, words);
			}
		}
	}
	
	public int countWords() {
		int count = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.terminal) {
				++count;
			}
			for (Node child : node.nodes.values()) {
				q.add(child);
			}
		}
		
		return count;
	}
	
	public static void main(String [] args) {
		Trie trie = new Trie();
		
		trie.addWord("cat");
		trie.addWord("dog");
		trie.addWord("category");
		trie.addWord("catdog");
		trie.addWord("doggy");
		trie.addWord("dart weider");
		
		System.out.println("Words count: " + trie.countWords());
		
		List<String> words = trie.findByPrefix("cat");
		
		words.forEach(s-> System.out.println(s));
	}
	
}