package com.feaven.designpattern.creational.abstractfactory;

/**
 * Created by pavel on 15/1/13.
 */
public class SenderFactoryHelper {

	private AbstractSenderFactory senderFactory = null;

	public static AbstractSenderFactory getFactory(String factory) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class classOfSender = null;
		classOfSender = Class.forName(factory);
		return (AbstractSenderFactory)classOfSender.newInstance();
	}
}
