package com.hoangdz.securitysection2.repository;

import com.hoangdz.securitysection2.model.ERole;
import com.hoangdz.securitysection2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
