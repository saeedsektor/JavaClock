import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.time.LocalDateTime;

public class Clock
{
    public static final double PI = 3.14;
    private Point2D centre;
    private double radius;
    /**
     Constructs a Circle.
     */
    public Clock()
    {
        centre = new Point2D();
        radius=1;

    }
    /**
     Constructs a Circle and initialize
     @param x coordinate of the centre
     @param y coordinate of the centre
     @param r radius of the cirlce
     */
    public Clock(double x, double y, double r)
    {
        centre = new Point2D(x,y);
        radius = r;
    }


    /**
     funtion to draw the handle
     it needs the canvas, the time, the length of the handle and the color in rgb
     */

    private void drawHandles(Graphics2D g2,int pointer, int length,int r, int g, int b, int stroke){
        int cx = (int) centre.getX();
        int cy = (int) centre.getY();;
        double angle = (pointer-15)*2*Math.PI/60;
        double x2 = cx +  length * Math.cos(angle);
        double y2 = cy +  length * Math.sin(angle);

        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(new Color(r,g,b));
        Line2D.Double h= new Line2D.Double( cx, cy, x2, y2);
        g2.draw(h);
    }

    /**
     funtion to draw the details of the clock based on 400x400 Frame
     */
    private void drawDetails(Graphics2D g2){

        int rad;
        g2.setColor(Color.gray);
        for(int i = 0; i <= 60; i++){
            int a1,a2,a3,a4;
            rad = 240;
            a1 = (int) (185+Math.sin(i/60.0*Math.PI*2)* rad/2);
            a2 = (int) (185+Math.cos(i/60.0*Math.PI*2)* rad/2);
            rad = 242;
            a3 = (int) (185+Math.sin(i/60.0*Math.PI*2)* rad/2);
            a4 = (int) (185+Math.cos(i/60.0*Math.PI*2)* rad/2);
            g2.drawLine(a1,a2,a3,a4);
            if(i%5 == 0){
                g2.setColor(Color.black);
                rad = 220;
                a3 = (int) (185+Math.sin(i/60.0*Math.PI*2)* rad/2);
                a4 = (int) (185+Math.cos(i/60.0*Math.PI*2)* rad/2);
                g2.drawLine(a1,a2,a3,a4);

            }
        }

    }

    /**
     draw clock using Graphics2D g2
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double c= new Ellipse2D.Double(centre.getX()-radius,centre.getY()-radius,2*radius,2*radius);
        g2.setStroke(new BasicStroke(8));
        g2.draw(c);

        LocalDateTime now = LocalDateTime.now();
        int hours = now.getHour()*5;
        int minute = now.getMinute();
        int seconds = now.getSecond();

        drawHandles(g2, seconds,105,224,52,52,2);
        drawHandles(g2, hours,50,74,74,74,5);
        drawHandles(g2, minute,85,74,74,74,3);

        g2.setStroke(new BasicStroke(1));
        Ellipse2D.Double e = new Ellipse2D.Double(centre.getX()-5,centre.getY()-5,7,7);
        g2.draw(e);
        g2.setColor(Color.red);
        g2.fill(e);

        drawDetails(g2);

        g2.setColor(Color.black);
        g2.drawString("SKDEV",(int)centre.getX()-20, (int)centre.getY()-70);


    }
}

