package com.om.generalization;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class CommandTests {
	@Test
	public void testLoginCommandSentCorrectly() throws Exception {
		final byte knownGood[] = { (byte) 0xde, (byte) 0xad, 20, 0x01, 'b',
				'a', 'b', 0x00, 'c', 'a', 'r', 'd', 'i', 'n', 'a', 'l', 's',
				0x00, (byte) 0xbe, (byte) 0xef };

		LoginCommand cmd = new LoginCommand("bab", "cardinals");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		cmd.write(outputStream);

		for (int i = 0; i < knownGood.length; i++) {
			assertEquals("comparison failed at byte number " + i, knownGood[i],
					outputStream.toByteArray()[i]);
		}
	}

	@Test
	public void testAddEmployeeSentCorrectly() throws Exception {
		final byte knownGood[] = { (byte) 0xde, (byte) 0xad, 52, 0x02, 'F',
				'r', 'e', 'd', ' ', 'B', 'r', 'o', 'o', 'k', 's', 0x00, '1',
				'2', '3', ' ', 'M', 'y', ' ', 'H', 'o', 'u', 's', 'e', 0x00,
				'S', 'p', 'r', 'i', 'n', 'g', 'f', 'i', 'e', 'l', 'd', 0x00,
				'I', 'L', 0x00, '7', '2', '0', '0', '0', 0x00, (byte) 0xbe,
				(byte) 0xef };

		AddEmployeeCmd cmd = new AddEmployeeCmd("Fred Brooks", "123 My House",
				"Springfield", "IL", 72000);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		cmd.write(outputStream);

		for (int i = 0; i < knownGood.length; i++) {
			assertEquals("comparison failed at byte number " + i, knownGood[i],
					outputStream.toByteArray()[i]);
		}

	}

}
