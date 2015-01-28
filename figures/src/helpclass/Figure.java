package helpclass;

import java.util.Random;

public class Figure {
    String[] arraycolor = {"красный","оранжевый","желтый","зеленый","голубой","синий","фиолетовый"};
    String[] arrayname = {"круг","квадрат","трапеция","треугольник"};

    public String getName(int i){
        if (i<4) {
            return arrayname[i];
        }else{
            return "неизвесная фигура";
        }
    }
    public String getColor(){
        return arraycolor[new Random().nextInt(7)];
    }

    public int getSide(){
        int side = 0;
        while(side==0){
        side = new Random().nextInt(20);
        }
        return side;
    }
    public String draw(){
        return "нарисовано!)";
    }
    public void showFigure(Figure f, int rand){
        System.out.print(
                f.getName(rand)
                + ", цвет-" + f.getColor()
                + ", нарисовать-" + f.draw()
                + ".");
    }
}
