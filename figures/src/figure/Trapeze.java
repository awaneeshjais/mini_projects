package figure;

import helpclass.Figure;
import helpclass.Numbers;

import java.util.Random;

public class Trapeze extends Figure{
    public int getTopSide(){
        int topside = 0;
        while(topside==0){
            topside = new Random().nextInt(20);
        }
        return topside;
    }
    public int getFootSide(){
        int footside = 0;
        while(footside==0){
            footside = new Random().nextInt(20);
        }
        return footside;
    }
    public String getArea(int side, int top, int footer){
        double s;
        if (top==footer){
            s= side * top;
        }else {
            s = ((top + footer) / 2) * new Numbers().coren(Math.abs((side * side) - (Math.abs((top - footer) * (top - footer)) / 4)));
        }
        return String.valueOf(new Numbers().rounder(s,2));
    }
    public String getDiagonal(int side, int top, int footer){
        double dia = new Numbers().coren((side*side) + (top*footer));
        return String.valueOf(new Numbers().rounder(dia,2));
    }
    public int getPerimetr(int side,int top, int footer){
        return side + side + top + footer;
    }
    public void showTrapeze(Trapeze t,int s){
        int trapezeTop = t.getTopSide();
        int trapezeFoot = t.getFootSide();
        System.out.print(
                        " Доп_елементы: "
                        + "ребро-" + s
                        + " ед., верхняя основа-" + trapezeTop
                        + " ед., нижняя основа-" + trapezeFoot
                        + " ед., площадь-" + t.getArea(s,trapezeTop,trapezeFoot)
                        + " кв.ед., периметр-" + t.getPerimetr(s, trapezeTop,trapezeFoot)
                        + " ед., диагональ-" + t.getDiagonal(s,trapezeTop,trapezeFoot)
                        + " ед.!\n");
    }
}
