package com.feaven.designpattern.creational.abstractfactory;

import com.feaven.designpattern.creational.factory.MailSender;
import com.feaven.designpattern.creational.factory.Sender;

/**
 * Created by pavel on 15/1/13.
 */
public class MailSenderFactory implements AbstractSenderFactory {

	@Override
	public Sender produce() {
		return new MailSender();
	}
}
