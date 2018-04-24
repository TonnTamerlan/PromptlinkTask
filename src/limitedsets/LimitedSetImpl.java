package limitedsets;

import java.util.HashSet;
import java.util.Set;

/**
 * The class presents set which contains 10 or less elements T 
 * 
 * @author Alexey Kopylov
 *
 * @param <T>
 */
public class LimitedSetImpl<T> implements LimitedSet<T> {

	private final int SIZE = 10;
	private final Set<T> limitedSet = new HashSet<>(SIZE);
	private T lastElement;
	
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
			if (limitedSet.size() == SIZE) {
			    limitedSet.remove(lastElement);
			}
			limitedSet.add(t);
			lastElement = t;
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
		return limitedSet.remove(t);
	}
	
	/**
	 * Check if the element exists in the set and if exists the method change time request to it
	 *  
	 * @param t
	 * @return true if the element exists and false if doesn't
	 */
	@Override
	public boolean contains(T t) {
	    if(limitedSet.contains(t)) {
		    lastElement = t;
		    return true;
		}
		return false;
	}

}
