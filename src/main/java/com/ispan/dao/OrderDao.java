package com.ispan.dao;
//package dao.impl;
//// DAO: Database Access Object
//
//// 專責與Dept Table之新增,修改,刪除與查詢
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.DButil;
//import dao.OrderDaoFace;
//import mybeans.OrderBean;
//
//public class OrderDao {
//
//	private static final String SELECT_ALL_SQL = "SELECT order_id,CONVERT(varchar(16),order_date,120) order_date,order_category,user_no,order_total,"
//											   + "order_discount,coupon_id,order_status,order_paystatus FROM ORDERS";
//	private static final String SELECT_ONE_SQL = "SELECT order_id,CONVERT(varchar(16),order_date,120) order_date,order_category,user_no,order_total,"
//			   + "order_discount,coupon_id,order_status,order_paystatus FROM orders WHERE order_id = ? ";
//	private static final String INSERT_SQL = "INSERT INTO ORDERS VALUES (GETDATE(),?,?,?,?,?,?,?)";
//
//	private static final String UPDATE_SQL = "UPDATE orders SET order_category= ? , user_no= ?, order_total = ?, order_discount = ?, coupon_id =  ?, order_status = ?, order_paystatus = ?  WHERE order_id = ?;";
//	private static final String DELETE_SQL = "DELETE orders WHERE order_id = ?";
//
//	 
//	// 建構子
//	public OrderDao() {
//		
//	}
//
//	
//	public List<OrderBean> selectAll() {
//		
//		List<OrderBean> orderBeans = new ArrayList<OrderBean>();
//    try ( 	Connection conn = DButil.getDataSource().getConnection();
//    		PreparedStatement ps=conn.prepareStatement(SELECT_ALL_SQL);
//    		ResultSet rs = ps.executeQuery()){
//  	  	 	
//  	  	 	while (rs.next()) {
//  	  	 	OrderBean orderBean = new OrderBean();
//  	  	 	orderBean.setOrderId(rs.getInt("order_id"));
//  	  	 	orderBean.setOrderDate(rs.getString("order_date"));
//  	  	 	orderBean.setOrderCategory(rs.getString("order_category"));
//  	  	 	orderBean.setUserNo(rs.getInt("user_no"));
//  	  	 	orderBean.setOrderTotal(rs.getInt("order_total"));
//  	  	 	orderBean.setOrderDiscount(rs.getInt("order_discount"));
//  	  	 	orderBean.setCouponId(rs.getInt("coupon_id"));
//  	  	 	orderBean.setOrderStatus(rs.getInt("order_status"));
//  	  	 	orderBean.setOrderPayStatus(rs.getInt("order_paystatus"));
//  	  	 	
//  	  	 	orderBeans.add(orderBean);
//			}
//  
//	    
//	  } catch (SQLException e) {
//	    e.printStackTrace();
//		 
//	  }
//    return orderBeans;
//  }
//
//	
//	public boolean insert(OrderBean orderBean) {
//		boolean rowinerted = false;	
//		try ( 	Connection conn = DButil.getDataSource().getConnection();
//	    		PreparedStatement ps=conn.prepareStatement(INSERT_SQL);
//	    		 ){
//			
////				ps.setTimestamp(1, orderBean.getOrderDatePlus());
//				ps.setString(1, orderBean.getOrderCategory());
//				ps.setInt(2, orderBean.getUserNo());
//				ps.setInt(3, orderBean.getOrderTotal());
//				ps.setInt(4, orderBean.getOrderDiscount());
//				ps.setInt(5, orderBean.getCouponId());
//				ps.setInt(6, orderBean.getOrderStatus());
//				ps.setInt(7, orderBean.getOrderPayStatus());
//				rowinerted =ps.executeUpdate() > 0;
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rowinerted;
//		
//	}
//	
//	public OrderBean selectOne(int orderId) {
//		
//		OrderBean orderBean = new OrderBean();
//		 try ( 	Connection conn = DButil.getDataSource().getConnection();
//		    		PreparedStatement ps=conn.prepareStatement(SELECT_ONE_SQL);
//		    		){
//			 ps.setInt(1, orderId);
//			 ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//	  	  	 	orderBean.setOrderId(rs.getInt("order_id"));
//	  	  	 	orderBean.setOrderDate(rs.getString("order_date"));
//	  	  	 	orderBean.setOrderCategory(rs.getString("order_category"));
//	  	  	 	orderBean.setUserNo(rs.getInt("user_no"));
//	  	  	 	orderBean.setOrderTotal(rs.getInt("order_total"));
//	  	  	 	orderBean.setOrderDiscount(rs.getInt("order_discount"));
//	  	  	 	orderBean.setCouponId(rs.getInt("coupon_id"));
//	  	  	 	orderBean.setOrderStatus(rs.getInt("order_status"));
//	  	  	 	orderBean.setOrderPayStatus(rs.getInt("order_paystatus"));
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return orderBean;
//	}
//	public boolean update(OrderBean orderBean) {
//		boolean rowupdated = false;
//		try ( 	Connection conn = DButil.getDataSource().getConnection();
//	    		PreparedStatement ps=conn.prepareStatement(UPDATE_SQL);
//	    		 ){
//			ps.setString(1,orderBean.getOrderCategory());
//			ps.setInt(2,orderBean.getUserNo());
//			ps.setInt(3,orderBean.getOrderTotal());
//			ps.setInt(4,orderBean.getOrderDiscount());
//			ps.setInt(5,orderBean.getCouponId());
//			ps.setInt(6,orderBean.getOrderStatus());
//			ps.setInt(7,orderBean.getOrderPayStatus());
//			ps.setInt(8,orderBean.getOrderId());
//			
//			rowupdated = ps.executeUpdate() > 0;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//	}
//		return rowupdated;
//	}
//	public boolean delete(int orderid)  {
//        boolean rowDeleted = false;
//        try (	Connection conn = DButil.getDataSource().getConnection();
//	    		PreparedStatement ps=conn.prepareStatement(DELETE_SQL)) {
//        	
//            		ps.setInt(1, orderid);
//            		rowDeleted = ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//			e.printStackTrace();
//        }   return rowDeleted;
//    }
//
//}
