package com.newer.cjl.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		//��������С�ͱ���ɫ
		Dimension leftDim = new Dimension(80,1);
		left.setPreferredSize(leftDim);
		left.setBackground(new Color(220,220,220));
		//����ߵ�������ñ߿�
		LineBorder line = new LineBorder(Color.GRAY);
		left.setBorder(line);
		
		center.setBackground(Color.GRAY);
		
		Dimension footDim = new Dimension(1,80);
		foot.setPreferredSize(footDim);
		foot.setBackground(new Color(220,220,220));
		
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
		
		//*****************�����״ѡ�����************************************//
		//������״��ť��
		ButtonGroup shapeGroup = new ButtonGroup();
		for(int i=0;i<16;i++){
			//������ѡ��ť
			JRadioButton btn = new JRadioButton();
			//���õ�������[Ψһ��ʶ]
			btn.setActionCommand(i+"");
			//��ӵ�����
			shapeGroup.add(btn);
			
			URL imgUrl = DrawUI.class.getResource("images/draw"+i+".jpg");
			ImageIcon icon = new ImageIcon(imgUrl);
			
			URL imgUrl1 = DrawUI.class.getResource("images/draw"+i+"-1.jpg");
			ImageIcon icon1 = new ImageIcon(imgUrl1);
			
			URL imgUrl2 = DrawUI.class.getResource("images/draw"+i+"-2.jpg");
			ImageIcon icon2 = new ImageIcon(imgUrl2);
			
			URL imgUrl3 = DrawUI.class.getResource("images/draw"+i+"-3.jpg");
			ImageIcon icon3 = new ImageIcon(imgUrl3);
						
			//����ѡ��ť��ͼƬ
			btn.setIcon(icon);
			btn.setRolloverIcon(icon1);
			btn.setPressedIcon(icon2);
			btn.setSelectedIcon(icon3);

			//��ӵ�������
			left.add(btn);
			
			if(i==6){//Ĭ��ѡ�е�6����ť
				btn.setSelected(true);
			}
		}
		
		//*****************�ײ���ɫѡ���״̬�����************************************//
		//���ײ���嶨��Ϊ�߿򲼾�
		foot.setLayout(new BorderLayout());
		//��ɫѡ�����
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(new Color(220,220,220));
		foot.add(colorPanel,BorderLayout.CENTER);
		
		//״̬�����
		StatePanel statePanel = new StatePanel();
		//ָ���ײ��ĸ߶�
		statePanel.setPreferredSize(new Dimension(1,20));
		statePanel.setBackground(new Color(235,235,235));
		foot.add(statePanel,BorderLayout.SOUTH);
		
		
		jf.setVisible(true);
		
		//��������������
		DrawListener dlis = new DrawListener(drawPanel,shapeGroup,statePanel);
		//��drawPanel�����������
		drawPanel.addMouseListener(dlis);
		drawPanel.addMouseMotionListener(dlis);
	}
}
