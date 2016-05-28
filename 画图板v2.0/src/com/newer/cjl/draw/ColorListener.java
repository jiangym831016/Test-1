package com.newer.cjl.draw;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * ��ɫѡ��ļ�����
 * 
 * @author kowloon
 * 
 */
public class ColorListener implements MouseListener {
	private JLabel frontLabel;
	private JLabel backLabel;

	public ColorListener(JLabel fl, JLabel bl) {
		frontLabel = fl;
		backLabel = bl;
	}

	public void mouseReleased(MouseEvent e) {
		// ��ñ�ѡ�пؼ��ı�����ɫ
		Object obj = e.getSource();
		if (obj instanceof JLabel) {
			JLabel label = (JLabel) obj;
			Color color = label.getBackground();

			int button = e.getButton();
			if (button == MouseEvent.BUTTON1) {
				frontLabel.setBackground(color);
			} else if (button == MouseEvent.BUTTON3) {
				backLabel.setBackground(color);
			}

		}

	}

	public void mouseEntered(MouseEvent e) {
		// ����¼�Դ����[�¼��Ƿ�������һ���ؼ��ϵģ�����ؼ������¼�Դ]
		// �������������ֻ�Ӹ���JLabel���������¼�Դ����һ����JLabel���͵�
		// ����һ������ǿ��ת��JLabel����
		// �������ȷ������ľ������ͣ�����Ҫ�ж϶��������
		Object obj = e.getSource();
		if (obj instanceof JLabel) {
			JLabel label = (JLabel) obj;
			label.setBorder(new LineBorder(Color.BLUE));
		}

	}

	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj instanceof JLabel) {
			JLabel label = (JLabel) obj;
			label.setBorder(new LineBorder(Color.LIGHT_GRAY));
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

}
