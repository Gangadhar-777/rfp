package com.my3tech.rfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my3tech.rfp.entity.Checklist;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}
