package com.newer.cjl.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

/**
 * ��ͼ����������
 * 
 * @author kowloon
 * 
 */
public class DrawUI {

	/**
	 * ��ʼ�������ڵķ���
	 */
	public void initDrawUI() {
		// �������ڶ���
		JFrame jf = new JFrame();
		jf.setTitle("��ͼ��");
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(3);

		//���ô��ڵĲ��ֹ���Ϊ��ʽ�߿򲼾�
		BorderLayout border = new BorderLayout();
		jf.setLayout(border);
		
		//**********************������Ҫ���*******************************//
		//��������������
		JPanel left = new JPanel();
		JPanel center = new JPanel();
		JPanel foot = new JPanel();
		
		//������ɫ����
		Color c = new Color(240,240,240);
		
		//��������С�ͱ���ɫ
		Dimension leftDim = new Dimension(80,1);
		left.setPreferredSize(leftDim);
		left.setBackground(c);
		//����ߵ�������ñ߿�
		LineBorder line = new LineBorder(Color.GRAY);
		left.setBorder(line);
		
		center.setBackground(Color.GRAY);
		
		Dimension footDim = new Dimension(1,80);
		foot.setPreferredSize(footDim);
		foot.setBackground(c);
		
		jf.add(left,BorderLayout.WEST);
		jf.add(center,BorderLayout.CENTER);
		jf.add(foot,BorderLayout.SOUTH);
		

		//********************��ͼ���*********************************//
		
		//����һ��������ͼ�����
		JPanel drawPanel = new JPanel();
		Dimension drawPanelDim = new Dimension(400,300);
		drawPanel.setPreferredSize(drawPanelDim);
		drawPanel.setBackground(Color.WHITE);
		
		//ָ��center���Ĳ���Ϊ��ʽ���������
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		center.setLayout(flow);
		
		//����ͼ���ӵ��м������
		center.add(drawPanel);
		
		//*****************������״ѡ�����************************************//
		//������״��ť��
		ButtonGroup shapeGroup = new ButtonGroup();
		String[] shapes = {"ֱ��","����","��Բ"};
		for(int i=0;i<shapes.length;i++){
			//������ѡ��ť
			JRadioButton btn = new JRadioButton(shapes[i]);
			//���õ�������[Ψһ��ʶ]
			btn.setActionCommand(i+"");
			//��ӵ�����
			shapeGroup.add(btn);
			//��ӵ�������
			left.add(btn);
			if(i==0){//Ĭ��ѡ�е�һ����ť
				btn.setSelected(true);
			}
		}
		
		
		
		jf.setVisible(true);
		
		//��������������
		DrawListener dlis = new DrawListener(drawPanel,shapeGroup);
		//��drawPanel�����������
		drawPanel.addMouseListener(dlis);
	}
}
