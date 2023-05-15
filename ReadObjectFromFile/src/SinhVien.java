import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Serializable {
	private String maSV;
	private String hoTen;
	private float diemTB;
	
	public SinhVien(String maSV) {
		this.maSV = maSV;
	}

	public SinhVien(String maSV, String hoTen, float diemTB) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemTB = diemTB;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", diemTB=" + diemTB + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(maSV, other.maSV);
	}
	
	
}
