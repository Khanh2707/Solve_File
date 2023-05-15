package Test;

import javax.swing.UIManager;

import View.view_QLSV;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new view_QLSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
