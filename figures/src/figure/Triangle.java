package figure;

import helpclass.Figure;
import helpclass.Numbers;

public class Triangle extends Figure {

    public String getArea(int side){
        double area = ((new Numbers().coren(3) * side * side)/4);
        return String.valueOf(new Numbers().rounder(area,2));
    }
    public int getPerimetr(int side){
        return side * 3;
    }
    public String getMediana(int side){
        double gipo = ((new Numbers().coren(3) * side)/2);
        return String.valueOf(new Numbers().rounder(gipo, 2));
    }
    public void showThreeangle(Triangle t,int s){
        System.out.print(
                " Доп_елементы: "
                + "сторона-" + s
                + " ед., площадь-" + t.getArea(s)
                + " кв.ед., периметр-" + t.getPerimetr(s)
                + " ед., медиана-" + t.getMediana(s)
                + " ед.!\n");
    }
}
