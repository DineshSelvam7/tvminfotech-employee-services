package com.tvmemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tvmemp.model.TvmEmployee;

public interface TvmEmployeeRepository extends JpaRepository<TvmEmployee, Integer> {

	@Query(value = "SELECT * from tvmemployee n WHERE n.employeesalary>:employeesalary", nativeQuery = true)
	public List<TvmEmployee> getEmployeeBySalary(Long employeesalary);

	@Query(value = "SELECT * from tvmemployee n WHERE n.employeefirstname=:employeefirstname", nativeQuery = true)
	public List<TvmEmployee> getEmployeefirstName(String employeefirstname);

	@Query(value = "SELECT * from tvmemployee n WHERE n.employeelastname=:employeelastname", nativeQuery = true)
	public List<TvmEmployee> getEmployeeBylastName(String employeelastname);

	// Getting Employee details using passed out year

	@Query(value = "SELECT t.assestid,t.employeeesalary,t.employeeemail,t.employeefirstname,t.employeelastname,t.employeephone,e.education_id, e.percentage, e.university, e.yearof_passout "
			+ "FROM tvmemployee t LEFT JOIN employeeeducation e " + "ON t.employeeid=e.employeeid "
			+ "WHERE e.yearof_passout=:yearofPassout", nativeQuery = true)

	public List<Object[]> getEmployeeByPassout(String yearofPassout);

	// Getting EmployeeAssest using employee id 
	
	@Query(value = "SELECT te.employeeid, te.employeeemail, te.employeefirstname, te.employeelastname, te.employeephone, te.employeeesalary, "
			+ "ea.assestid, ea.charger, ea.headphone, ea.laptop FROM tvmemployee te LEFT JOIN empassest ea ON te.assestid=ea.assestid "
			+ "WHERE te.employeeid=:employeeId", nativeQuery = true)
    public List<TvmEmployee> findByAssestId(Integer employeeId);
	
	@Query(value = "SELECT te.employeeid, te.employeeemail, te.employeefirstname, te.employeelastname, te.employeephone, te.employeeesalary, "
			+ "ea.assestid, ea.charger, ea.headphone, ea.laptop FROM tvmemployee te LEFT JOIN empassest ea ON te.assestid=ea.assestid "
			+ "WHERE ea.laptop=:laptop", nativeQuery = true)
    public List<TvmEmployee> findByAssestlaptop(String laptop);

}
