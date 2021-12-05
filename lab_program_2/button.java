import java.awt.*;
import java.awt.event.*;
public class button extends Panel implements ActionListener
{
	int count;
	Button but;
	public button()
	{
		count=0;
		setSize(200,100);
		but=new Button("click me");
		but.addActionListener(this);
		add(but);
	}
	public void actionPerformed(ActionEvent e)
	{
		count++;
		System.out.println("click count="+count);
		repaint();
	}
	public void paint(Graphics g)
	{
		Dimension d=getSize();
		Font f=new Font("Courier",Font.BOLD+Font.ITALIC,24);
		int h=d.height;
		int w=d.width;
		g.setColor(Color.pink);
		g.fillRect(0,0,w-1,h-1);
		g.setFont(f);
		g.setColor(new Color(0,0,0));
		g.drawString("Click count="+count,50,50);
	}
}
