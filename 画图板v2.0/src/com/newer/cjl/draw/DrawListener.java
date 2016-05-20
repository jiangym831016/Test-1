package com.newer.cjl.draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;

/**
 * ��ͼ�ļ�������ʵ�����������ӿ� ʵ�ֽӿھͱ���Ҫ���ӿ��еķ���ȫ����д
 * 
 * @author kowloon
 * 
 */
public class DrawListener implements MouseListener {
	/** ��갴�º��ͷ�ʱ������� */
	private int x1, y1, x2, y2;
	private JPanel drawPanel;
	private ButtonGroup shapeGroup;
	private Graphics g;
	private int type = 1;// 0��ʾֱ�� 1��ʾ���� 2��ʾ��Բ

	public DrawListener(JPanel dp, ButtonGroup bg1) {
		drawPanel = dp;
		shapeGroup = bg1;
	}

	/** ��갴�µļ������� */
	public void mousePressed(MouseEvent e) {
		// ��갴��׼������ͼ��֮ǰ���Ȼ��������Ƶ�����Graphics
		g = drawPanel.getGraphics();

		// ��ñ�ѡ�еĵ�ѡ��ť
		ButtonModel bm = shapeGroup.getSelection();
		// ��ð�ť��Ψһ��ʶ
		String str = bm.getActionCommand();
		//���ݶ�����������Ҫ���Ƶ���״
		if (str.equals("0")) {
			type = 0;
		} else if (str.equals("1")) {
			type = 1;
		} else if (str.equals("2")) {
			type = 2;
		}

		x1 = e.getX();
		y1 = e.getY();
	}

	/** ����ɿ��ļ������� */
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (type == 0) {
			g.drawLine(x1, y1, x2, y2);
		} else if (type == 1) {
			g.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, x1 < x2 ? x2 - x1
					: x1 - x2, y1 < y2 ? y2 - y1 : y1 - y2);
		} else if (type == 2) {
			g.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, x1 < x2 ? x2 - x1
					: x1 - x2, y1 < y2 ? y2 - y1 : y1 - y2);
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}
}
