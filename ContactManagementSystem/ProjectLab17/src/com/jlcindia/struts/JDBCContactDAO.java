package com.jlcindia.struts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCContactDAO implements ContactDAO{
	
	@Override
	public int addContact(ContactTO cto) {
		Connection con=null;
		PreparedStatement ps=null;
		int x=0;
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into jlccontacts values(?,?,?,?,?,?)");
			ps.setString(1,getNextContactId());
			ps.setString(2,cto.getFname());
			ps.setString(3,cto.getLname());
			ps.setString(4,cto.getEmail());
			ps.setString(5,cto.getPhone());
			ps.setString(6,cto.getStatus());
			x=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(ps, con);
		}
		return x;
	}

	@Override
	public int updateContact(ContactTO cto) {
		Connection con=null;
		PreparedStatement ps=null;
		int x=0;
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("update jlccontacts set fname=?,lname=?,email=?,phone=?,status=? where contactId=?");
			ps.setString(1, cto.getFname());
			ps.setString(2, cto.getLname());
			ps.setString(3, cto.getEmail());
			ps.setString(4, cto.getPhone());
			ps.setString(5, cto.getStatus());
			ps.setString(6, cto.getContactId());
			x=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(ps, con);
		}
		return x;
	}
	
	
	@Override
	public ContactTO getContactByEmail(String email) {
		ContactTO cto=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select * from jlccontacts where email=?");
			ps.setString(1,email);
			rs=ps.executeQuery();
			if(rs.next()){
				cto=new ContactTO();
				cto.setContactId(rs.getString(1));
				cto.setFname(rs.getString(2));
				cto.setLname(rs.getString(3));
				cto.setEmail(rs.getString(4));
				cto.setPhone(rs.getString(5));
				cto.setStatus(rs.getString(6));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(rs, ps, con);
		}
		return cto;
	}
	
	
	@Override
	public List<ContactTO> getAllContacts(int start, int total) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<ContactTO> list=new ArrayList<ContactTO>();
		
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select * from jlccontacts limit ?,?");
			ps.setInt(1,start);
			ps.setInt(2,total);
			rs=ps.executeQuery();
			while(rs.next()){
				ContactTO cto=new ContactTO();
				cto.setContactId(rs.getString(1));
				cto.setFname(rs.getString(2));
				cto.setLname(rs.getString(3));
				cto.setEmail(rs.getString(4));
				cto.setPhone(rs.getString(5));
				cto.setStatus(rs.getString(6));
				list.add(cto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(rs, ps, con);
		}
		return list;
	}
	
	
	private String getNextContactId(){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String nextcid="C-00001";//C-00008
		
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select max(contactId) from jlccontacts");
			rs=ps.executeQuery();
			if(rs.next()){
				String id=rs.getString(1);
				int x=Integer.parseInt(id.substring(2));
				x=x+1;
				if(x<=9){
					nextcid="C-0000"+x;
				}else if(x<=99){
					nextcid="C-000"+x;
				}else if(x<=999){
					nextcid="C-00"+x;
				}else if(x<=9999){
					nextcid="C-0"+x;
				}else{
					nextcid="C-"+x;
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(rs, ps, con);
		}
		return nextcid;
		
	}
	
	@Override
	public int getTotalNumberOfRecords() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int nor=0;
		
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select count(*) from jlccontacts");
			rs=ps.executeQuery();
			if(rs.next()){
				nor=rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(rs, ps, con);
		}
		return nor;
	}
	
	@Override
	public int deleteContact(String cid){
		Connection con=null;
		PreparedStatement ps=null;
		int x=0;
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement("delete from jlccontacts where contactId=?");
			ps.setString(1,cid);
			x=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.cleanup(ps, con);
		}
		return x;
	}
}




