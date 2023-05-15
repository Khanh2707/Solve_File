import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class DanhSachSinhVien {
	public ArrayList<SinhVien> ds;

	public DanhSachSinhVien() {
		this.ds = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> ds) {
		this.ds = ds;
	}
	
	//1
	public void themSV(SinhVien sv) {
		this.ds.add(sv);
	}
	
	//2
	public void inSV() {
		for (SinhVien sinhVien : ds) {
			System.out.println(sinhVien);
		}
	}
	
	//3
	public boolean kiemTraRong() {
		return this.ds.isEmpty();
	}
	
	//4
	public int soLuongSV() {
		return this.ds.size();
	}
	
	//5
	public void lamRongDS() {
		this.ds.removeAll(ds);
	}
	
	//6
	public boolean kiemTraSVCoTrongDS(SinhVien sv) {
		return this.ds.contains(sv);
	}
	
	//7
	public void xoaSV(SinhVien sv) {
		this.ds.remove(sv);
	}
	
	//8
	public void timSinhVien(String ten) {
		for (SinhVien sinhVien : ds) {
			if (sinhVien.getHoTen().indexOf(ten) >= 0) {
				System.out.println("Có thằng này");
				System.out.println(sinhVien);
				return;
			}
		}
		System.out.println("Ko có đâu em");
	}
	
	//9
	public void sapXep() {
		Collections.sort(ds, new SortPoint());
		for (SinhVien sinhVien : ds) {
			System.out.println(sinhVien);
		}
	}
	
	//10
	public void ghiDuLieuXuongFile(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			for (SinhVien sinhVien : ds) {
				oos.writeObject(sinhVien);
			}
			
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
