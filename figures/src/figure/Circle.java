package figure;

import helpclass.Figure;
import helpclass.Numbers;

public class Circle extends Figure {
    public String getArea(int side){
        double area = (Math.PI * side * side);
        return String.valueOf(new Numbers().rounder(area, 2));
    }
    public int getDiametr(int side){
        return side + side;
    }
    public void showCircle(Circle c,int r){
        System.out.print(
                " Доп_елементы: "
                + "радиус-" + r
                + " ед., площадь-" + c.getArea(r)
                + " кв.ед., диаметр-" + c.getDiametr(r)
                + " ед.!\n"
        );
    }
}
