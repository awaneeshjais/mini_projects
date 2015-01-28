package helpclass;

public class Str {
    public void creater(int c){
        if (c==0){
            System.out.println("Не создано ни одной фигуры.");
        }else if (c==1){
            System.out.println("Создана 1 фигура.");
        }else if (c>1&&c<5){
            System.out.println("Создано " + c + " фигуры.");
        }else {
            System.out.println("Создано " + c + " фигур.");
        }
    }
}
