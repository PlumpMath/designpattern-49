package com.feaven.designpattern.creational.factory;

/**
 * Created by pavel on 15/1/13.
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("This is MailSender!");
	}

}
