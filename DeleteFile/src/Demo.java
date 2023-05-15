import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Demo {
	
	public static void deleteFile(File f) {
		if (f.isFile()) {
			f.delete();
		} 
		else if (f.isDirectory()) {
			File[] ar = f.listFiles();
			for (File ff : ar) {
				deleteFile(ff);
			}
			f.delete();
		}
	}

	public static void main(String[] args) {
		File f0 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoDeleteFile\\f0");
		File f1 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoDeleteFile\\f1");
		File t0 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoDeleteFile\\t0.txt");
		
//		f0.deleteOnExit();
//		f1.deleteOnExit(); // xóa được vì là thư mục rỗng
//		t0.deleteOnExit(); // xóa được vì là file
		
		//delete: trả về boolean
		//deleteOnExit: ko trả về gì cả
		// 2 hàm này chỉ xóa được khi folder rỗng hoặc là file
		
		//Muốn xóa được 1 folder có các folder hoặc file hoặc cả 2 phải viết đệ quy
		//deleteFile(f0);
		
		// Sử dụng class Files để xóa tập tin và thư mục
		Path p = f0.toPath();
		Path p1 = t0.toPath();
		try {
			//Files.deleteIfExists(p);
			Files.delete(p1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
