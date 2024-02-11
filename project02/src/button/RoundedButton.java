package button;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton {

	public RoundedButton() { super(); decorate(); } 
	public RoundedButton(String text) { super(text); decorate(); } 
	public RoundedButton(Action action) { super(action); decorate(); } 
	public RoundedButton(Icon icon) { super(icon); decorate(); } 
	public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	protected void decorate() { setBorderPainted(false); setOpaque(false); }

	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					RoundedButton_RC rb = new RoundedButton_RC();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override 
	protected void paintComponent(Graphics g) {
		Color o = new Color(223, 233, 222); //���ڻ�
		Color c = new Color(130, 195, 235); //���� ����
		int width = getWidth(); 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON); 
		if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
		else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
		if (!getModel().isArmed()) { graphics.setColor(c); } 
		graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; 
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(o); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); 
		super.paintComponent(g); 
	}
}	
	