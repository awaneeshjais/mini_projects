package figure;

import helpclass.Figure;

public class Square extends Figure {

    public int getArea(int side){
        return side * side;
    }
    public int getPerimetr(int side){
        return side * 4;
    }
    public void showSquare(Square sq,int s){
        System.out.print(
                        " Доп_елементы: "
                        + "ребро-" + s
                        + " ед., площадь-" + sq.getArea(s)
                        + " кв.ед., периметр-" + sq.getPerimetr(s)
                        + " ед.!\n");
    }
}
