package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<EmployeeEntity, Integer> {

	public default String validate(int id) {
		
		Optional<EmployeeEntity> op= findById(id);
		if(!op.isEmpty()) {
			if(op.get()!=null) return "Success";
		}
		return "Failure";
		
	/*	SessionFactory sf ;
		
		EntityManager entt = sf.createEntityManager();
		Query q=entt.createQuery("select employee.id , employee.name from EmployeeEntity employee where employee.id=?1");
		q.setParameter(1,id);
		q.*/
	}
	
}
