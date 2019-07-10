package model.services;

import java.util.List;
import model.dao.DAO_Department;
import model.dao.Factory_DAO;
import model.entities.Department;

public class DepartmentService {

	private DAO_Department dao = Factory_DAO.createDepartmentDAO();
	
	public List<Department> findAll() {
		return dao.findAll();
	}

}
