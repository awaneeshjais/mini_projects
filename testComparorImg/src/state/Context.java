package state;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Context {
	BufferedImage imageOne = null;
	BufferedImage imageTwo = null;
	File fileOne = null;
	File fileTwo = null;
	File fileOut = null;
	static final String ABSOLUTEPATH = new File("").getAbsolutePath().toString() + File.separator;
	static final String ALERT_NO_FILE = "Sorry but some files no in current directory!";
	static final String ALERT_SOME_GO = "Sorry but something going NON correct!";
	static final String ALERT_ALL_GOOD = "Process complete!";
	int[][] redOne,greenOne,blueOne,redTwo,greenTwo,blueTwo,resultCompare;
	HashMap<String,Integer> rectangleXY = new HashMap<String,Integer>();
	
	
	
	public BufferedImage getImageOne() {
		return imageOne;
	}

	public void setImageOne(File file) {
		try {
			this.imageOne = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImageTwo() {
		return imageTwo;
	}

	public void setImageTwo(File file) {
		try {
			this.imageTwo = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getAbsolutepath() {
		return ABSOLUTEPATH;
	}
	
	public String getAlertAllGood() {
		return ALERT_ALL_GOOD;
	}
	
	public String getAlertNoFile(){
		return ALERT_NO_FILE;
	}
	
	public String getAlertSomeGo(){
		return ALERT_SOME_GO;
	}
	
	public File getFileOne() {
		return fileOne;
	}

	public void setFileOne(String str) {
		this.fileOne = new File(str);
	}

	public File getFileTwo() {
		return fileTwo;
	}

	public void setFileTwo(String str) {
		this.fileTwo = new File(str);
	}

	public File getFileOut() {
		return fileOut;
	}

	public void setFileOut(String str) {
		this.fileOut = new File(str);
	}

	

	
	public int[][] getRedOne() {
		return redOne;
	}
	
public void setRedOne(int[][] redOne) {
		this.redOne = redOne;
	}

	public int[][] getGreenOne() {
		return greenOne;
	}

	public void setGreenOne(int[][] greenOne) {
		this.greenOne = greenOne;
	}

	public int[][] getBlueOne() {
		return blueOne;
	}

	public void setBlueOne(int[][] blueOne) {
		this.blueOne = blueOne;
	}

	public int[][] getRedTwo() {
		return redTwo;
	}

	public void setRedTwo(int[][] redTwo) {
		this.redTwo = redTwo;
	}

	public int[][] getGreenTwo() {
		return greenTwo;
	}

	public void setGreenTwo(int[][] greenTwo) {
		this.greenTwo = greenTwo;
	}

	public int[][] getBlueTwo() {
		return blueTwo;
	}

	public void setBlueTwo(int[][] blueTwo) {
		this.blueTwo = blueTwo;
	}

	public int[][] getResultCompare() {
		return resultCompare;
	}

	public void setResultCompare(int[][] resultCompare) {
		this.resultCompare = resultCompare;
	}

	public HashMap<String, Integer> getRectangleXY() {
		return rectangleXY;
	}

	public void setRectangleXY(HashMap<String, Integer> rectangleXY) {
		this.rectangleXY = rectangleXY;
	}
	
	public int getElementOfArray(int[][] arr, int i,int j){
		return arr[i][j];
	}
}