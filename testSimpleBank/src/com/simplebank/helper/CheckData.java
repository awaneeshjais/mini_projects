package com.simplebank.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplebank.db.DataBase;

public class CheckData {
	//ApplicationContext context = new  ClassPathXmlApplicationContext("settings.xml");
	
	public boolean checkLang(String str){
		//Messenger bean = (Messenger) context.getBean(str);
        Pattern p = Pattern.compile("^ENG$|^RUS$|^UAH$");  
        Matcher m = p.matcher(str);  
        return m.matches();  		
	}
	
	public boolean checkTypeOperation(String str){
        Pattern p = Pattern.compile("^1$|^2$");  
        Matcher m = p.matcher(str);  
        return m.matches();  		
	}	
	
	public boolean checkEnd(String str){
        Pattern p = Pattern.compile("^N$");  
        Matcher m = p.matcher(str);  
        return m.matches();  		
	}	
	
	public boolean checkEnterDataForCreate(String[] str){//[NUMBER_CREDIT(NNNN) SUMMA(NNNNNNN) COUNT_YEARS(YY) PERCENT(0.XX) TYPE_CREDIT(ANN/DEC)]
		Matcher mCredit = Pattern.compile("^[0-9]{4}$").matcher(str[0]);
		Matcher mSumma = Pattern.compile("^[0-9]{1,7}$").matcher(str[1]);
		Matcher mYears = Pattern.compile("^[0-9]{1,3}$").matcher(str[2]);
		Matcher mPercent = Pattern.compile("^0.[0-9]{1,2}$").matcher(str[3]);
		Matcher mType = Pattern.compile("^ANN$|^DEC$").matcher(str[4]);
		if (mCredit.matches() && mSumma.matches() && mYears.matches() && mPercent.matches() && mType.matches()){
			return true;
		}else{
			return false;
		}		
	}
	
	public boolean checkEnterDataForRefill(String[] str){//[NUMBER_CREDIT(NNNN) SUMMA(NNNNNNN)]
		Matcher mCredit = Pattern.compile("^[0-9]{4}$").matcher(str[0]);
		Matcher mType = Pattern.compile("^ANN$|^DEC$").matcher(str[1]);
		//Matcher mSumma = Pattern.compile("^[0-9]{3,7}$").matcher(str[1]);
		//if (mCredit.matches() && mSumma.matches()){
		if (mCredit.matches() && mType.matches()){	
			return true;
		}else{
			return false;
		}		
	}
	
	public boolean checkIsContract(int creditNumber){
		DataBase db = new DataBase();
		db.isContract(creditNumber);
		if (db.isContract(creditNumber)){	
			return true;
		}else{
			return false;
		}
	}
}
