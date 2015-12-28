package com.simplebank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.simplebank.businesslogic.Annuity;
import com.simplebank.businesslogic.DecliningBalance;
import com.simplebank.db.DataBase;
import com.simplebank.helper.CheckData;
import com.simplebank.ui.Visual;

public class Main {
	public static void main(String[] args) throws IOException {
		/*DataBase db = new DataBase();
		db.AddContract(1234, 10000, 25, 0.25, "ANN");
		db.AddContract(1236, 10000, 25, 0.25, "ANN");
		db.count();
		System.out.println(db.isContract(1255));
		System.out.println(db.isContract(1234));
		System.out.println(db.isContract(1236));*/
		
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Visual("ENG").Message("hello");
		
        String langLine = null;//work this choice of language
		do{
			new Visual("ENG").Message("choice_lang");
	        try {
	        	langLine = br.readLine();	        	
			} catch (Exception e) {
				e.printStackTrace();
			}
        } while (new CheckData().checkLang(langLine) == false);
		
		
		
		String endLine = null;//work this another choice
		do{
			
        String typeLine = null;//work this choice of bank operation
		do{
			new Visual(langLine).Message("choice_type");
	        try {
	        	typeLine = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
        } while (new CheckData().checkTypeOperation(typeLine) == false);
		
		
			if (Integer.parseInt(typeLine)==1){// work this add new contract
				String credit = null;
				String[] enterData = new String[5];
				try {
					boolean check;
					boolean checkIs;
					do {
						new Visual(langLine).Message("create_credit");
						credit = br.readLine();
						enterData = credit.split(" ");
						check = new CheckData().checkEnterDataForCreate(enterData);
						if (check==false){new Visual(langLine).Message("not_correct_format");}
					}while(check==false);
					
					checkIs = new CheckData().checkIsContract(Integer.parseInt(enterData[0]));
					if (checkIs==true){
						new Visual(langLine).Message("is_credit");
					}else{
						if (enterData[4].equals("ANN")){
							new Annuity().AddKredit(Integer.parseInt(enterData[0]),
													Integer.parseInt(enterData[1]),
													Integer.parseInt(enterData[2]),
													Double.parseDouble(enterData[3]),
													enterData[4]);
							new Visual(langLine).Message("data_save");
						}else if (enterData[4].equals("DEC")){
							new DecliningBalance().AddKredit(Integer.parseInt(enterData[0]),
															 Integer.parseInt(enterData[1]),
															 Integer.parseInt(enterData[2]),
															 Double.parseDouble(enterData[3]),
															 enterData[4]);
							new Visual(langLine).Message("data_save");
						}else{}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if (Integer.parseInt(typeLine)==2){//work this add new operation
				String credit = null;
				String[] enterData = new String[2];
				String summaPayment = null;
				boolean checkIs;
				try {
					boolean check;
					do {
						new Visual(langLine).Message("refill_credit");
						credit = br.readLine();
						enterData = credit.split(" ");
						check = new CheckData().checkEnterDataForRefill(enterData);
						if (check==false){new Visual(langLine).Message("not_correct_format");}						
					}while(check==false);
					checkIs = new CheckData().checkIsContract(Integer.parseInt(enterData[0]));
					if (checkIs==false){
						new Visual(langLine).Message("no_credit");
					}else{
						if (enterData[1].equals("ANN")){
							new Annuity().GetDebit(Integer.parseInt(enterData[0]));
							new Visual(langLine).Message("summa_credit");
							summaPayment = br.readLine();
							new Annuity().AddDebit(Integer.parseInt(enterData[0]),Double.parseDouble(summaPayment));
							new Visual(langLine).Message("data_save");
						}else if (enterData[1].equals("DEC")){
							new DecliningBalance().GetDebit(Integer.parseInt(enterData[0]));
							new Visual(langLine).Message("summa_credit");
							summaPayment = br.readLine();
							new DecliningBalance().AddDebit(Integer.parseInt(enterData[0]),Double.parseDouble(summaPayment));
							new Visual(langLine).Message("data_save");
						}else{}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{}
					
			new Visual(langLine).Message("some_else");
	        try {
	        	endLine = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
        } while (new CheckData().checkEnd(endLine) == false);
		new Visual(langLine).Message("good_bay");
	}
}