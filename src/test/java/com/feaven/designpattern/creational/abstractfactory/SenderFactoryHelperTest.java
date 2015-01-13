package com.feaven.designpattern.creational.abstractfactory;

import com.feaven.designpattern.creational.factory.MailSender;
import com.feaven.designpattern.creational.factory.Sender;
import com.feaven.designpattern.creational.factory.SenderFactory;
import com.feaven.designpattern.creational.factory.SmsSender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SenderFactoryHelperTest {

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
	public void testGetFactory() {

		Sender otherSender = null;
		try {
			Sender mailSender = SenderFactoryHelper.getFactory(MailSenderFactory.class.getName()).produce();
			mailSender.send();
			assertEquals("This is MailSender!\n", outContent.toString());

			outContent.reset();
			Sender smsSender = SenderFactoryHelper.getFactory(SmsSenderFactory.class.getName()).produce();
			smsSender.send();
			assertEquals("This is SmsSender!\n", outContent.toString());

			SenderFactoryHelper.getFactory("other").produce();
		} catch (Exception e) {
			assertNull(otherSender);
			e.printStackTrace();
		}
	}
}