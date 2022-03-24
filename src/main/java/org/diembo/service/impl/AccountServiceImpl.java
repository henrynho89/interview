package org.diembo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.diembo.dao.AppRoleRepository;
import org.diembo.dao.PersonRepository;
import org.diembo.dao.RolePersonRepository;
import org.diembo.entities.AppRole;
import org.diembo.entities.Person;
import org.diembo.entities.RolePerson;
import org.diembo.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private RolePersonRepository rolePersonRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		String hash = bCryptPasswordEncoder.encode(person.getPassword());
		person.setPassword(hash);
		return personRepository.save(person);
	}
	@Override
	public AppRole saveRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}
	@Override
	public void addPersonToRole(Person person, AppRole appRole) {
		RolePerson rolePerson = new RolePerson();
		rolePerson.setAppRole(appRole);
		rolePerson.setPerson(person);
		rolePerson.setLastUpdate(new Date());
		rolePerson.setUserCode("user code");
		rolePerson.setVersion(person.getVersion());
		String code = person.getLogin()+"_"+appRole.getRoleCode().toUpperCase();
		rolePerson.setCode(code);
		rolePersonRepository.save(rolePerson);
	}
	@Override
	public Optional<Person> getPersons(Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<AppRole> getRoles(AppRole appRole) {
		return null;
	}
	@Override
	public Optional<Person> getPersonByLogin(String login) {
		// TODO Auto-generated method stub
		return personRepository.findByLogin(login);
	}
	@Override
	public Optional<AppRole> getRoleByCode(String code) {
		// TODO Auto-generated method stub
		return appRoleRepository.findByRoleCode(code);
	}
	@Override
	public RolePerson getInfo(Person person, AppRole appRole) {
		RolePerson rolePerson = rolePersonRepository.findByPersonAndAppRole(person, appRole);
		return null;
	}
	@Override
	public List<RolePerson> getRolesPerson(Person person) {
		// TODO Auto-generated method stub
		return rolePersonRepository.findByPerson(person);
	}

	
}
