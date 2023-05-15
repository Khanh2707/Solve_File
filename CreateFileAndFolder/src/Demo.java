import java.io.File;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) {
		File folder1 = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoCreateFileAndFolder");
		System.out.println(folder1.exists());
		
		//Tạo 1 thư mục => mkdir
		File f1 = new File("D:\\demoFile");
		f1.mkdir();
		
		//Tạo nhiều thư mục => mkdirs
		File f2 = new File("D:\\demoFile\\File1\\File2\\File3 ");
		f2.mkdirs();
		
		//Tạo tập tin (có phần mở rộng: .exe, .txt, .doc, .xls ....)
		File f3 = new File("D:\\demoFile\\example1.txt");
		try {
			f3.createNewFile();
		} catch (IOException e) {
			// ko có quyền tạo tập tin
			// ổ cứng đầy
			// đường dẫn sai
			// thư mục ko tồn tại
			//....
			e.printStackTrace();
		}
	}
}
