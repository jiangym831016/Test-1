package com.newer.cjl.draw;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * ��ͼ�ļ�������ʵ�����������ӿ� ʵ�ֽӿھͱ���Ҫ���ӿ��еķ���ȫ����д
 * 
 * @author kowloon
 * 
 */
public class DrawListener implements MouseListener, MouseMotionListener {
	/** ��갴�º��ͷ�ʱ������� */
	private int x1, y1, x2, y2;
	private JPanel drawPanel;
	private ButtonGroup shapeGroup;
	private StatePanel statePanel;
	private Graphics g;
	private int type = 1;
	private JLabel frontLabel;
	private JLabel backLabel;
	
	private Color frontColor = Color.BLACK;//ǰ��ɫ
	private Color backColor = Color.RED;//����ɫ 
	
	
	URL url = DrawListener.class.getResource("images/cursorPen.gif");
	ImageIcon icon = new ImageIcon(url);
	Image img = icon.getImage();
	Point hotSpot = new Point(31, 31);
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	

	public DrawListener(JPanel dp, ButtonGroup bg1, StatePanel sp,JLabel fl,JLabel bl) {
		drawPanel = dp;
		shapeGroup = bg1;
		statePanel = sp;
		frontLabel = fl;
		backLabel = bl;
	}

	/** ��갴�µļ������� */
	public void mousePressed(MouseEvent e) {
		// ��갴��׼������ͼ��֮ǰ���Ȼ��������Ƶ�����Graphics
		g = drawPanel.getGraphics();
		
		//ȷ��ǰ��ɫ�ͱ���ɫ
		frontColor = frontLabel.getBackground();
		backColor = backLabel.getBackground();
		
		//��ð��µ���������������Ҽ�
		int button = e.getButton();
		//ȷ��Ҫ���Ƶ���ɫ
		if(button==MouseEvent.BUTTON1){//������µ������
			g.setColor(frontColor);
		}else if(button==MouseEvent.BUTTON3){
			g.setColor(backColor);
		}else{
			g.setColor(frontColor);
		}
		
		
		x1 = e.getX();
		y1 = e.getY();
	}

	/** ����ɿ��ļ������� */
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (type == 10) {
			g.drawLine(x1, y1, x2, y2);
		} else if (type == 12) {
			g.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, x1 < x2 ? x2 - x1
					: x1 - x2, y1 < y2 ? y2 - y1 : y1 - y2);
		} else if (type == 14) {
			g.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, x1 < x2 ? x2 - x1
					: x1 - x2, y1 < y2 ? y2 - y1 : y1 - y2);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// ��ñ�ѡ�еĵ�ѡ��ť
		ButtonModel bm = shapeGroup.getSelection();
		// ��ð�ť��Ψһ��ʶ
		String str = bm.getActionCommand();
		System.out.println("str:" + str);
		// ���������ַ���ת��int
		type = Integer.parseInt(str);

		// ������������򣬾͸���Ҫ���Ƶ���״�ı������״
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		if (type == 10) {
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		} else if (type == 6) {
			cursor = tk.createCustomCursor(img, hotSpot, "pen");
		}
		drawPanel.setCursor(cursor);

	}

	public void mouseExited(MouseEvent e) {
		statePanel.setMoveStr("");
		statePanel.setDragStr("");
		// ��statePanelִ��paint����
		statePanel.repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		String str = (x - x1) + "," + (y - y1);
		statePanel.setDragStr(str);
		statePanel.repaint();

	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		String str = x + "," + y;
		statePanel.setMoveStr(str);
		// ��statePanelִ��paint����
		statePanel.repaint();

	}
}
