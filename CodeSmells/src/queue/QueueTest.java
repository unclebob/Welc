package queue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {
	@Test
	public void testQ() {
		Queue q = new Queue();
		q.addRear("E1");
		q.addRear("E2");
		assertEquals("E1", q.removeFront());
		assertEquals("E2", q.removeFront());
		assertEquals(0, q.getSize());
	}

}