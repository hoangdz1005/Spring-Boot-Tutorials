package com.hoangdz.securitysection4.repository;

import com.hoangdz.securitysection4.model.ERole;
import com.hoangdz.securitysection4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
