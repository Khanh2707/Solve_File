import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiCSDL {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String Url = "jdbc:sqlserver://LAPTOP-BH0L3U68\\MYSQLSERVER:1433;databaseName=ThucTap;encrypt=false;integratedSecurity=false";
			conn = DriverManager.getConnection(Url, "sa", "27072003");
			System.out.println("Connect Successful!!!!!!!!!!!!!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connect Failed!");
			e.printStackTrace(); 
		}
		
		try {
			DatabaseMetaData mtdt = conn.getMetaData();
			System.out.println(mtdt.getDatabaseProductName());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			Statement stm1 = conn.createStatement();
			String queryInsert = "insert into TBLSinhVien\r\n"
					+ "values(27,'Tran Phuc Khanh','Math',2003,'Yen Bai')";
			
			int check = stm1.executeUpdate(queryInsert);
			System.out.println("Thêm bản ghi thành công!!!!!");
		} catch (SQLException e1) {
			System.out.println("Thêm bản ghi thất bại!");
			e1.printStackTrace();
		}
		
		try {
			conn.close();
			System.out.println("Close Successful!!!!!!!!");
		} catch (SQLException e) {
			System.out.println("Close Failed!");
			e.printStackTrace();
		}
	}
}
