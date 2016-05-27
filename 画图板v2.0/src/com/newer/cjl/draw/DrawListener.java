package com.newer.cjl.draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;

/**
 * ��ͼ�ļ�������ʵ�����������ӿ� ʵ�ֽӿھͱ���Ҫ���ӿ��еķ���ȫ����д
 * 
 * @author kowloon
 * 
 */
public class DrawListener implements MouseListener,MouseMotionListener {
	/** ��갴�º��ͷ�ʱ������� */
	private int x1, y1, x2, y2;
	private JPanel drawPanel;
	private ButtonGroup shapeGroup;
	private StatePanel statePanel;
	private Graphics g;
	private int type = 1;

	public DrawListener(JPanel dp, ButtonGroup bg1,StatePanel sp) {
		drawPanel = dp;
		shapeGroup = bg1;
		statePanel = sp;
	}

	/** ��갴�µļ������� */
	public void mousePressed(MouseEvent e) {
		// ��갴��׼������ͼ��֮ǰ���Ȼ��������Ƶ�����Graphics
		g = drawPanel.getGraphics();

		// ��ñ�ѡ�еĵ�ѡ��ť
		ButtonModel bm = shapeGroup.getSelection();
		// ��ð�ť��Ψһ��ʶ
		String str = bm.getActionCommand();
		System.out.println("str:" + str);
		// ���������ַ���ת��int
		type = Integer.parseInt(str);
		
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

	}

	public void mouseExited(MouseEvent e) {
		statePanel.setMoveStr("");
		//��statePanelִ��paint����
		statePanel.repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		String str = x+","+y;
		statePanel.setMoveStr(str);
		//��statePanelִ��paint����
		statePanel.repaint();
		
	}
}
