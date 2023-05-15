package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.SinhVien;
import Model.Tinh;
import View.view_QLSV;

public class Listener implements ActionListener{
	view_QLSV view;
	
	public Listener(view_QLSV view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.println("Bạn vừa nhấn: " +s);
		
		if (s.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (s.equals("Lưu")) {
			try {
				this.view.Them();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (s.equals("Cập nhật")) {
			this.view.hienThiThongTinSinhVienDangDuocChon();
		} else if (s.equals("Xóa")) {
			this.view.Xoa();
		} else if (s.equals("Tìm kiếm")) {
			this.view.TimKiem();
		} else if (s.equals("Hủy")) {
			this.view.LoadLaiDuLieu();
		} else if (s.equals("About me")) {
			this.view.HienThiAbout();
		} else if (s.equals("Exit")) {
			this.view.ThoatChuongTrinh();
		} else if (s.equals("Save")) {
			this.view.SaveFile();
			JOptionPane.showMessageDialog(view, "Lưu dữ liệu thành công!");
		} else if (s.equals("Open")) {
			this.view.OpenFile();
		}
	}
	
}
