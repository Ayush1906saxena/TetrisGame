import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class InstructionPanel extends JPanel
{
  public InstructionPanel()
  {
	setBackground(Color.black);
	setLayout(new BorderLayout());
	JLabel msg=new JLabel("<html><table border='1' style='color:white;font-size:16'><tr><th colspan='2'>Keys Role<th></tr><tr><td>Move Left</td><td style='color:blue'>Left Arrow</td></tr><tr><td>Move Right</td><td  style='color:blue'>Right Arrow</td></tr><tr><td>Rotate</td><td style='color:blue'>Up Arrow</td></tr><tr><td>Move Down</td><td style='color:blue'>Down Arrow</td></tr><tr><td>Exit</td><td style='color:blue'>Escape</td></tr></table><html>");add(msg,"Center");
	JPanel btpa=new JPanel();
	add(btpa,"South");
	btpa.setLayout(new GridLayout());
	Font fo=new Font("arial",1,18);
	Color [] col={new Color(0,100,0),Color.red};
	PlayListener listener=new PlayListener();
	TetrisListener list=new TetrisListener();
	Insets margin=new Insets(0,0,0,0);
	for(int i=0;i<2;i++)
	{
	  Va.bt[i].setFont(fo);
	  Va.bt[i].setForeground(col[i]);
	  Va.bt[i].addActionListener(listener);
	  Va.bt[i].setMargin(margin);
	  Va.bt[i].addKeyListener(list);
	  btpa.add(Va.bt[i]);
	}
	Va.bt[1].setEnabled(false);
   }
  
}