package Model;

import java.util.ArrayList;

public class QLSV_model {
	private ArrayList<SinhVien> dssv;
	private String luaChon;
	private String tenFile;

	public QLSV_model() {
		this.dssv = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLSV_model(ArrayList<SinhVien> dssv) {
		this.dssv = dssv;
	}

	public ArrayList<SinhVien> getDssv() {
		return dssv;
	}

	public void setDssv(ArrayList<SinhVien> dssv) {
		this.dssv = dssv;
	}
	
	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void addSV(SinhVien sv) {
		this.dssv.add(sv);
	}
	
	public void removeSV(SinhVien sv) {
		this.dssv.remove(sv);
	}
	
	public void update(SinhVien sv) {
		for (SinhVien sinhVien : dssv) {
			if (sinhVien.getMaSinhVien() == sv.getMaSinhVien()) {
				removeSV(sinhVien);
				break;
			}
		}
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		for (SinhVien sinhVien : dssv) {
			if (sinhVien.getMaSinhVien() == sv.getMaSinhVien())
				return true;
		}
		return false;
	}
}
