package com.spring.SpringBeanLifecycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationDao {
	
	
	Connection conn;
	
//	@Value("${driver}")
	private String driver;
	
//	@Value("${url}")
	private String url;
	
//	@Value("${url}")
	private String user;
	
//	@Value("${password}")
	private String password;
	
	
	
	
	public String getDriver() {
		return driver;
	}



	@Value("${driver}")
	public void setDriver(String driver) {
		System.out.println("setDriver method");
		this.driver = driver;
	}



	public String getUrl() {
		return url;
	}


	@Value("${url}")
	public void setUrl(String url) {
		System.out.println("setUrl method");
		this.url = url;
	}



	public String getUser() {
		return user;
	}


	@Value("${user}")
	public void setUser(String user) {
		System.out.println("setUser method");
		this.user = user;
	}



	public String getPassword() {
		return password;
	}


	@Value("${password}")
	public void setPassword(String password) {
		System.out.println("setPassword method");
		this.password = password;
	}


	

//	@Override
//	public String toString() {
//		return "ApplicationDao [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
//	}

	@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {
		getConnection();
	}
	
	public void getConnection() throws ClassNotFoundException, SQLException {
		
		System.out.println("==========Getting connection===========");
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,password);
	}
	

	public void getStudentDetails() throws ClassNotFoundException, SQLException {
		
		System.out.println("============Inside read method=================");
		
//		getConnection(); // establish connection
		
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("select * from student");
		
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		
//		closeConnection(); // closing connection
		
	}
	
	public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		
		System.out.println("=============Inside delete method===========");
		
//		getConnection(); // establish connection
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from student where id="+id);

//		closeConnection();
	}
	
	public void closeConnection() throws SQLException {
		System.out.println("=========closing connection==============");
		conn.close();
	}
	
	@PreDestroy
	public void destroy() throws SQLException {
		 closeConnection();
	}
	
	
}
