package io.dumerz.springjpadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dumerz.springjpadata.model.User_Type;

public interface UserTypeRepository extends JpaRepository<User_Type, Long> { 
}
