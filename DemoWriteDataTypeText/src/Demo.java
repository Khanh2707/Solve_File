import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Demo {
	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter("C:\\Users\\nthtp\\eclipse-workspace\\DemoWriteDataTypeText\\f1.txt", "UTF-8");
			pw.println("Bố mày là Trần Phúc Khánh");
			pw.println("Bố mày cắt đầu moi, bố mày là đàn em của khá bảnh");
			pw.println("Bố mày ko rẻ rách, bố mặc eo vì này trông cũng khá bảnh"); 
			Student s1 = new Student(27,"Trần Khánh");
			pw.println(s1);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
