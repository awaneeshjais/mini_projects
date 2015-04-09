import java.io.*;

public class Main {
	
	public int counterSeparator (String line, String separator){//count separator into line
		int count = 0;
		int i = 0;
		while (i < line.length()) {
			if (separator.equals(line.substring(i, i + 1))) {
				count++;
			} else {
			}
			i++;
		}
		return count;
	}
	
	public int[] arrPositionSep(String line, String separator, int count){//add in array position separator from line
		int[] arrPositionSep = new int[count];
		int i = 0;
		int s = 0;
		while (i<line.length()){
			if (separator.equals(line.substring(i,i+1))){
				arrPositionSep[s] = i;
				s++;
			}else{}
			i++;
		}
		return arrPositionSep;
	}
	
	public String[] arrField(String line, String field, int count, int [] arrPos){//create fields - 3 symbols after separator
		String[] arrField = new String[count];
		for(int i = 0; i < count; i++){
			arrField[i] = field + line.substring(arrPos[i]+1,arrPos[i]+4);
		}
		return arrField;
	}
	
	public String[] arrValue(String line, String separator, int count, int []arrPos){//create value - from 4th symbols after separator to next separator
		String[] arrValue = new String[count];
		for(int i = 0; i < arrValue.length-1; i++){
			arrValue[i] = line.substring(arrPos[i]+4,arrPos[i+1]);
		}
		arrValue[count-1] = line.substring(arrPos[count-1]+4, line.length());
		return arrValue;
	}
	
	public String sequenceField(String[] arrField){//create string fields for insert
		String stringField = "";
		for (int i = 0; i<arrField.length;i++){
			stringField = stringField + arrField[i] + ", ";
		}		
		stringField = stringField.substring(0,stringField.length()-2);
		return stringField;
	}
	
	public String sequenceValue(String[] arrValue){//create string values for insert
		String stringValue = "";
		for (int i = 0; i<arrValue.length;i++){
			stringValue = stringValue + "'" + arrValue[i] + "', ";
		}		
		stringValue = stringValue.substring(0,stringValue.length()-2);
		return stringValue;
	}
	
	public String resultLine (String arrF, String arrV, String nameDB){//create insert
		String outLine = "";
		outLine = "INSERT INTO " + nameDB + "(" + arrF + ") VALUES (" + arrV + ");";
		return outLine;
	}
	
	public String exportLine (String line, String separator, String field, String sqlNameTable){//combo export line to insertString
		int out = 0;
		out = counterSeparator(line,separator);
		int [] arrp = arrPositionSep(line, separator, out);
		String[] arrF = arrField(line, field, out, arrp);
		String[] arrV = arrValue(line, field, out, arrp);
		return resultLine(sequenceField(arrF), sequenceValue(arrV) ,sqlNameTable);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String separator = "/";
		String field = "c";
		String sqlNameTable = "test";
		String fileName = "test.txt";
		
		File fileIn = new File("d:\\" + fileName);
		File fileOut = new File("d:\\" + fileName + ".sql");
		try {
			fileOut.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(fileIn));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
			String line;
			int i = 1;
			while ((line = reader.readLine()) != null) {
				String outer = new Main().exportLine(line, separator, field, sqlNameTable);
				writer.append(outer + "\n");
				System.out.println("Record:" + i);
				i++;
			}
			System.out.println("=====================");
			System.out.println("All records add: " + (i-1));
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}