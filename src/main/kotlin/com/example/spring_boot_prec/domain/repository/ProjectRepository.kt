package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>