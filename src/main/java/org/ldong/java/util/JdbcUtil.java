package org.ldong.java.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
public class JdbcUtil {
	static {
		String d = "com.mysql.jdbc.Driver";
		try {
			Class.forName(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static Connection getConn() {
		String url = "jdbc:mysql://192.168.15.85:3306/ET?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String pwd = "jjwl";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void release(ResultSet rs, Statement stmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void releaseRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void releaseStmt(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void releaseConn(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Object o) {
		try {
			if (null != o) {
				if (o instanceof ResultSet) {
					((ResultSet) o).close();
				} else if (o instanceof Statement) {
					((Statement) o).close();
				} else if (o instanceof Connection) {
					((Connection) o).close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFile(String pathFrom, String pathTo) {
		try {
			FileInputStream fi = new FileInputStream(pathFrom);
			FileOutputStream fo = new FileOutputStream(pathTo);
			byte[] bs = new byte[1024];
			int len;
			while ((len = fi.read(bs)) != -1) {
				fo.write(bs, 0, len);
			}
			fi.close();
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		System.out.println(getConn());
	}
}