package com.simplebank.businesslogic;

public class Messenger {
	 private String message;

	 public void setMessage(String message){
	    this.message  = message;
	 }

	 public void getMessage(){
	    System.out.println(message);
	 }
	 
	 public String getMessageStr(){
		 return message;
	 }
	 
	 public Double getMessageDouble(){
		 return Double.parseDouble(message);
	 }
	 
	 public int getMessageInt(){
		 return Integer.parseInt(message);
	 }
}
