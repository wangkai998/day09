package com.xiaoshu.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		//接受消息 发的J'son字符串  接收时需要强转成String才可以
		TextMessage mas=(TextMessage)message;
		//获取消息
		try {
			
			String json = mas.getText();
			System.out.println("《《《《《《《《《《《《《《《信息+"+json);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
