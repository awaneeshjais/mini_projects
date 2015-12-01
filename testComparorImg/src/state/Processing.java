package state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Processing implements IProcess {
	//Context context;
	 
	@Override
	public int[][] getColor(BufferedImage bufferedImage, String symbol) {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		int[][] arr = new int[height][width];
		switch (symbol) {
			case "R":
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						arr[i][j] = new Color(bufferedImage.getRGB(j,i)).getRed();
					}
				}
				break;
			case "G":
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						arr[i][j] = new Color(bufferedImage.getRGB(j,i)).getGreen();
					}
				}
				break;
			case "B":
				for(int i=0;i<height;i++){
					for(int j=0;j<width;j++){
						arr[i][j] = new Color(bufferedImage.getRGB(j,i)).getBlue();
					}
				}
				break;
			default:
				break;
		}
		return arr;	
	}

	public void executeColor(Context context, BufferedImage bufferedImageOne, BufferedImage bufferedImageTwo) {
		context.setRedOne(getColor(bufferedImageOne, "R"));
		context.setGreenOne(getColor(bufferedImageOne, "G"));
		context.setBlueOne(getColor(bufferedImageOne, "B"));
		
		context.setRedTwo(getColor(bufferedImageTwo, "R"));
		context.setGreenTwo(getColor(bufferedImageTwo, "G"));
		context.setBlueTwo(getColor(bufferedImageTwo, "B"));
	}

	@Override
	public int[][] getCompareColor(BufferedImage bufferedImage, int[][] first, int[][] second) {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		int[][]result = new int[height][width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				int comparor;
				if (first[i][j] == 0){
					comparor = second[i][j];
				}else{
					comparor = (Math.abs(second[i][j]-first[i][j])*100/first[i][j]);
				}
				
				if (comparor<10)
					result[i][j] = 0;
				else
					result[i][j] = 1;
			}
		}
		return result;
	}

	@Override
	public void compareColor(Context context, BufferedImage bufferedImageOne, BufferedImage bufferedImageTwo) {
		context.setResultCompare(getCompareColor(bufferedImageOne, context.getRedOne(),context.getRedTwo()));
		context.setResultCompare(getCompareColor(bufferedImageOne, context.getGreenOne(),context.getGreenTwo()));
		context.setResultCompare(getCompareColor(bufferedImageOne, context.getBlueOne(),context.getBlueTwo()));
		
	}

	@Override
	public void analysisOfPolygone(Context context, BufferedImage bufferedImage) {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if (context.getRectangleXY().containsKey("x1") && context.getRectangleXY().containsKey("y1")){
				}else{
					if (context.getElementOfArray(context.getResultCompare(), i, j)==1 &&
						context.getElementOfArray(context.getResultCompare(), i-1, j)==0 &&
						context.getElementOfArray(context.getResultCompare(), i, j-1)==0){
						context.getRectangleXY().put("x1", i);
						context.getRectangleXY().put("y1", j);
					}
				}
					if (context.getElementOfArray(context.getResultCompare(), i, j)==1 &&
						context.getElementOfArray(context.getResultCompare(), i-1, j)==0 &&
						context.getElementOfArray(context.getResultCompare(), i, j+1)==0){
						context.getRectangleXY().put("x2", i);
						context.getRectangleXY().put("y2", j);
					}
					if (context.getElementOfArray(context.getResultCompare(), i, j)==1 &&
						context.getElementOfArray(context.getResultCompare(), i+1, j)==0 &&
						context.getElementOfArray(context.getResultCompare(), i, j-1)==0){
						context.getRectangleXY().put("x3", i);
						context.getRectangleXY().put("y3", j);
					}
			}
		}
		
	}

	@Override
	public void computeRectangle(Context context, int x1, int y1, int y2, int x3) {
		context.getRectangleXY().put("w", (y2 - y1));
		context.getRectangleXY().put("h", (x3 - x1));
		
	}

	@Override
	public void drawArea(Context context, BufferedImage bufferedImage, String name, int x1, int y1, int width, int height) {
		Graphics2D g2d = bufferedImage.createGraphics();
		   g2d.setColor(Color.red);
		   g2d.drawRect(x1, y1, width, height); //drawLine(x1, y1, x2, y2);
		   g2d.dispose();
		   try {
			   ImageIO.write(bufferedImage, "PNG", new File(name));
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
	}

	@Override
	public void printColor(BufferedImage bufferedImage, int[][] color) {
		// TODO Auto-generated method stub
		
	} 
}