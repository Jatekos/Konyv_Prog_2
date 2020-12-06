package sajatHasMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




public class HasMap<K, V> implements Map<K,V> {

		private final int PRIME=7; 
		private ArrayList<Node<K,V>> roots;
		private int size;
		
		//private Node<K, V> root;
		
		public HasMap() {
			//root = null;
			roots = new ArrayList<Node<K,V>>(PRIME);
			//valid??
			for (int index=0; index<PRIME; index++)
				roots.add(null);
			size=0;
		}

		private int hash(Object key) {
			int result;
			result =key.hashCode() % PRIME;
			 
			return result; 
		}
		
		public int sizeOfRoots() {
			return roots.size();
		}
		
		
		private static class Node<K,V> implements Map.Entry<K, V>{
			
			private K key;
			private V value;
			private Node<K, V> next;
			
			public Node(K key, V value) {
				super();
				this.key = key;
				this.value = value;
				this.next = null;
			}
			public Node() {
				super();
				this.next = null;
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
			String string="HasMap \n" ;
			for (int i = 0 ; i<PRIME ; i++) {
				Node<K,V>currentNode = roots.get(i);
				string = string +i+": ";
				if (currentNode ==null) {
						string = string+"null ";
				}else{
						while(currentNode != null) {
							string= string +", "+ currentNode.toString()+" ";
							currentNode=currentNode.getNext();
						}
				}
				string=string+"\n";
			}
			return string;
		
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			
			for (int i = 0 ; i<PRIME ; i++) {
				Node<K,V>currentNode = roots.get(i);
				while(currentNode != null) {
					result = result +  currentNode.hashCode();
					currentNode=currentNode.getNext();
				}				
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
			HasMap<K,V> other = (HasMap) obj;
			if (roots == null) {
				if (other.roots != null)
					return false;
			} else {
				if (other.roots == roots)
					return true;//Ezz nincs tesztelve elméletileg nem is lehetne ilyen eset maximum a node setNext()-jével Null nál true-t add vissza
				if (this.roots.get(0).key.getClass() != other.roots.get(0).key.getClass())
					return false;
				if (this.roots.get(0).value.getClass() != other.roots.get(0).value.getClass())
					return false;
		

				for (int i = 0 ; i<PRIME ; i++) {
					Node<K,V>thisCurrentNode = roots.get(i);
					Node<K,V>otherCurrentNode = other.roots.get(i);
					while ((thisCurrentNode != null) || (otherCurrentNode != null)) {
						if (! thisCurrentNode.equals(otherCurrentNode))
							return false;
						thisCurrentNode=thisCurrentNode.getNext();
						otherCurrentNode=otherCurrentNode.getNext();
					}				
				}
				
			}
				
			return true;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
		
		@Override
		public int size() {
			
			return getSize();
		}


	
		@Override
		public boolean isEmpty() {
			
			for(int i=0; i<PRIME; i++) 
				if (roots.get(i) != null)
					return false;
			
			return true;
		}

		@Override
		public boolean containsKey(Object key) {
			// TODO Auto-generated method stub
			
			Node<K,V> currentNode =roots.get(hash(key));
			while (currentNode != null) {
				if (currentNode.getKey() == key) {
					return true;
				}else {
					currentNode=currentNode.getNext();
				}
			}
			
			return false;
		}

		@Override
		public boolean containsValue(Object value) {
			// TODO Auto-generated method stub
			for(int i=0; i<PRIME; i++) { 
				Node<K,V> currentNode =roots.get(i);
				while (currentNode != null) {
					if (currentNode.getValue() == value) {
						return true;
					}else {
						currentNode=currentNode.getNext();
					}
				}
			}
			
			return false;
		}

		@Override
		public V get(Object key) {
			// TODO
			int index=hash( key);
			
			Node<K,V> node =roots.get(index);
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
				int index = hash(key);
				
				Node<K, V> currentNode =roots.get(index);
				if (currentNode == null) {
					currentNode = new Node<K, V>(key, value);
					roots.add(index, currentNode);
					return value;
				}
				while (currentNode != null) {
					currentNode = currentNode.getNext();					
				}
				currentNode = new Node<K, V>(key, value);
				roots.add(index, currentNode);
				
				return value;
				
			}else {
				return null;
			}
		}

		@Override
		public V remove(Object key) {
			// TODO Auto-generated method stub elsõ elem???
			int index = hash(key);
			Node<K,V> current=roots.get(index);
			Node<K,V> befor=roots.get(index);
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
			// TODO Auto-generated method stub ?????
			for(int i=0; i<PRIME; i++) {
				Node<K,V>current=this.roots.get(i);
				current=null;
			}
		}

		@Override
		public Set<K> keySet() {
			// TODO Auto-generated method stub
			Set<K> keys =  new HashSet<K>();
			for(int i=0; i<PRIME; i++) {
				Node<K,V> currentNode =roots.get(i);
				while (currentNode != null) {
					keys.add(currentNode.getKey());
					currentNode = currentNode.getNext();
				}
			}
			return keys;
		}

		@Override
		public Collection<V> values() {
			// TODO Auto-generated method stub
			Collection<V> collection =new ArrayList<>();
			for(int i=0; i<PRIME; i++) {
				Node<K,V> currentNode =roots.get(i);
				while (currentNode != null) {
					collection.add(currentNode.getValue());
					currentNode=currentNode.getNext();
				}
			}
			return collection;
		}

		@Override
		public Set<Entry<K, V>> entrySet() {
			// TODO Auto-generated method stub
			Set<Entry<K, V>> result = new HashSet<>();
			for(int i=0; i<PRIME; i++) {
				Node<K,V> currentNode =roots.get(i);
				while (currentNode != null) {
					result.add(currentNode);
					currentNode=currentNode.getNext();
				}
			}
			
	        return result;
		}
}
