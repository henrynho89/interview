package org.diembo.service.api;

import java.util.List;
import java.util.Optional;

import org.diembo.entities.AppRole;
import org.diembo.entities.Person;
import org.diembo.entities.RolePerson;

public interface AccountService {

	public Person savePerson(Person person);
	public AppRole saveRole(AppRole appRole);
	public void addPersonToRole(Person person, AppRole appRole);
	public Optional<Person> getPersons(Person person);
	public Optional<AppRole> getRoles(AppRole appRole);
	public Optional<Person> getPersonByLogin(String login);
	public Optional<AppRole> getRoleByCode(String code);
	public RolePerson getInfo(Person person, AppRole appRole);
	public List<RolePerson> getRolesPerson(Person person);
}
