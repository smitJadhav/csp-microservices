package com.csp.authorization.repository.user;

import com.csp.authorization.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
