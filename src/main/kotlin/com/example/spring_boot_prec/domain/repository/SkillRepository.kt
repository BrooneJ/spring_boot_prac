package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>