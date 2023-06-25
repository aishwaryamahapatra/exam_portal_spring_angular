package com.exam.ExamServer.repo;

import com.exam.ExamServer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
