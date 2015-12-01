package state;

public class Main { 
	   public static void main(String[] args) {
			String fileNameOne = args[0];
			String fileNameTwo = args[1];
			String fileNameOut = args[2];//*/
			/*String fileNameOne = "p1.png";
			String fileNameTwo = "p2.png";
			String fileNameOut = "p_out.png";*/
		   
			Context context = new Context();
			context.setFileOne(context.getAbsolutepath() + fileNameOne);
			context.setFileTwo(context.getAbsolutepath() + fileNameTwo);
			context.setFileOut(context.getAbsolutepath() + fileNameOut);
			Processing process = new Processing();

			if (context.getFileOne().exists()&&context.getFileTwo().exists()){
				try {
					context.setImageOne(context.getFileOne());
					context.setImageTwo(context.getFileTwo());
					process.executeColor(context, context.getImageOne(), context.getImageTwo());
					process.compareColor(context, context.getImageOne(), context.getImageTwo());
					process.analysisOfPolygone(context, context.getImageOne());
					process.computeRectangle(context, context.getRectangleXY().get("x1"), 
													  context.getRectangleXY().get("y1"), 
													  context.getRectangleXY().get("y2"), 
													  context.getRectangleXY().get("x3"));
					
					process.drawArea(context, context.getImageTwo(), 
											  context.getFileOut().toString(),
											  context.getRectangleXY().get("y1"),
											  context.getRectangleXY().get("x1"),
											  context.getRectangleXY().get("w"),
											  context.getRectangleXY().get("h"));
					System.out.println(context.getAlertAllGood());
				} catch (Exception e) {
					System.out.println(e);
				}			
			}else{
				System.out.println(context.getAlertNoFile());
			}
	   } 
}