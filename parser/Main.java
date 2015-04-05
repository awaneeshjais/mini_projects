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
		int[] arrpositionsep = new int[count];
		int i = 0;
		int s = 0;
		while (i<line.length()){
			if (separator.equals(line.substring(i,i+1))){
				arrpositionsep[s] = i;
				s++;
			}else{}
			i++;
		}
		return arrpositionsep;
	}
	
	public String[] arrField(String line, String field, int count, int [] arrpos){//create fields - 3 symbols after separator
		String[] arrfield = new String[count];
		for(int i = 0; i < count; i++){
			arrfield[i] = field + line.substring(arrpos[i]+1,arrpos[i]+4);
		}
		return arrfield;
	}
	
	public String[] arrValue(String line, String separator, int count, int []arrpos){//create value - from 4th symbols after separator to next separator
		String[] arrvalue = new String[count];
		for(int i = 0; i < arrvalue.length-1; i++){
			arrvalue[i] = line.substring(arrpos[i]+4,arrpos[i+1]);
		}
		arrvalue[count-1] = line.substring(arrpos[count-1]+4, line.length());
		return arrvalue;
	}
	
	public String sequenceField(String[] arrfield){//create string fields for insert
		String stringfield = "";
		for (int i = 0; i<arrfield.length;i++){
			stringfield = stringfield + arrfield[i] + ", ";
		}		
		stringfield = stringfield.substring(0,stringfield.length()-2);
		return stringfield;
	}
	
	public String sequenceValue(String[] arrvalue){//create string values for insert
		String stringvalue = "";
		for (int i = 0; i<arrvalue.length;i++){
			stringvalue = stringvalue + "'" + arrvalue[i] + "', ";
		}		
		stringvalue = stringvalue.substring(0,stringvalue.length()-2);
		return stringvalue;
	}
	
	public String resultLine (String arrf, String arrv, String nameDB){//create insert
		String outline = "";
		outline = "INSERT INTO " + nameDB + "(" + arrf + ") VALUES (" + arrv + ");";
		return outline;
	}
	
	public String exportLine (String line, String separator, String field, String sqlNameTable){//combo export line to insertString
		int out = 0;
		out = counterSeparator(line,separator);
		int [] arrp = arrPositionSep(line, separator, out);
		String[] arrf = arrField(line, field, out, arrp);
		String[] arrv = arrValue(line, field, out, arrp);
		return resultLine(sequenceField(arrf), sequenceValue(arrv) ,sqlNameTable);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String separator = "/";
		String field = "c";
		String sqlNameTable = "test";
		String filename = "test.txt";
		
		File fileIn = new File("d:\\" + filename);
		File fileOut = new File("d:\\" + filename + ".sql");
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