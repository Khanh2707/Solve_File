package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.NotePad_listener;
import Model.NotePad_model;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NotePad_view extends JFrame {

	private JPanel contentPane;
	public NotePad_model model;
	public JLabel lblNewLabel;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePad_view frame = new NotePad_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NotePad_view() {
		this.model = new NotePad_model();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = 	new JPanel();
		panel.setPreferredSize(new Dimension(0,50)); // new Dimension(chiều rộng, chiều cao): set kích cỡ cho Panel
													 // chiều rộng tự động theo kích cỡ chương trình, chiều cao tự chỉnh
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 405, 50);
		panel.add(lblNewLabel);
		
		NotePad_listener listener = new NotePad_listener(this);
		
		JButton open_button = new JButton("Open");
		open_button.addActionListener(listener);
		open_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		open_button.setBounds(446, 10, 99, 30);
		panel.add(open_button);
		
		JButton save_button = new JButton("Save");
		save_button.addActionListener(listener);
		save_button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save_button.setBounds(574, 10, 99, 30);
		panel.add(save_button);
	}
}
