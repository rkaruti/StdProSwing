package com.swings.login;

import javax.swing.JFrame;

public class LoginMain {
	public static void main(String[] a) {
		LoginFrame frame = new LoginFrame();
		frame.setTitle("Login Form");
		frame.setVisible(true);
		frame.setBounds(0, 0, 370, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}
