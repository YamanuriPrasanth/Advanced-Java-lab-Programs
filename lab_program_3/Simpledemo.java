import java.awt.*;
public class Simpledemo extends Canvas
{
    private boolean filled;
    public Simpledemo()
    {
        filled=false;
        setSize(500,500);
        
    }
    public boolean isfilled()
    {
        return filled;
    }
    public void setFilled(boolean flag)
    {
        this.filled=flag;
        repaint();
    }
    public void paint(Graphics g)
    {
        Dimension dimension=getSize();
        int height=dimension.height;
        int width=dimension.width;
        g.setColor(Color.blue);
        if(filled)
        {
            g.fillRect(0,0,--width,--height);
        }
        else
        {
            g.drawRect(0,0,--width,--height);
        }
    }
}