package com.harry.jpa.dao;

import com.harry.jpa.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDao extends JpaRepository<SysRole, Long>, JpaSpecificationExecutor<SysRole> {
}
