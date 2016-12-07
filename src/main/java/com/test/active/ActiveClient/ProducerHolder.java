package com.test.active.ActiveClient;

import javax.jms.MessageProducer;
import javax.jms.Session;

public class ProducerHolder {
 private MessageProducer messageProducer;
 private Session session;
public MessageProducer getMessageProducer() {
	return messageProducer;
}
public void setMessageProducer(MessageProducer messageProducer) {
	this.messageProducer = messageProducer;
}
public Session getSession() {
	return session;
}
public void setSession(Session session) {
	this.session = session;
}
 
}
