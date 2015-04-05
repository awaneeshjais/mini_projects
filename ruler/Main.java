import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;

class Draw extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics graphics = (Graphics) g;
        int screenSizeWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenSizeHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        graphics.drawString("ScreenSize : "
                + screenSizeWidth
                + " X "
                + screenSizeHeight, 30, 60);
        graphics.drawString("WindowSize : "
                + (getSize().width + 10)
                + " X "
                + (getSize().height + 32), 30, 80);

        int xBegin = 5;
        int yBegin = 5;
        // H O R I Z O N T A L
        for (int i=0;i<screenSizeWidth;i=i+5){//small line
            graphics.drawLine(xBegin + i, yBegin, xBegin + i, 10);
        }
        for (int i=50;i<=screenSizeWidth;i=i+100){//middle line
            graphics.drawLine(xBegin + i, yBegin, xBegin + i, 20);
        }
        for (int i=0;i<=screenSizeWidth;i=i+100){//big line
            graphics.drawLine(xBegin + i, yBegin, xBegin + i, 30);
        }
        int counteri = 100;
        for (int i=100;i<=screenSizeWidth;i=i+100){//big number
            graphics.drawString(String.valueOf((counteri)) + " px", xBegin + i, yBegin + 40);
            counteri = counteri + 100;
        }

        // V E R T I C A L
        for (int i=0;i<screenSizeHeight;i=i+5){//small line
            graphics.drawLine(xBegin, yBegin + i, 10, yBegin + i);
        }
        for (int i=50;i<=screenSizeHeight;i=i+100){//middle line
            graphics.drawLine(xBegin, yBegin + i, 20, yBegin + i);
        }
        for (int i=0;i<=screenSizeHeight;i=i+100){//big line
            graphics.drawLine(xBegin, yBegin + i, 30, yBegin + i);
        }
        int counterj = 100;
        for (int i=100;i<=screenSizeHeight;i=i+100){//big number
            graphics.drawString(String.valueOf((counterj)) + " px",xBegin + 30, yBegin + i + 5);
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