import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;

class Draw extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics graphics = (Graphics) g;
        int screensizewidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screensizeheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        graphics.drawString("ScreenSize : "
                + screensizewidth
                + " X "
                + screensizeheight, 30, 60);
        graphics.drawString("WindowSize : "
                + (getSize().width + 10)
                + " X "
                + (getSize().height + 32), 30, 80);

        int x_begin = 5;
        int y_begin = 5;
        // H O R I Z O N T A L
        for (int i=0;i<screensizewidth;i=i+5){//small line
            graphics.drawLine(x_begin + i, y_begin, x_begin + i, 10);
        }
        for (int i=50;i<=screensizewidth;i=i+100){//middle line
            graphics.drawLine(x_begin + i, y_begin, x_begin + i, 20);
        }
        for (int i=0;i<=screensizewidth;i=i+100){//big line
            graphics.drawLine(x_begin + i, y_begin, x_begin + i, 30);
        }
        int counteri = 100;
        for (int i=100;i<=screensizewidth;i=i+100){//big number
            graphics.drawString(String.valueOf((counteri)) + " px", x_begin + i, y_begin + 40);
            counteri = counteri + 100;
        }

        // V E R T I C A L
        for (int i=0;i<screensizeheight;i=i+5){//small line
            graphics.drawLine(x_begin, y_begin + i, 10, y_begin + i);
        }
        for (int i=50;i<=screensizeheight;i=i+100){//middle line
            graphics.drawLine(x_begin, y_begin + i, 20, y_begin + i);
        }
        for (int i=0;i<=screensizeheight;i=i+100){//big line
            graphics.drawLine(x_begin, y_begin + i, 30, y_begin + i);
        }
        int counterj = 100;
        for (int i=100;i<=screensizeheight;i=i+100){//big number
            graphics.drawString(String.valueOf((counterj)) + " px",x_begin + 30, y_begin + i + 5);
            counterj = counterj + 100;
        }
    }
}

public class Main extends JFrame {

    public static void createGUI(){
        JFrame frame = new JFrame("Ruler " + "\u00A9 j.optimusprime.2014@gmail.com 2014");
        JPanel panel = new JPanel();
        Point location = MouseInfo.getPointerInfo().getLocation();//MousePoint_X MousePoint_Y
        double x = location.getX();
        double y = location.getY();

        panel.setLayout(null);
        Draw draw = new Draw();
        panel.add(draw);
        frame.add(panel);
        frame.add(draw);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((int) x+20, (int)y+20);
        frame.setSize(400,132);
        frame.setResizable(true);
        frame.setVisible(true);

        AWTUtilities.setWindowOpacity(frame, 0.75f);
    }

    public static  void  main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main m= new Main();
                m.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}