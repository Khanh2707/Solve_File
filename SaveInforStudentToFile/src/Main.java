import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		
		int choice = -1;
		do {
			System.out.println("-------MENU-------");
			System.out.println(
					  "1. Thêm sv\n"
					+ "2. In ds sv\n"
					+ "3. Kiểm tra ds có rỗng ?\n"
					+ "4. Lấy ra số lượng sinh viên\n"
					+ "5. Làm rỗng ds sv\n"
					+ "6. Kiểm tra sv có trong ds theo mã sv\n"
					+ "7. Xóa 1 sv theo mã sv\n"
					+ "8. Tìm kiếm sv theo tên\n"
					+ "9. In ds sv từ cao đến thấp theo điểm\n"
					+ "10. Lưu danh sách sinh viên xuống tập tin\n"
					+ "0. Thoát");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1) {
				System.out.println("Nhập mã sv: ");
				String maSv = sc.nextLine();
				System.out.println("Nhập họ tên: ");
				String hoTEN = sc.nextLine();
				System.out.println("Nhập điểm: ");
				float diemTb = sc.nextFloat();
				SinhVien sv = new SinhVien(maSv, hoTEN, diemTb);
				dssv.themSV(sv);
			} else if (choice == 2) {
				dssv.inSV();
			} else if (choice == 3) {
				System.out.println(dssv.kiemTraRong());
			} else if (choice == 4) {
				System.out.println(dssv.soLuongSV());
			} else if (choice == 5) {
				dssv.lamRongDS();
			} else if (choice == 6) {
				System.out.println("Nhập mã sinh viên: ");
				String maSV6 = sc.nextLine();
				SinhVien sv6 = new SinhVien(maSV6);
				System.out.println(dssv.kiemTraSVCoTrongDS(sv6));
			} else if (choice == 7) {
				System.out.println("Nhập mã sinh viên: ");
				String maSV7 = sc.nextLine();
				SinhVien sv7 = new SinhVien(maSV7);
				dssv.xoaSV(sv7);
			} else if (choice == 8) {
				System.out.println("Nhập tên sinh viên: ");
				String tenSV8 = sc.nextLine();
				dssv.timSinhVien(tenSV8);
			} else if (choice == 9) {
				dssv.sapXep();
			} else if (choice == 10) {
				System.out.println("Nhập tên file: ");
				String tenFile = sc.nextLine();
				File f = new File(tenFile);
				dssv.ghiDuLieuXuongFile(f);
			}
		} while (choice != 0);
	}
}
