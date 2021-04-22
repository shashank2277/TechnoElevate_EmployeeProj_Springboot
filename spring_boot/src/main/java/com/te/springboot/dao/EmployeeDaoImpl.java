package com.te.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springboot.Beans.EmployeeBean;

@Repository
public class EmployeeDaoImpl  implements EmployeeDao {

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);

		return bean;
	}

	@Override
	public boolean isdelete(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<EmployeeBean> getAllData() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String query = " from EmployeeBean";
		Query data = manager.createQuery(query);

		List<EmployeeBean> list = data.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;

		}
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		try {
			

			transaction.begin();
			
			manager.persist(bean);

			boolean isadded = false;

			if (bean!=null) {
				isadded = true;
				transaction.commit();
				return isadded;
			} else {
				isadded = false;
				return isadded;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();

			EmployeeBean data = manager.find(EmployeeBean.class, bean.getId());
			if (bean.getName() != null && bean.getName() != "") {
				data.setName(bean.getName());
			}
			if (bean.getDateofbirth() != null) {
				data.setDateofbirth(bean.getDateofbirth());
			}
			if (bean.getPassword() != null && bean.getPassword() != "") {
				data.setPassword(bean.getPassword());
			}
				transaction.commit();
				return true;
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}
		

}
