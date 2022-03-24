package org.diembo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.diembo.entities.AppRole;
import org.diembo.entities.Person;
import org.diembo.entities.RolePerson;
import org.diembo.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> person = accountService.getPersonByLogin(username);
		if(!person.isPresent()) throw new UsernameNotFoundException(username);
		System.err.println(person.get().getPassword());
		List<RolePerson> rolePersons = accountService.getRolesPerson(person.get());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<AppRole> roles = new ArrayList<AppRole>();
		for (RolePerson rolePerson : rolePersons) {
			roles.add(rolePerson.getAppRole());
		}
		roles.forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
			System.err.println("ROLE_"+role.getRoleCode());
		});
		return new User(person.get().getLogin(),person.get().getPassword(),authorities);
	}

}
