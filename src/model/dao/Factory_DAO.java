package model.dao;

import db.DB;
import model.dao.impl.DepartmentDAO_jdbc;
import model.dao.impl.SellerDAO_jdbc;

public class Factory_DAO {
	
	public static DAO_Seller createSellerDAO() {
		return new SellerDAO_jdbc(DB.getConnection());
	}
	public static DAO_Department createDepartmentDAO() {
		return new DepartmentDAO_jdbc(DB.getConnection());
	}
}