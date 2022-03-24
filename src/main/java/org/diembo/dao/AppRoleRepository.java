package org.diembo.dao;

import java.util.Optional;

import org.diembo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long>{

	public Optional<AppRole> findByRoleCode(String roleCode);
}
