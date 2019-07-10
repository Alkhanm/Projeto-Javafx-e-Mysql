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
	
	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) { // Caso o id esteja nulo, significa que o metodo irá adicionar um novo objeto
			dao.insert(obj);
		} else { // Se já tiver um id é pq o objeto já existe, e então ele será alterado.
			dao.update(obj);
		}
	}
	

}
