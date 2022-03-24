package org.diembo.dao;

import java.util.Optional;

import org.diembo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	public Optional<Person> findByLogin(String login);
}
