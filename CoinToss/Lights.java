import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
class Lights extends Thread implements ActionListener
{
	JFrame grp;
	JPanel lp,mp;
	JLabel lb,h,t;
	JButton c,re;
    Random r;
    ImageIcon icon1 = new ImageIcon("C:/Users/user/Desktop/myCodes/Java/Tails.webp");
	ImageIcon icon2 = new ImageIcon("C:/Users/user/Desktop/myCodes/Java/Heads.webp");
	int hc=0,tc=0;
	Lights()
	{
		grp = new JFrame("Coin Toss App");
		lb = new JLabel(icon1);
		h = new JLabel("Heads = 0");
		h.setBounds(5,5,50,50);
		t = new JLabel("Tails = 0");
		lb.setSize(50,50);
		mp = new JPanel(true);
		lp = new JPanel(true);
		grp.setVisible(true);
		grp.setSize(500,500);
		grp.setLayout(new GridLayout(2,1));
		lp.setSize(300,300);
		mp.setSize(200,200);
		mp.setLayout(new BorderLayout());
		lp.setLayout(new GridLayout(2,1));
        lp.setBackground(Color.black);
        mp.setBackground(Color.black);
        lb.setForeground(Color.white);
        lb.setBackground(Color.white);
		re = new JButton("RESET");
		c = new JButton("FLIP COIN");
		lb.setFont(new Font("Arial", Font.BOLD, 50));
		h.setFont(new Font("Arial", Font.BOLD, 45));
		t.setFont(new Font("Arial", Font.BOLD, 45));
		c.setFont(new Font("Arial", Font.BOLD, 30));
		re.setFont(new Font("Arial", Font.BOLD, 30));
		h.setForeground(Color.white);
		t.setForeground(Color.white);
		c.setForeground(Color.black);
        c.setBackground(Color.white);
		re.setForeground(Color.black);
        re.setBackground(Color.white);
		mp.add(lb,BorderLayout.CENTER);
		lp.add(h);
		lp.add(t);
		lp.add(c);
		lp.add(re);
		grp.add(mp);
		grp.add(lp);
		re.addActionListener(this);
		c.addActionListener(this);	
		grp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		r = new Random();
		if(ae.getSource() == c)
		{
			int i = r.nextInt(100);
			if (i%2 == 0)
			{
				lb.setIcon(icon2);
				hc++;
			}
			else
			{
				lb.setIcon(icon1);
				tc++;
			}
			h.setText("Heads = "+hc);
			t.setText("Tails = "+tc);
		}
		if(ae.getSource() == re)
		{
			hc=0;
			tc=0;
			h.setText("Heads = 0");
			t.setText("Tails = 0");
			lb.setIcon(null);
		}
	}
	public static void main(String args[])
	{
		new Lights();
	}
}