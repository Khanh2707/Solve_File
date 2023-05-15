package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.QLSV_model;
import Model.SinhVien;
import Model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Listener;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class view_QLSV extends JFrame {

	public JPanel contentPane;
	public QLSV_model model;
	public JTextField textField_maSV;
	public JTable table;
	public JTextField textField_maSVUnder;
	public JTextField textField_hoTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_diem1;
	public JTextField textField_diem2;
	public JTextField textField_diem3;
	public JComboBox comboBox_queQuanUnder;
	public JComboBox comboBox_queQuan;
	public ButtonGroup btngr;
	public JRadioButton rdbtn_nam;
	public JRadioButton rdbtn_nu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_QLSV frame = new view_QLSV();
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
	public view_QLSV() {
		model = new QLSV_model();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 759);
		setLocationRelativeTo(null);
		setTitle("Chương trình quản lý sinh viên của Trần Phúc Khánh");
		
		ActionListener listener = new Listener(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_file = new JMenu("File");
		menu_file.addActionListener(listener);
		menuBar.add(menu_file);
		
		JMenuItem menuItem_open = new JMenuItem("Open");
		menuItem_open.addActionListener(listener);
		menu_file.add(menuItem_open);
		
		JMenuItem menuItem_save = new JMenuItem("Save");
		menuItem_save.addActionListener(listener);
		menu_file.add(menuItem_save);
		
		JSeparator separator = new JSeparator();
		menu_file.add(separator);
		
		JMenuItem menuItem_exit = new JMenuItem("Exit");
		menuItem_exit.addActionListener(listener);
		menu_file.add(menuItem_exit);
		
		JMenu menu_about = new JMenu("About");
		menu_about.addActionListener(listener);
		menuBar.add(menu_about);
		
		JMenuItem menuItem_about_me = new JMenuItem("About me");
		menuItem_about_me.addActionListener(listener);
		menu_about.add(menuItem_about_me);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_queQuan = new JLabel("Quê quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_queQuan.setBounds(26, 38, 86, 42);
		contentPane.add(label_queQuan);
		
		comboBox_queQuan = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDS_Tinh();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_queQuan.setBounds(122, 40, 102, 43);
		contentPane.add(comboBox_queQuan);
		
		JLabel label_maSinhVien = new JLabel("Mã sinh viên");
		label_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maSinhVien.setBounds(259, 38, 110, 42);
		contentPane.add(label_maSinhVien);
		
		textField_maSV = new JTextField();
		textField_maSV.setBounds(379, 38, 102, 43);
		contentPane.add(textField_maSV);
		textField_maSV.setColumns(10);
		
		JButton button_timKiem = new JButton("Tìm kiếm");
		button_timKiem.addActionListener(listener);
		button_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_timKiem.setBounds(506, 38, 127, 43);
		contentPane.add(button_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 102, 728, 2);
		contentPane.add(separator_1);
		
		JLabel label_danhSachSV = new JLabel("Danh sách SV");
		label_danhSachSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_danhSachSV.setBounds(26, 127, 122, 42);
		contentPane.add(label_danhSachSV);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã SV", "Họ tên", "Quê quán", "Ngày sinh", "Giới tính", "Điểm môn 1", "Điểm môn 2", "Điểm môn 3"
			}
		));
		
		table.setRowHeight(27);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 179, 696, 92);
		contentPane.add(scrollPane);
		
		JLabel label_thongTinSV = new JLabel("Thông tin SV");
		label_thongTinSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_thongTinSV.setBounds(26, 303, 115, 42);
		contentPane.add(label_thongTinSV);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 291, 728, 2);
		contentPane.add(separator_2);
		
		JLabel label_maSinhVienUnder = new JLabel("Mã sinh viên");
		label_maSinhVienUnder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_maSinhVienUnder.setBounds(26, 355, 110, 42);
		contentPane.add(label_maSinhVienUnder);
		
		JLabel label_hoTenUnder = new JLabel("Họ tên");
		label_hoTenUnder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_hoTenUnder.setBounds(26, 422, 110, 42);
		contentPane.add(label_hoTenUnder);
		
		JLabel label_queQuanUnder = new JLabel("Quê quán");
		label_queQuanUnder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_queQuanUnder.setBounds(26, 489, 110, 42);
		contentPane.add(label_queQuanUnder);
		
		JLabel label_ngaySinhUnder = new JLabel("Ngày sinh");
		label_ngaySinhUnder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_ngaySinhUnder.setBounds(26, 556, 110, 42);
		contentPane.add(label_ngaySinhUnder);
		
		textField_maSVUnder = new JTextField();
		textField_maSVUnder.setColumns(10);
		textField_maSVUnder.setBounds(161, 355, 170, 43);
		contentPane.add(textField_maSVUnder);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(161, 422, 170, 43);
		contentPane.add(textField_hoTen);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(161, 556, 170, 43);
		contentPane.add(textField_ngaySinh);
		
		JLabel label_gioiTinhUnder = new JLabel("Giới tính");
		label_gioiTinhUnder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_gioiTinhUnder.setBounds(426, 355, 110, 42);
		contentPane.add(label_gioiTinhUnder);
		
		JLabel label_diem1Under = new JLabel("Điểm 1");
		label_diem1Under.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_diem1Under.setBounds(426, 422, 110, 42);
		contentPane.add(label_diem1Under);
		
		JLabel label_diem2Under = new JLabel("Điểm 2");
		label_diem2Under.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_diem2Under.setBounds(426, 489, 110, 42);
		contentPane.add(label_diem2Under);
		
		JLabel label_diem3Under = new JLabel("Điểm 3");
		label_diem3Under.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_diem3Under.setBounds(426, 556, 110, 42);
		contentPane.add(label_diem3Under);
		
		textField_diem1 = new JTextField();
		textField_diem1.setColumns(10);
		textField_diem1.setBounds(562, 422, 170, 43);
		contentPane.add(textField_diem1);
		
		textField_diem2 = new JTextField();
		textField_diem2.setColumns(10);
		textField_diem2.setBounds(562, 489, 170, 43);
		contentPane.add(textField_diem2);
		
		textField_diem3 = new JTextField();
		textField_diem3.setColumns(10);
		textField_diem3.setBounds(562, 556, 170, 43);
		contentPane.add(textField_diem3);
		
		rdbtn_nam = new JRadioButton("Nam");
		rdbtn_nam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_nam.setBounds(562, 355, 71, 42);
		contentPane.add(rdbtn_nam);
		rdbtn_nam.setSelected(true);
		
		rdbtn_nu = new JRadioButton("Nữ");
		rdbtn_nu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_nu.setBounds(647, 355, 71, 42);
		contentPane.add(rdbtn_nu);
		
		btngr = new ButtonGroup();
		btngr.add(rdbtn_nam);
		btngr.add(rdbtn_nu);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(listener);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_them.setBounds(21, 633, 127, 43);
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(listener);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_xoa.setBounds(595, 633, 127, 43);
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.addActionListener(listener);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_capNhat.setBounds(215, 633, 127, 43);
		contentPane.add(btn_capNhat);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(listener);
		btn_luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_luu.setBounds(409, 633, 127, 43);
		contentPane.add(btn_luu);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 615, 728, 2);
		contentPane.add(separator_1_1);
		
		comboBox_queQuanUnder = new JComboBox();
		comboBox_queQuanUnder.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuanUnder.addItem(tinh.getTenTinh());
		}
		comboBox_queQuanUnder.setBounds(161, 488, 170, 43);
		contentPane.add(comboBox_queQuanUnder);
		
		JButton button_huyTimKien = new JButton("Hủy");
		button_huyTimKien.addActionListener(listener);
		button_huyTimKien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_huyTimKien.setBounds(650, 38, 79, 43);
		contentPane.add(button_huyTimKien);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_maSV.setText("");
		textField_maSVUnder.setText("");
		textField_hoTen.setText("");
		textField_ngaySinh.setText("");
		textField_diem1.setText("");
		textField_diem2.setText("");
		textField_diem3.setText("");
		comboBox_queQuanUnder.setSelectedIndex(-1);
		btngr.clearSelection();
	}
	
	public void themSVVaoBang(SinhVien sv) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.addRow(new Object[]{
				sv.getMaSinhVien()+"", 
				sv.getTenSinhVien(),
				sv.getQueQuan().getTenTinh(),
				sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth() + 1)+"/"+(sv.getNgaySinh().getYear()+1900),
				sv.isGioiTinh() ? "Nam" : "Nữ",
				sv.getDiemMon1()+"",
				sv.getDiemMon2()+"",
				sv.getDiemMon3()+""});
	}

	public void themHoacCapNhatSV(SinhVien sv) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(sv)) {
			System.out.println("check add");
			this.model.addSV(sv);
			this.themSVVaoBang(sv);
			System.out.println(this.model.getDssv().size());
		}
		else {
			System.out.println("check update");
			this.model.update(sv);
			this.model.addSV(sv);
			int soDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soDong; i++) {
				String id = defaultTableModel.getValueAt(i, 0)+"";
				if (id.equals(sv.getMaSinhVien()+"")) {
					defaultTableModel.setValueAt(sv.getMaSinhVien()+"", i, 0);
					defaultTableModel.setValueAt(sv.getTenSinhVien()+"", i, 1);
					defaultTableModel.setValueAt(sv.getQueQuan().getTenTinh(), i, 2);
					defaultTableModel.setValueAt(sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900)+"", i, 3);
					defaultTableModel.setValueAt(sv.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					defaultTableModel.setValueAt(sv.getDiemMon1(), i, 5);
					defaultTableModel.setValueAt(sv.getDiemMon2(), i, 6);
					defaultTableModel.setValueAt(sv.getDiemMon3(), i, 7);
				}
			}
		}
	}
	
	public SinhVien getSVisSelected() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		int maSV = Integer.valueOf(defaultTableModel.getValueAt(row, 0)+"");
		String tenSV = defaultTableModel.getValueAt(row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(defaultTableModel.getValueAt(row, 2)+"");
		String s_ngaySinh = defaultTableModel.getValueAt(row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = defaultTableModel.getValueAt(row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(defaultTableModel.getValueAt(row, 5)+"");
		float diemMon2 = Float.valueOf(defaultTableModel.getValueAt(row, 6)+"");
		float diemMon3 = Float.valueOf(defaultTableModel.getValueAt(row, 7)+"");
		
		SinhVien sv = new SinhVien(maSV, tenSV, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return sv;
	}

	public void hienThiThongTinSinhVienDangDuocChon() {
		SinhVien sv = getSVisSelected();
		
		this.textField_maSVUnder.setText(sv.getMaSinhVien()+"");
		this.textField_hoTen.setText(sv.getTenSinhVien()+"");
		this.comboBox_queQuanUnder.setSelectedItem(sv.getQueQuan().getTenTinh());
		String s = (sv.getNgaySinh().getDate())+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900);
		this.textField_ngaySinh.setText(s+"");
		if (sv.isGioiTinh()) {
			rdbtn_nam.setSelected(true);
		} else {
			rdbtn_nu.setSelected(true);
		}
		this.textField_diem1.setText(sv.getDiemMon1()+"");
		this.textField_diem2.setText(sv.getDiemMon2()+"");
		this.textField_diem3.setText(sv.getDiemMon3()+"");
	}

	public void Xoa() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa sinh viên ???");
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSVisSelected();
			this.model.removeSV(sv);
			defaultTableModel.removeRow(row);
		}
	}

	public void Them() {
		// get dữ liệu
		int maSV = Integer.valueOf(this.textField_maSVUnder.getText());
		String tenSV = this.textField_hoTen.getText();
		int idQueQuan = this.comboBox_queQuanUnder.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(idQueQuan);
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		boolean gioiTinh = true;
		if (this.rdbtn_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtn_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_diem1.getText());
		float diemMon2 = Float.valueOf(this.textField_diem2.getText());
		float diemMon3 = Float.valueOf(this.textField_diem3.getText());
			
		SinhVien sv = new SinhVien(maSV, tenSV, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		
		this.themHoacCapNhatSV(sv);
	}

	public void TimKiem() {
		// huy tim kiem
		this.LoadLaiDuLieu();
		
		// tim kiem
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		String maSVTimKiem = this.textField_maSV.getText();
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int soDong = defaultTableModel.getRowCount();
		
		Set<Integer> idSVCanXoa = new TreeSet<>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soDong; i++) {
				String tenTinh = defaultTableModel.getValueAt(i, 2)+"";
				String id = defaultTableModel.getValueAt(i, 0)+"";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idSVCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maSVTimKiem.length() > 0) {
			for (int i = 0; i < soDong; i++) {
				String id = defaultTableModel.getValueAt(i, 0)+"";
				if (!id.equals(maSVTimKiem)) {
					idSVCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idSVCanXoa) {
			soDong = defaultTableModel.getRowCount();
			for (int i = 0; i < soDong; i++) {
				String idTrongBang = defaultTableModel.getValueAt(i, 0)+"";
				if (idTrongBang.equals(idCanXoa.toString())) {
					try {
						defaultTableModel.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void LoadLaiDuLieu() {
		while (true) {
			DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
			int soDong = table.getRowCount();
			if (soDong==0)
				break;
			else
				try {
					defaultTableModel.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SinhVien sv : this.model.getDssv()) {
			this.themSVVaoBang(sv);
		}
		System.out.println(this.model.getDssv().size());
	}

	public void HienThiAbout() {
		JOptionPane.showMessageDialog(this,"Bố mày cắt đầu moi, bố mày bố mày cắt đầu moi, yeh\r\n"
				+ "Nổ cho tao cái địa chỉ bố qua nhà mày bố đánh mày chết toi\r\n"+"Bố mày cắt đầu moi bố mày là đàn em của khá bảnh\r\n"
				+ "Bố mày không rẻ rách bố mặc eo vì này trông khá chảnh\r\n"
				+ "Mày nghĩ mày đeo nhiều vàng trên cổ thì đấy thì đấy là hay\r\n"
				+ "Mau nổ ngay cho tao cái địa chỉ mày đừng ngồi đấy tao thấy là cay\r\n"
				+ "Trong cái xã hội chuẩn chỉ có mình tao là đẳng cấp\r\n"
				+ "Kéo cả lò anh em của mày ra đây một mình thằng bố mày chấp\r\n"
				+ "Mấy em gái mà xem live stream của tao idol tao như sơn tùng\r\n"
				+ "Mày nghĩ mày đẹp trai hơn tao hay sao mau cho địa chỉ đi thằng giang tùng\r\n"
				+ "Bố mày mặc eo vì này bố mày chất\r\n"
				+ "Bố ứ sợ mày đâu bố mày nhất\r\n"
				+ "Bố mày là idol này bố nổi tiếng\r\n"
				+ "Bố *** có thời gian đừng chọc tức bố vì bố mày cắt đầu moi");
	}

	public void ThoatChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ???","Thoát chương trình!",JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sinhVien : this.model.getDssv()) {
				oos.writeObject(sinhVien);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showSaveDialog(this);

		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = chooser.getSelectedFile();
		        saveFile(file.getAbsolutePath());
		    }
		}
		
	}
	
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while ((sv = (SinhVien) ois.readObject()) != null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDssv(ds);
	}

	public void OpenFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);

	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = chooser.getSelectedFile();
	        openFile(file);
	        LoadLaiDuLieu();
	    }
	}
}
