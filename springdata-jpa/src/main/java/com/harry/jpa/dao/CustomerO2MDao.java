package com.harry.jpa.dao;

import com.harry.jpa.entity.Customer;
import com.harry.jpa.entity.CustomerO2M;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface CustomerO2MDao extends JpaRepository<CustomerO2M, Long>, JpaSpecificationExecutor<CustomerO2M> {
}
