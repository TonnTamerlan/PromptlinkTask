package limitedsets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LimitedSetImplTest {

	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		LimitedSet<Integer> set = new LimitedSetImpl<>();
		for (int i = 0; i < 12; i++) {
			set.add(i);
		}
		assertTrue(set.contains(8));
		assertTrue(set.contains(11));
		assertFalse(set.contains(9));
	}

	@Test
	@DisplayName("Testing add method")
	void testRemove() {
		LimitedSet<Integer> set = new LimitedSetImpl<>();
		for (int i = 0; i < 12; i++) {
			set.add(i);
		}
		assertTrue(set.remove(1));
		assertFalse(set.contains(1));
		assertFalse(set.remove(1));
	}

	@Test
	@DisplayName("Testing contains method")
	void testContains() {
		LimitedSet<Integer> set = new LimitedSetImpl<>();
		for (int i = 0; i < 12; i++) {
			set.add(i);
		}
		assertFalse(set.contains(12));
		assertTrue(set.contains(5));
		set.add(12);
		assertFalse(set.contains(5));
	}
	
	@Test
	@DisplayName("Testing changing the element during adding new element when the set is full")
	void testChangingElement() {
	    LimitedSet<Integer> set = new LimitedSetImpl<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        //Testing change request time of element when used method contains
        assertTrue(set.contains(5));
        set.add(12);
        assertTrue(set.contains(12));
        assertFalse(set.contains(5));
        
        //Testing change request time when used method add and try to add element which already exists
        set.add(1);
        set.add(14);
        assertFalse(set.contains(1));
        
	}

}
