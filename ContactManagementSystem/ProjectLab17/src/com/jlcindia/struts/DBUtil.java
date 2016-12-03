package com.jlcindia.struts;
import java.sql.*;
public class DBUtil{
private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
private static final String URL="jdbc:mysql://localhost:3306/yogdb";
private static final String USERNAME="root";
private static final String PASSWORD="root";
static{
try{
Class.forName(DRIVER_CLASS);
}catch(ClassNotFoundException e){
System.out.println("Error in loading the class");
e.printStackTrace();
}
}

public static Connection getConnection(){
Connection con=null;
try{
con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
}catch(Exception e){
System.out.println("Error in creating the connection");
e.printStackTrace();
}
return con;
}
public static void cleanup(ResultSet rs,Statement st,Connection con){
try{
if(rs!=null)
rs.close();
if(st!=null)
st.close();
if(con!=null)
con.close();
}catch(SQLException e){
System.out.println("Error in closing the resource");
e.printStackTrace();
}
}

public static void cleanup(Statement st,Connection con){
	try{
	
	if(st!=null)
	st.close();
	if(con!=null)
	con.close();
	}catch(SQLException e){
	System.out.println("Error in closing the resource");
	e.printStackTrace();
	}
	}
}
