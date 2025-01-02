package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>