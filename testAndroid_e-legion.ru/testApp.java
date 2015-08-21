import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
* Created by Pomaz Vitaliy
* j.optimusprime.2014@gmail.com
* 21.08.2015
*/

public class testApp {

	public static boolean checkFormatString(String str){
		Pattern p = Pattern.compile("^[+-]?\\d+ [+-]?\\d+ [+-]?\\d+ [+-]?\\d+\\s?$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static int[] parseStringToArray(String str){
		String[] stringToArray = str.split(" ");
		int[] stringArrayToInteger = new int[stringToArray.length];
		for (int i = 0; i < stringToArray.length; i++){
			stringArrayToInteger[i] = Integer.parseInt(stringToArray[i]);
		}
		return stringArrayToInteger;
	}

	public static boolean logicIntegrityFigure(int[] array){
		return ((array[0] == array[2])||(array[1] == array[3])) ? true : false;
	}

	public static int minimumX(int[] array){
		return (array[0] < array[2]) ? array[0] : array[2];
	}

	public static int minimumY(int[] array){
		return (array[1] < array[3]) ? array[1] : array[3];
	}

	public static int maximumX(int[] array){
		return (array[0] > array[2]) ? array[0] : array[2];
	}

	public static int maximumY(int[] array){
		return (array[1] > array[3]) ? array[1] : array[3];
	}

	public static void addCoordinatesDotToHashSet(double x, double y , HashSet<String> hs){
		String coordinates = "{ " +  x + " ; " + y + " }";
		if (!hs.contains(coordinates)){
			hs.add(coordinates);
		}
	}

	public static void main(String arg[]){
		HashSet<String> hashSet = new HashSet<String>();

		String fileNameInput = arg[0];
		String fileNameOutput = arg[1];
		//String fileNameInput = "input.txt";
		//String fileNameOutput = "output.txt";
		String absolutePath = null;
		boolean checkIn = true;

		File path = new File("..");

		absolutePath = path.getAbsolutePath().substring(0, path.getAbsolutePath().length()-2);

		File fileIn = new File(absolutePath + fileNameInput);
		File fileOut = new File(absolutePath + fileNameOutput);

		System.out.println("INPUT:");
		try {
			if (fileIn.exists()){
				BufferedReader reader = new BufferedReader(new FileReader(fileIn));
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (checkFormatString(line)){
						int[] temp = parseStringToArray(line);
						if (!logicIntegrityFigure(temp)){
							System.out.println(line);
							for (double y = minimumY(temp) + 0.5; y < maximumY(temp); y++ ){
								for (double x = minimumX(temp) + 0.5; x < maximumX(temp); x++){
									addCoordinatesDotToHashSet(x, y, hashSet);
								}
							}
						}else{
							System.out.println("ERROR: [ some figure degenerate in line or dot ]");
							checkIn = false;
							break;
						}
						if (!fileOut.exists()){
							fileOut.createNewFile();
						}
					}else{
						System.out.println("ERROR: [ not correct data ]");
						checkIn = false;
						break;
					}
				}
				if (checkIn){
					if (!fileOut.exists()){
						fileOut.createNewFile();
					}
					BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
					writer.append(hashSet.size() + "\n");
					writer.close();
					System.out.println();
					System.out.println("OUTPUT:");
					System.out.println(hashSet.size());	
				}
				reader.close();
			}else {
				System.out.println("ERROR: [ no search file ] -> " + fileNameInput.toString());
			}
		} catch (Exception e) {
			System.out.println("ERROR: [ some thing wronge ]");
		}
	}
}