package sajatHasMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMap2<K, V> implements Map<K, V> {

	private final int PRIME = 7;
	ArrayList<LinkedMap<K, V>> rows;
	int size;

	private int hash(Object key) {
		int result;
		result = key.hashCode() % PRIME;

		return result;
	}

	public HashMap2() {
		super();
		this.rows = new ArrayList<LinkedMap<K, V>>(PRIME);
		for (int index = 0; index < PRIME; index++) {
			rows.add(new LinkedMap<K, V>());
		}
		this.size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		size = 0;
		for (int index = 0; index < PRIME; index++) {
			size += rows.get(index).size();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		for (int index = 0; index < PRIME; index++) {
			if (!rows.get(index).isEmpty())
				return false;
		}

		return true;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub

		int index = hash(key);
		return rows.get(index).containsKey(key);

	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		for (int index = 0; index < PRIME; index++)
			if (rows.get(index).containsValue(value))
				return true;
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		int index = hash(key);
		return rows.get(index).get(key);
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		int index = hash(key);
		return rows.get(index).put(key, value);
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		int index = hash(key);
		return rows.get(index).remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		Set<? extends K> keys = m.keySet();
		for (K key : keys) {
			this.put(key, m.get(key));
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int index = 0; index < PRIME; index++)
			rows.get(index).clear();
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		Set<K> keys = new HashSet<K>();
		for (int index = 0; index < PRIME; index++)
			keys.addAll(rows.get(index).keySet());
		return keys;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		Collection<V> collection = new ArrayList<>();
		for (int index = 0; index < PRIME; index++)
			collection.addAll(rows.get(index).values());
		return collection;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K, V>> result = new HashSet<>();
		for (int index = 0; index < PRIME; index++)
			result.addAll(rows.get(index).entrySet());
		return result;
	}

}
