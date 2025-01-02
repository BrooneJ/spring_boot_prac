package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long>