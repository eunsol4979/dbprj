package co.micol.dbPrj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.jdi.connect.spi.Connection;

public class DataSource {
	private String driver;  //사용할 jdbc 드라이버
	private String url;		//DBMS가 위치한 주소	
	private String user;	//DB에 접속할 계정 
	private String password;//DB 접속계정의 패스워드
	
	private Connection conn; //java에서 DBMS연결객체
	
	public DataSource() {
		getDbproperties();
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}
	
	private void getDbproperties() {
		File path = new File("src/main/resources/db.properties"); //파일을 다루는 객체
		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(path);
			properties.load(file);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}
