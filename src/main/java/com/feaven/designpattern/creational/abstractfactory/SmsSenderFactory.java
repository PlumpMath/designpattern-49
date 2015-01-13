package com.feaven.designpattern.creational.abstractfactory;

import com.feaven.designpattern.creational.factory.Sender;
import com.feaven.designpattern.creational.factory.SmsSender;

/**
 * Created by pavel on 15/1/13.
 */
public class SmsSenderFactory implements AbstractSenderFactory {

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
