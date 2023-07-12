package org.sp.app0712.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	JButton[] menu; //어플리케이션의 네비게이션 메뉴 
	ImageIcon[] icon; 
	
	JPanel p_north; //네비게이션들이 올라갈 컨테이너 
	JPanel p_center; //모든 컨텐츠의 페이지가 붙여질 컨테이너 (스크롤 가능)
	JScrollPane scroll;
	
	public MainFrame() {
		menu = new JButton[4];
		icon = new ImageIcon[4];
		
		p_north = new JPanel();
		
		createIcon();
		
		//버튼 4개 생성 
		for(int i=0;i<menu.length;i++) {
			menu[i] = new JButton(icon[i]);
			p_north.add(menu[i]);
		}
		p_center = new JPanel();
		scroll = new JScrollPane(p_center);
		p_center.setBackground(Color.YELLOW);
		
		add(p_north, BorderLayout.NORTH);//네비를 포함하는 패널을 북쪽에 부착
		add(scroll);
		
		setSize(1000,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void createIcon() {
		String[] path= {"product.png","member.png","company.png","board.png"};
		
		try {
			for(int i=0;i<path.length;i++) {
				Image image=ImageIO.read(ClassLoader.getSystemResource("res/icon/"+path[i]));
				icon[i]=new ImageIcon(image);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}





