package limitedsets;

/**
 * 
 * 
 * @author Alexey Kopylov
 *
 * @param <T>
 */
public interface LimitedSet<T> {
	/**
	 * @param t
	 */
	void add(final T t);
    /**
     * @param t
     * @return
     */
    boolean remove(final T t);
    /**
     * @param t
     * @return
     */
    boolean contains(final T t);
}
