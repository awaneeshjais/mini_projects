import figure.*;
import helpclass.Str;

import java.util.Random;

public class Main {
    private static final int MAXCOUNTOFFIGURE = 30;
    public static int getCountFigure(){
        return MAXCOUNTOFFIGURE;
    }

    public static void main(String[] args) {

        int countfigure = new Random().nextInt(Main.getCountFigure());
        new Str().creater(countfigure);

        int c = 1;
        for (int i=0;i<countfigure;i++){
            int random = new Random().nextInt(4);
            System.out.print("Фигура " + c + " : ");
            if (random == 1){
                Square square = new Square();
                int squareSide = square.getSide();
                square.showFigure(square,random);
                square.showSquare(square,squareSide);
            }else if (random == 2){
                Trapeze trapeze = new Trapeze();
                int trapezeSide = trapeze.getSide();
                trapeze.showFigure(trapeze,random);
                trapeze.showTrapeze(trapeze,trapezeSide);
            }else if (random == 3){
                Triangle threeangle = new Triangle();
                int threeangleSide = threeangle.getSide();
                threeangle.showFigure(threeangle,random);
                threeangle.showThreeangle(threeangle,threeangleSide);
            }else {
                Circle circle = new Circle();
                int circleSide = circle.getSide();
                circle.showFigure(circle,random);
                circle.showCircle(circle,circleSide);
            }
            c++;
        }
    }
}
