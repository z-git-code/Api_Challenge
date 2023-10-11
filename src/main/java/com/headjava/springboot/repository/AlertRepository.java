package com.headjava.springboot.repository;

import com.headjava.springboot.dao.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, String> {
}
