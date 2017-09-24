
# Java code for Phase 3:

package max_temp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import javax.print.DocFlavor.READER;

import org.w3c.dom.css.Counter;



public class Max_temperature {
	private static final int MISSING = 9999;
	private static final String COMMA = ",";
	private static final String SEPARATOR = "\n";
	int airTemperature;
	int year;
	static Statement stmt = null;
	FileWriter f_w;
	static Connection conn= null;
	ResultSet rs = null;
    boolean success = true;
    int[] executeResult = null;
	
	
	//Connection with Database
	public Connection newconnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/professor_02?", "root","safestsystemever");
					stmt =conn.createStatement();						
			}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return conn;
	}
	
	//Dataset-1 function
	public void dataset1() throws Exception{
		createTable1();
		readdata1();
		Insertdata1();
		 ResultSet rs = getResultSet1();
		  while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2));
			}
	}
	
	//Dataset-2 function
	public void dataset2() throws Exception{
		createTable2();
		readdata2();
		Insertdata2();
		 ResultSet rs = getResultSet2();
		  while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2));
			}
	}
	
	
	//Create table-1 in the database
	public void createTable1() throws Exception{
		try{
		conn = newconnection();
			//statement allows to execute the queries
			
			stmt = conn.createStatement();
			String sql = "CREATE TABLE dataset_1" +
						 "(sno INTEGER not NULL AUTO_INCREMENT," + "year INT," + "Air_Temp INT," + "PRIMARY KEY(sno))";
			stmt.executeUpdate(sql);
			//System.out.println("Created Table1 in given database..");
			stmt.close();
		}catch (SQLException e) {
			//System.out.println(e.getMessage());
			}		
		}
	
	//Create table-2 in the database
	public void createTable2() throws Exception{
		try{
		conn = newconnection();
			//statement allows to execute the queries
			
			stmt = conn.createStatement();
			String sql = "CREATE TABLE dataset_2" +
						 "(sno INTEGER not NULL AUTO_INCREMENT," + "year INT," + "Air_Temp INT," + "PRIMARY KEY(sno))";
			stmt.executeUpdate(sql);
			//System.out.println("Created Table2 in given database..");
			stmt.close();
		}catch (SQLException e) {
			//System.out.println(e.getMessage());
			}		
		}


	//Reading data-1 from dataset-1
	void readdata1() throws Exception {
		String line = " ";
		FileWriter fw = null;
		String quality = null;
		fw = new FileWriter("dataset_1.csv");
	    InputStream fileStream = new FileInputStream("1990.gz","1991.gz");
	    InputStream gzipStream = new GZIPInputStream(fileStream);	 
	    Reader decoder = new InputStreamReader(gzipStream, "US-ASCII");
	    try(BufferedReader bf = new BufferedReader(decoder)) {
	    	while((line = bf.readLine())!= null) {
	    	year = Integer.parseInt(line.substring(15, 19));
	    	if (line.charAt(87) == '+') { 
	    			airTemperature = Integer.parseInt(line.substring(88, 92));
	    		} else {
	    			airTemperature = Integer.parseInt(line.substring(87, 92));
	    		}
	    	quality = line.substring(92, 93);
	    	if (airTemperature != (MISSING) && quality.matches("[01459]")) {
	    		    fw.append(String.valueOf(year));
	    			fw.append(COMMA);	    		
	    			fw.append(String.valueOf(airTemperature));
	    			fw.append(SEPARATOR);
	    		}
	    	}
	    	//System.out.println("File written successfully");
	    }catch (IOException e) {
		   e.printStackTrace();
		}
	}
	
	
	//Reading data-2 from dataset-2
	void readdata2() throws Exception {
		String line = " ";
		FileWriter fw = null;
		String quality = null;
		fw = new FileWriter("dataset_2.csv");
		String[] set2 = {"1992.gz","1993.gz"};
		for(String set : set2){
			InputStream fileStream = new FileInputStream(set);
			InputStream gzipStream = new GZIPInputStream(fileStream);	 
			Reader decoder = new InputStreamReader(gzipStream, "US-ASCII");
		
			try (BufferedReader bf = new BufferedReader(decoder)) {
				while((line = bf.readLine())!= null) {
					year = Integer.parseInt(line.substring(15, 19));
					if (line.charAt(87) == '+') { 
						airTemperature = Integer.parseInt(line.substring(88, 92));
					} else {
	    			airTemperature = Integer.parseInt(line.substring(87, 92));
	    		}
	    		quality = line.substring(92, 93);
	    		if (airTemperature != (MISSING) && quality.matches("[01459]")) {
	    		    fw.append(String.valueOf(year));
	    			fw.append(COMMA);	    		
	    			fw.append(String.valueOf(airTemperature));
	    			fw.append(SEPARATOR);
	    		}
	    	}
				//System.out.println("File written successfully");
	    }
		
	catch (IOException e) {
	   e.printStackTrace();
	}
		}
	}

	
	
	
	//Insert Data1 into table dataset_1	
	public void Insertdata1() throws SQLException, ClassNotFoundException{
		stmt = conn.createStatement();
		String sql = "LOAD DATA LOCAL INFILE '" + "./dataset_1.csv" + "' INTO TABLE dataset_1 FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (year,Air_Temp) ";	
		stmt.execute(sql);
		//System.out.println("The values are entered into the tables...");
}
	//Resultset1 from dataset_1
	public static ResultSet getResultSet1() throws Exception {
		ResultSet rs1 = null;
		try {
			stmt = conn.createStatement();
			String sq = "select year,max(Air_Temp) from dataset_1";
			rs1 = stmt.executeQuery(sq);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs1;
	}
	//Insert Data2 into table dataset_2	
			public void Insertdata2() throws SQLException, ClassNotFoundException{
				stmt = conn.createStatement();
				String sql = "LOAD DATA LOCAL INFILE '" + "./dataset_2.csv" + "' INTO TABLE dataset_2 FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (year,Air_Temp) ";	
				stmt.execute(sql);
				//System.out.println("The values are entered into the tables...");
		}
			
			//Resultset 2 of dataset2
			public static ResultSet getResultSet2() throws Exception {
				ResultSet rs1 = null;
				try {
					stmt = conn.createStatement();
					String sq = "select year,max(Air_Temp) from dataset_2 group by year";
					rs1 = stmt.executeQuery(sq);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				return rs1;
			}

		
	public static void main(String[] argv) throws Exception {
		  Max_temperature m_t = new Max_temperature();
		  long startTime = System.currentTimeMillis();
		 Scanner reader = new Scanner(System.in);
		 System.out.println("Select your dataset(1/2):"  );
		 int n = reader.nextInt();
		 switch (n) {
		case 1:
			m_t.dataset1();
			break;
		case 2: 
			m_t.dataset2();

			break;

		default:
			break;
		}
		 long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println((totalTime / 1000) + " " + "seconds");
	  }
		  
