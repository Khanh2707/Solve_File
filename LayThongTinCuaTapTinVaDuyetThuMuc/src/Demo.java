import java.io.File;
import java.util.Scanner;

public class Demo {
	File file;
	public Demo(String tenFile) {
		this.file = new File(tenFile);
	}
	
	public boolean testExecute() {
		return this.file.canExecute();
	}
	
	public boolean testRead() {
		return this.file.canRead();
	}
	
	public boolean testWrite() {
		return this.file.canWrite();
	}
	
	public void printFilePath() {
		System.out.println(this.file.getAbsolutePath());
	}
	
	public void printName() {
		System.out.println(this.file.getName());
	}
	
	public void whetherFile_orFolder() {
		if (this.file.isFile()) {
			System.out.println("This is file");
		}
		else if (this.file.isDirectory())
			System.out.println("This is folder");
	}
	
	public void printListFileChildren() {
		if (this.file.isDirectory()) {
			System.out.println("Các tập tin/thư mục con là: ");
			File[] ds = this.file.listFiles();
			for (File file : ds) {
				System.out.println(file.getAbsolutePath());
			}
		}
		else if (this.file.isFile()) {
			System.out.println("This is file, not has file children");
		}
	}
	
	public void printTreeFolder() {
		this.printDetailTreeFolder(this.file, 1);
	}
	
	public void printDetailTreeFolder(File f, int bac) {
		for (int i = 0; i < bac; i++) {
			System.out.println("\t");
		}
		System.out.println("|__");
		System.out.println(f.getName());
		if (f.canRead() && f.isDirectory()) {
			File[] ds = f.listFiles();
			for (File fx : ds) {
				printDetailTreeFolder(fx, bac + 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Nhập tên file: ");
		String tenFile = sc.nextLine();
		Demo d1 = new Demo(tenFile);
		do {
			System.out.println("-------MENU-------");
			System.out.println("1. Kiểm tra file có thể thực thi? ");
			System.out.println("2. Kiểm tra file có thể đọc? ");
			System.out.println("3. Kiểm tra file có thể ghi? ");
			System.out.println("4. In đường dẫn ");
			System.out.println("5. In tên file ");
			System.out.println("6. Kiểm tra file là thư mục hay tập tin? ");
			System.out.println("7. In danh sách các file con ");
			System.out.println("8. In ra cây thư mục ");
			System.out.println("0. Thoát chương trình ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(d1.testExecute());
				break;
			case 2:
				System.out.println(d1.testRead());
				break;
			case 3:
				System.out.println(d1.testWrite());
				break;
			case 4:
				d1.printFilePath();
				break;
			case 5:
				d1.printName();
				break;
			case 6:
				d1.whetherFile_orFolder();
				break;
			case 7:
				d1.printListFileChildren();
				break;
			case 8:
				d1.printTreeFolder();
				break;
			case 0:
				return;
			default:
				System.out.println("Lựa chọn ko hợp lệ! ");
				break;
			}
		} while (choice != 0);
	}
}
