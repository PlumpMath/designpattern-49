package com.feaven.designpattern.creational.factory;

/**
 * Created by pavel on 15/1/13.
 */
public class SenderFactory {

	public static Sender produce(String type) {

		Class classOfSender = null;
		try {
			classOfSender = Class.forName(type);
			return (Sender)classOfSender.newInstance();
		} catch (Exception e) {
			System.err.println("Please input a correct type!");
		}
		return null;
	}

}
