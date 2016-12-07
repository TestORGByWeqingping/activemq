package com.test.active.ActiveClient;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class ProducerFactory {
	enum COUSUMNER_TYPE{
		QUQUE,TOPIC
	}
	
	private ActiveConnectionManager manger;
	
    public ActiveConnectionManager getManger() {
		return manger;
	}

	public void setManger(ActiveConnectionManager manger) {
		this.manger = manger;
	}

	private ConnectionFactory connectionFactory ;
    
	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public ProducerHolder createProducer(String queueOrTopicName,COUSUMNER_TYPE type)throws Exception{
	     manger=new ActiveConnectionManager(connectionFactory);
		Connection conn=manger.getConnection();
		Session session=  conn.createSession(true, Session.SESSION_TRANSACTED);
		Destination dest=null;
		if(type==COUSUMNER_TYPE.QUQUE){
			dest=session.createQueue(queueOrTopicName);
		}else if(type==COUSUMNER_TYPE.TOPIC){
			dest=session.createTopic(queueOrTopicName);
		}else{
			throw new Exception("error COUSUMNER TYPE ");
		}
		
        MessageProducer  messageProducer=session.createProducer(dest);
        ProducerHolder holder=new ProducerHolder();
        holder.setMessageProducer(messageProducer);
        holder.setSession(session);
		return holder;
	}
	
	
	

}
