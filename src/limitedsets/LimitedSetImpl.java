package limitedsets;

import java.util.LinkedList;

/**
 * The class presents set which contains 10 or less elements T 
 * 
 * @author Alexey Kopylov
 *
 * @param <T>
 */
public class LimitedSetImpl<T> implements LimitedSet<T> {

	private final int SIZE = 10;
	private final LinkedList<Node> limitedSet = new LinkedList<>();
	
	private class Node {
		Long time;
		T value;

		Node(Long time, T value) {
			this.time = time;
			this.value = value;
		}

		@Override
		public int hashCode() {
			return value.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (value == obj) {
				return true;
			}
			if (obj == null) {
				if (value != null) {
					return false;
				}
			}
			if (!value.equals(obj)) {
				return false;
			}
			return true;
		}

	}
	
	public LimitedSetImpl() {
	}
	
	/**
	 * Add new element in the set, if the set contains 10 elements, then will be removed the element which has last request time
	 * (Request time is the time when called methods add and contains)
	 * 
	 * @param t
	 */
	
	@Override
	public void add(T t) {
		if (!contains(t)) {
			long currentTime = System.currentTimeMillis();
			if (limitedSet.size() == SIZE) {
				limitedSet.removeLast();
			}
			limitedSet.add(new Node(currentTime, t));
		}
	}
	/**
	 * Remove the element from set
	 * 
	 * @param t
	 * 
	 * @return true if the element existed and false if the element didin't exist in the set
	 */
	
	@Override
	public boolean remove(T t) {
		for (Node node : limitedSet) {
			if(node.value.equals(t)) {
				limitedSet.remove(node);
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Check if the element exists in the set and if exists the method change time request to it
	 *  
	 * @param t
	 * @return true if the element exists and false if doesn't
	 */
	@Override
	public boolean contains(T t) {
		for (Node currentNode : limitedSet) {
			if(currentNode.value.equals(t)) {
				long currentTime = System.currentTimeMillis();
				Node newNode = new Node(currentTime, t);
				limitedSet.remove(currentNode);
				limitedSet.add(newNode);
				return true;
			}
		}
		return false;
	}

}
