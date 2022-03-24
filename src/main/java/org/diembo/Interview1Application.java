package org.diembo;

import java.util.Date;
import java.util.Optional;

import org.diembo.dao.ProfileRepository;
import org.diembo.dao.QuestionnaireRepository;
import org.diembo.dao.RolePersonRepository;
import org.diembo.entities.AppRole;
import org.diembo.entities.Person;
import org.diembo.entities.Profile;
import org.diembo.entities.Questionnaire;
import org.diembo.entities.RolePerson;
import org.diembo.service.api.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.diembo.dao","org.diembo.config"})
public class Interview1Application {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Interview1Application.class, args);
		QuestionnaireRepository questionnaireRepository = context.getBean(QuestionnaireRepository.class);
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setCode("code 1");
		questionnaire.setDescription("description 1");
		questionnaire.setDontShowOverrideDate(new Date());
		questionnaire.setDontShowOverridePeriod(12);
		questionnaire.setLastUpdate(new Date());
		questionnaire.setUserCode("user code");
		questionnaire.setVersion(2l);
		questionnaireRepository.save(questionnaire);
		
		questionnaire = new Questionnaire();
		questionnaire.setCode("code 2");
		questionnaire.setDescription("description 2");
		questionnaire.setDontShowOverrideDate(new Date());
		questionnaire.setDontShowOverridePeriod(12);
		questionnaire.setLastUpdate(new Date());
		questionnaire.setUserCode("user code");
		questionnaire.setVersion(2l);
		questionnaireRepository.save(questionnaire);
		
		Person person = new Person();
		person.setLastUpdate(new Date());
		person.setUserCode("user code");
		person.setVersion(2l);
		person.setFirstName("Papa");
		person.setLastName("Diouf");
		person.setActive(true);
		person.setPassword("1234");
		person.setLogin("admin");
		AccountService accountService = context.getBean(AccountService.class);
		accountService.savePerson(person);
		
		Profile profile = new Profile();
		profile.setLastUpdate(new Date());
		profile.setUserCode("user code");
		profile.setVersion(2l);
		profile.setName("ADMINISTRATEUR");
		profile.setProfileCode("Administrateur");
		ProfileRepository profileRepository = context.getBean(ProfileRepository.class);
		profileRepository.save(profile);
		
		AppRole appRole = new AppRole();
		appRole.setLastUpdate(new Date());
		appRole.setUserCode("user code");
		appRole.setVersion(2l);
		appRole.setName("ADMIN");
		appRole.setRoleCode("admin");
		appRole.setProfile(profile);
		accountService.saveRole(appRole);
		
		accountService.addPersonToRole(person, appRole);
		
		profile = new Profile();
		profile.setLastUpdate(new Date());
		profile.setUserCode("user code");
		profile.setVersion(2l);
		profile.setName("UTILISATEUR");
		profile.setProfileCode("utilisateur");
		profileRepository.save(profile);
		
		appRole = new AppRole();
		appRole.setLastUpdate(new Date());
		appRole.setUserCode("user code");
		appRole.setVersion(2l);
		appRole.setName("USER");
		appRole.setRoleCode("user");
		appRole.setProfile(profile);
		accountService.saveRole(appRole);
		
		person = new Person();
		person.setLastUpdate(new Date());
		person.setUserCode("user code");
		person.setVersion(2l);
		person.setFirstName("Papa");
		person.setLastName("Diouf");
		person.setActive(true);
		person.setPassword("1234");
		person.setLogin("user");
		accountService.savePerson(person);
		
		accountService.addPersonToRole(person, appRole);
		
		Optional<Person> p = accountService.getPersonByLogin("admin");
		Optional<AppRole> r = accountService.getRoleByCode("user");
		
		accountService.addPersonToRole(p.get(), r.get());
		RolePersonRepository rolePersonRepository = context.getBean(RolePersonRepository.class);
		RolePerson rolePerson = rolePersonRepository.findByPersonAndAppRole(person, appRole);
		System.err.println(rolePerson.getPerson().getLogin());
		System.err.println(rolePerson.getPerson().getPassword());
		
	}
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
