package com.test.active.ActiveClient;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.test.active.ActiveClient.ProducerFactory.COUSUMNER_TYPE;

public class SendMessageService {
	public void sendMessage(String message)throws Exception{
		ProducerFactory factory=new ProducerFactory();
		ConnectionFactory connfactory=new ActiveMQConnectionFactory("admin", "123456", "tcp://192.168.17.129:8083");
		factory.setConnectionFactory(connfactory);
		ProducerHolder holder=factory.createProducer("testQueue", COUSUMNER_TYPE.QUQUE);
        TextMessage txtMessage = holder.getSession().createTextMessage(message);
        MessageProducer producer= holder.getMessageProducer();
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        producer.send(txtMessage);
        holder.getSession().commit();
        factory.getManger().closeConnection();
	}
}
