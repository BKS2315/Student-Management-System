package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.StudentAddress;

public interface StudentAddressDao extends JpaRepository<StudentAddress, String> {

}
