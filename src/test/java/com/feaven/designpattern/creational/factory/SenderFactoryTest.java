package com.feaven.designpattern.creational.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SenderFactoryTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testProducer() throws Exception {

		Sender mailSender = SenderFactory.produce(MailSender.class.getName());
		mailSender.send();
		assertEquals("This is MailSender!\n", outContent.toString());

		outContent.reset();
		Sender smsSender = SenderFactory.produce(SmsSender.class.getName());
		smsSender.send();
		assertEquals("This is SmsSender!\n", outContent.toString());

		Sender otherSender = SenderFactory.produce("other");
		assertNull(otherSender);
		assertEquals("Please input a correct type!\n", errContent.toString());
	}
}