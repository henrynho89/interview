package org.diembo.dao;

import java.util.List;

import org.diembo.entities.AppRole;
import org.diembo.entities.Person;
import org.diembo.entities.RolePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePersonRepository extends JpaRepository<RolePerson, Long>{
	public RolePerson findByPersonAndAppRole(Person person, AppRole appRole);
	public List<RolePerson> findByPerson(Person person);
}
