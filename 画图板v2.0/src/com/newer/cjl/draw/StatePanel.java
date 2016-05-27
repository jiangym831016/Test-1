package com.newer.cjl.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StatePanel extends JPanel{
	
	private String moveStr = "";
	private String dragStr = "";
	
	public void setMoveStr(String str){
		moveStr = str;
	}
	
	public void setDragStr(String str){
		dragStr = str;
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		//������Ĵ�С
		Dimension dim = getSize();
		int width = dim.width;
		int height = dim.height;
		
		//���Ʊ߿�
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(0, 0, width, height);
		
		//���Ʒָ���
		g.drawLine(width-200, 0, width-200, height);
		g.drawLine(width-100, 0, width-100, height);
		
		g.setColor(Color.BLACK);
		g.drawString("����ѧϰʹ��", 5, 15);

		g.drawString(moveStr, width-190, 15);
		g.drawString(dragStr, width-90, 15);
		
	}

}
