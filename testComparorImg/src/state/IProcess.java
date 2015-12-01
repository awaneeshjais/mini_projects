package state;

import java.awt.image.BufferedImage;

public interface IProcess { 
	public int[][] getColor(BufferedImage bufferedImage, String symbol);
	public void executeColor (Context context, BufferedImage bufferedImageOne, BufferedImage bufferedImageTwo);
	public int[][] getCompareColor(BufferedImage bufferedImage, int[][]first, int[][] second);
	public void compareColor(Context context, BufferedImage bufferedImageOne, BufferedImage bufferedImageTwo);
	public void analysisOfPolygone(Context context, BufferedImage bufferedImage);
	public void computeRectangle(Context context,int x1,int y1,int y2,int x3);
	public void drawArea(Context context, BufferedImage bufferedImage, String name, int x1, int y1, int width, int height);
	public void printColor(BufferedImage bufferedImage, int[][] color);
}