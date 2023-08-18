package tree;

import java.util.Comparator;

public class BinTree<K, V> {
	
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
	
	private Node<K,V> root;
	//K를 상속한 모든타입을 비교하는 제너릭
	private Comparator<? super K> comparator = null; 
	
	private void add(K key, V data) {
		if(root == null) {
			root = new Node<K,V>(key,data,null,null);
		}else {
			addNode(root,key,data);
		}
	}
	
	private void addNode(Node<K, V> node, K key, V data) {
		//node의 키값보다 작으면 left, 아니면 right 저장
		int cond = comp(key, node.getKey());
		if(cond == 0)
			return;//동일키가 이미 등록
		else if(cond < 0) { //왼쪽에 저장
			if(node.left == null)
				node.left = new Node<K,V>(key,data,null,null);
			else
				addNode(node.left,key,data);
		}else {             //오른쪽에 저장
			if(node.right == null)
				node.right = new Node<K,V>(key,data,null,null);
			else
				addNode(node.right,key,data);
		}
	}

	private int comp(K key1, K key2) {
		return (comparator==null)?
				(((Comparable<K>)key1).compareTo(key2)):
					(comparator.compare(key1, key2));
	}

	public static void main(String[] args) {
		BinTree<Integer, String> tr = new BinTree<Integer, String>();
		//등록
		Node<Integer, String> nd = new Node<Integer,String>(1,"홍길동");
		tr.add(nd.getKey(),nd.getData());
		nd = new Node<Integer,String>(3,"김길동");
		tr.add(nd.getKey(),nd.getData());
		nd = new Node<Integer,String>(2,"박길동");
		tr.add(nd.getKey(),nd.getData());
		
	}
}
