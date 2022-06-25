package com.ispan.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class InitializeData {

	private static final String DB_NAME = "GoTrip";
	private static final String TB_NAME = "comments";
//	private static final String IMAGE_DIR = "upload_images";
	private static final String IMAGE_DIR = "data/upload_images";

	private static final String CREATE_TB = "CREATE TABLE comments (" 
												+ " id int PRIMARY KEY IDENTITY(1,1) NOT NULL,"
												+ "	item_tb varchar(25) NOT NULL," 
												+ "	item_id int NOT NULL," 
												+ "	user_id varchar(20) NOT NULL,"
												+ "	date datetime NOT NULL," 
												+ "	rating int NOT NULL," 
												+ "	content nvarchar(200),"
												+ "	image1 nvarchar(max)," 
												+ "	image2 nvarchar(max)," 
												+ "	image3 nvarchar(max)," 
											+ ");";

	private static final String INSERT_SQL = "INSERT INTO comments VALUES (?, ?, ?, ?, ?, ?,?,?,?)";

	
	
	public static void main(String args[]) {
		DataSource ds = DBConnection.dataSource();
		Connection conn = null;
		Statement stmt;
		
		// Create DB
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("DROP DATABASE IF EXISTS " + DB_NAME);
			stmt.executeUpdate("CREATE DATABASE " + DB_NAME + " COLLATE Chinese_Taiwan_Stroke_CI_AI");
			System.out.println("成功新增Database: " + DB_NAME);
		} catch (SQLException e) {
			System.err.println("無法新增Databsae: " + DB_NAME);
			e.printStackTrace();
		}

		((SQLServerDataSource) ds).setDatabaseName(DB_NAME);

		// Create Table
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("DROP DATABASE IF EXISTS " + TB_NAME);
			stmt.executeUpdate(CREATE_TB);
			System.out.println("成功新增Table: " + TB_NAME);
		} catch (SQLException e) {
			System.err.println("無法新增Table: " + TB_NAME);
			e.printStackTrace();
		}

		// Insert comments
		insertComments(conn);

	}
	

	// Insert data of comments then close connection
	public static void insertComments(Connection conn) {

		try (FileInputStream fis = new FileInputStream("src/main/webapp/data/comments.csv");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr)) {
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(br);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
			Date formatDate;
			for (CSVRecord record : records) {
				pstmt.setString(1, record.get(0));
				pstmt.setInt(2, Integer.parseInt(record.get(1)));
				pstmt.setString(3, record.get(2));
				formatDate = date.parse(record.get(3));
				pstmt.setTimestamp(4, new Timestamp(formatDate.getTime()));
				pstmt.setInt(5, Integer.parseInt(record.get(4)));
				pstmt.setString(6, record.get(5));
				for (int i = 0; i < 3; i++) {
					if (!record.get(6 + i).isEmpty()) {
						pstmt.setString(7 + i, uploadFile(record.get(6 + i)));
					} else {
						pstmt.setNull(7 + i, Types.NVARCHAR);
					}
				}
				pstmt.addBatch();
			}
			int[] data = pstmt.executeBatch();
			pstmt.close();
			System.out.println("成功新增" + data.length + "筆評論資料");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static String uploadFile(String fileName) {
		File inputFile = new File("src/main/webapp/data/images/" + fileName);
		Path currentDir = Paths.get("").toAbsolutePath();
		String outputPath = currentDir + "/src/main/webapp/" + IMAGE_DIR;
//		String outputPath = "src/main/webapp/" + IMAGE_DIR;
		String savePath = null;
		File outputDir = new File(outputPath);
//		File outputDir = new File(request.getServletContext().getRealPath("") + "uploadTemp" + File.separator);
		if (!outputDir.exists()) {
			outputDir.mkdir();
		}
		//  檔名為時間+原始檔名
		String saveFileName = System.currentTimeMillis() + "_" + fileName;
		File outputFile = new File(outputPath + File.separator + saveFileName);
		try (InputStream is = new FileInputStream(inputFile);
			 OutputStream os = new FileOutputStream(outputFile);
			 BufferedOutputStream bos = new BufferedOutputStream(os)) {
			byte[] buffer = new byte[4096];
			while (is.read(buffer) != -1) {
				bos.write(buffer);
			}
			bos.flush();
			savePath = IMAGE_DIR + File.separator + saveFileName;
//			savePath = IMAGE_DIR + File.separator + fileName;
		} catch (Exception e) {
			savePath = null;
			System.err.println("圖片IO有誤");
			e.printStackTrace();
		}
		return savePath;
	}



}
