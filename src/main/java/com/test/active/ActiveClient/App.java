package com.test.active.ActiveClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
      SendMessageService service=new SendMessageService();
      for (int i = 0; i < 100; i++) {
    	  service.sendMessage("1wwwwwwwwwwwww");
	}
    }
}
