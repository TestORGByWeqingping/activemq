package com.test.active.ActiveClient;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class ActiveConnectionManager {
	private ConnectionFactory connectionFactory;
	
	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public ActiveConnectionManager(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	private  ThreadLocal<Connection>localConnectios=new ThreadLocal<Connection>();
	public Connection setConnection(Connection conn)throws JMSException{
		conn.start();
		localConnectios.set(conn);
		return conn;
	}
	
	public Connection getConnection() throws JMSException{
		if(null==localConnectios.get()){
			setConnection(connectionFactory.createConnection());
		}
		 return localConnectios.get();
	}
	
	public void closeConnection()throws JMSException{
		if(null!=localConnectios.get()){
			localConnectios.get().close();
			localConnectios.remove();
		}
	}

}
