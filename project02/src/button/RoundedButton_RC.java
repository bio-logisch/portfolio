package button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton_RC extends JButton {

	public RoundedButton_RC() { super(); decorate(); } 
	public RoundedButton_RC(String text) { super(text); decorate(); } 
	public RoundedButton_RC(Action action) { super(action); decorate(); } 
	public RoundedButton_RC(Icon icon) { super(icon); decorate(); } 
	public RoundedButton_RC(String text, Icon icon) { super(text, icon); decorate(); } 
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
		Color o = new Color(46, 188, 108); //글자색
		Color c = randomColor(); //배경색 결정
		int width = getWidth(); 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON); 
//		if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
//		else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
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
	
	public Color randomColor() {
		Map<Integer, Color> map = new HashMap<Integer, Color>();
		map.put(1,(new Color(241, 124, 120)));
		map.put(2,(new Color(241, 188, 120)));
		map.put(3,(new Color(241, 238, 120)));
		map.put(4,(new Color(204, 240, 130)));
		map.put(5,(new Color(161, 237, 241)));
		map.put(6,(new Color(173, 194, 240)));
		map.put(7,(new Color(209, 189, 246)));

		Random r = new Random();
		for(int i=0; i<1; i++){
			int a = r.nextInt(map.size());
			Color randC = map.get(a); 
			return randC;
		}
		return null;	
	}
}
