package com.simplebank.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.simplebank.helper.Messenger;
import com.simplebank.businesslogic.Messenger;

public class Visual implements IVisual{
	public ApplicationContext context;
	public Visual (String str){
		if (str.equals("ENG")){
			context = new ClassPathXmlApplicationContext("lang_en.xml");
		}else if (str.equals("RUS")){
			context = new ClassPathXmlApplicationContext("lang_ru.xml");
		}else if (str.equals("UAH")){
			context = new ClassPathXmlApplicationContext("lang_ua.xml");
		}else {}
	}

	@Override
	public void MessageVelcome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ShowPymentGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MessageContractNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Message(String str) {
		Messenger bean = (Messenger) context.getBean(str);
		bean.getMessage();
	}
	
}