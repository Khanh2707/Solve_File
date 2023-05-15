import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Demo {
	public static void copyAll(File f1, File f2) {
		try {
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (f1.isDirectory()) {
			File[] f = f1.listFiles();
			for (File ff : f) {
				File copy = new File(f2.getAbsoluteFile()+"\\"+ff.getName());
				copyAll(ff, copy);
			}
		}
	}
	
	public static void main(String[] args) {
		File f2 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoRename\\f2.txt");
		File f3 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoRename\\f3.txt");
		
		// 1. Rename
		// sử dụng File
		//f2.renameTo(f3);
		
		// sử dụng Files
//		try {
//			Files.move(f2.toPath(), f3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 2. Move
//		File f1 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoRename\\f1\\f2.txt");
//		try {
//			Files.move(f2.toPath(), f1.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 3. Copy
		// Phương thức copy chỉ có thể copy vỏ chứ ko thể copy nội dung bên trong
		File f1 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoRename\\f1");
		File f1_copy = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoRename\\f1_copy");
		
//		try {
//			Files.copy(f1.toPath(), f1_copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Muốn copy all, phải sử dụng đệ quy
		copyAll(f1, f1_copy);
	}
}
