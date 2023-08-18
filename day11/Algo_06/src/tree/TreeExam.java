package tree;

public class TreeExam {
	
	static class Node<K,V>{
		private K key;
		private V data;
		private Node<K,V> left;
		private Node<K,V> right;
		
		public Node(K key, V data) {
			this(key,data,null,null);
		}

		public Node(K key, V data, Node<K,V> left, Node<K,V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public K getKey() {
			return key;
		}

		public V getData() {
			return data;
		}

		@Override
		public String toString() {
			return "K: "+key+", V: "+data+", LEFT: "+left+", RIGHT: "+right;
		}
	}
	
	public static void main(String[] args) {
		Node<String, Integer> node = new Node<String, Integer>("홍길동",90,null,null); 
		Node<String, Integer> node2 = new Node<String, Integer>("홍길동",90); 
		System.out.println(node);
		
	}
}
