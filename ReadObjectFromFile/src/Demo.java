import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Demo {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\nthtp\\eclipse-workspace\\DemoReadObjectFromFile\\file.data");
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			SinhVien s1 = (SinhVien) ois.readObject();
			System.out.println(s1);
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
