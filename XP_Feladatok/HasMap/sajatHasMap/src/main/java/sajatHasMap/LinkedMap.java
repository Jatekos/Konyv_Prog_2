package sajatHasMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LinkedMap<K, V> implements Map<K,V> {

	private Node<K, V> root;
	
	public LinkedMap() {
		root = null;
	}
	
	private static class Node<K,V> implements Map.Entry<K, V>{
		
		private K key;
		private V value;
		private Node<K, V> next;
		
		public Node(K key, V value, Node<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		} 
		
		 @Override
		public String toString() {
			// TODO Auto-generated method stub
			
			 String string ="Key: "+ getKey() +" "+ "Value: "+ getValue() ;
			 
			 return string; 
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node<K,V> other = (Node<K,V>) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
	
		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V value) {
			this.value = value;
			return  value;
		}

		public Node<K, V> getNext() {
			return next;
		}

		public void setNext(Node<K, V> next) {
			this.next = next;
		}
			
	}
	
	@Override
	public String toString() {
		Node<K,V> currentNode = root;
		String string="LinkidMap [root]" ;
		while (currentNode != null) {
			string= string +" "+ currentNode.toString();
			currentNode=currentNode.getNext();
		}
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Node<K,V> current=root;
		while(current != null) {
			result = result +current.hashCode();
			current=current.next;
		}
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedMap<K,V> other = (LinkedMap) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else {
			if (other.root == root)
				return true;//Ezz nincs tesztelve elméletileg nem is lehetne ilyen eset maximum a node setNext()-jével Null nál true-t add vissza
			if (this.root.key.getClass() != other.root.key.getClass())
				return false;
			if (this.root.value.getClass() != other.root.value.getClass())
				return false;
			Node<K, V> current =root ;
			Node<K, V> otherCurrent =other.root;
			boolean isItEquals = true; 
			while ((current.next != null)&&(otherCurrent.next != null) && isItEquals) {
				isItEquals = current.equals(otherCurrent);
				current = current.next;
				otherCurrent =otherCurrent.next;
			}
			if ((current.next == null) && (otherCurrent.next != null) || ((current.next != null) && (otherCurrent.next == null) ) )
				return false;
			if (!isItEquals)
				return false;
		}
			
		return true;
	}

	@Override
	public int size() {
		int size = 0;	
		Node<K,V> node =root;
		while (node != null) {
			
			node=node.getNext();
			size++;
			
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		if (root == null)
			return true;
		
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		Node<K,V> node =root;
		while (node != null) {
			if (node.getKey() == key) {
				return true;
			}else {
				node=node.getNext();
			}
		}
		
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		
		Node<K,V> node =root;
		while (node != null) {
			if (node.getValue() == value) {
				return true;
			}else {
				node=node.getNext();
			}
		}
		
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO
		
		Node<K,V> node =root;
		while (node != null) {
			if (node.getKey() == key) {
				return node.getValue();
			}else {
				node=node.getNext();
			}	
		}
		
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if (!containsKey(key)) {
		Node<K, V> node =new Node<>(key,value,root);
		root = node;
		return value;
		}else {
			return null;
		}
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub elsõ elem???
		Node<K,V> befor =root;
		Node<K,V> current=root;
		
		while (current != null) {
			if (current.getKey() == key) {
				befor.setNext(current.getNext());
				return current.getValue();
			} else {
				befor=current;
				current=current.getNext();
			}
			
		}
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		//Sorendet nem tartja
		
		Set<? extends K> keys = m.keySet();	
		for ( K key:keys) {
			this.put(key, m.get(key));			
		}
				
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root=null;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		Set<K> keys =  new HashSet<K>();
		Node<K,V> currentNode =root;
		
		while (currentNode != null) {
			keys.add(currentNode.getKey());
			currentNode = currentNode.getNext();
		}
		
		return keys;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		
		Node<K,V> currentNode =root;
		Collection<V> collection =new ArrayList<>();
		while (currentNode != null) {
			collection.add(currentNode.getValue());
			currentNode=currentNode.getNext();
		}
		return collection;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K, V>> result = new HashSet<>();
		Node<K,V> currentNode =root;
		while (currentNode != null) {
			result.add(currentNode);
			currentNode=currentNode.getNext();
		}
		
        return result;
	}
}