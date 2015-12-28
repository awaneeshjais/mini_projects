package com.simplebank.ui;

import org.springframework.context.ApplicationContext;

import com.simplebank.businesslogic.Messenger;

public interface IVisual {
	public void Message(String str);
	public void MessageContractNumber();
	public void MessageVelcome();
	public void ShowPymentGrid();
}