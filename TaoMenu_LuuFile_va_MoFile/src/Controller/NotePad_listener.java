package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import View.NotePad_view;

public class NotePad_listener implements ActionListener{
	private NotePad_view notePad_view;
	
	public NotePad_listener(NotePad_view notePad_view) {
		this.notePad_view = notePad_view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		// open file
		JFileChooser chooser = new JFileChooser();

		if (s.equals("Open")) {
		    int returnVal = chooser.showOpenDialog(notePad_view);

		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = chooser.getSelectedFile();
		        notePad_view.model.setFileName(file.getAbsolutePath());
		        notePad_view.lblNewLabel.setText(notePad_view.model.getFileName());
		        String nameFile = file.getName();
		        if (nameFile.endsWith(".txt")) {
		        	List<String> allText;
					try {
						allText = Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
						String res = "";
						for (String string : allText) {
							res += string;
							res += "\n";
						}
						this.notePad_view.model.setFileContent(res);
						this.notePad_view.textArea.setText(notePad_view.model.getFileContent());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		    }
		} else if (s.equals("Save")) {
			if (notePad_view.model.getFileName().length() > 0) {
				saveFile(notePad_view.model.getFileName(), chooser);
			} else {
				int returnVal = chooser.showSaveDialog(notePad_view);

			    if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = chooser.getSelectedFile();
			        saveFile(file.getAbsolutePath(), chooser);
			    }
			}
		}
	}
	public void saveFile(String fileName, JFileChooser chooser) {
		PrintWriter pw;
        try {
			pw = new PrintWriter(fileName, "UTF-8");
			String data = notePad_view.textArea.getText();
			pw.println(data);
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(chooser, "Lưu dữ liệu thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
