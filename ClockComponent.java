import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/**
 A component that draws two rectangles.
 */
public class ClockComponent extends JComponent
{
    Clock newClock;
    private Timer t;
    public ClockComponent()
    {
        newClock = new Clock(185,185, 130);
        startTimer();

    }
    private void startTimer()
    {
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                repaint();
            }
        }

        t = new Timer(1000 /* 1000 milliSecond*/, new TimerListener());
        t.start();
    }
    public void paintComponent(Graphics g)
    {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(new Color(230,230,230));
        g2.clearRect(0,0,getWidth(),getHeight());

        // draw Clock
        g2.setColor(Color.lightGray);
        g2.setStroke(new BasicStroke(1));
        newClock.draw(g2);



    }

}
