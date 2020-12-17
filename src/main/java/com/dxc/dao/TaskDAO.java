package com.dxc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.model.Task;

public class TaskDAO {

	private Connection con;
	private Statement st;
	private	PreparedStatement pst;
	private	ResultSet rs;
	
	public TaskDAO() {
		super();
		// TODO Auto-generated constructor stub
		con = new DBConnector().getConnection();
	}
	
	Task t=new Task();
	
	public List<Task> getAllTasks(){
		try {
			st=con.createStatement();
			rs=st.executeQuery("Select * from task");
			
			List<Task> tasklist = new ArrayList<Task>();
			while(rs.next()) {
				
				t.setId(rs.getInt(1));
				t.setStartDate(rs.getDate(2));
				t.setDescription(rs.getString(3));
				t.setStatus(rs.getString(4));
				t.setTitle(rs.getString(5));
				
				tasklist.add(t);
				
				}
				return tasklist;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	public Task getTaskById(int id) {
		try {
			pst=con.prepareStatement("Select * from task where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				Task t= new Task();
				t.setId(rs.getInt(1));
				t.setStartDate(rs.getDate(2));
				t.setTitle(rs.getString(3));
				t.setDescription(rs.getString(4));
				t.setStatus(rs.getString(5));
				
				
			}
			return t;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Task addTask(Task task) {
		try {
			
			pst=con.prepareStatement("insert into task values(?,?,?,?,?)");
			pst.setInt(1, task.getId());
			pst.setDate(2, task.getStartDate());
			pst.setString(3, task.getDescription());
			pst.setString(4, task.getStatus());
			pst.setString(5, task.getTitle());
			
			pst.execute();
			return task;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Task updateTask(Task task) {
		try {
			
			pst=con.prepareStatement("Update task set status =? where id=?");
			pst.setString(1, task.getStatus());
			pst.setInt(2, task.getId());
			pst.executeUpdate();
			return task;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Task deleteTask(int id) {
		try {
			pst=con.prepareStatement("Delete from task where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
	

