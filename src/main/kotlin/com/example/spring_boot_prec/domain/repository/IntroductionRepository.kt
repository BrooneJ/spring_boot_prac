package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {

  fun findAllByIsActive(isActive: Boolean): List<Introduction>
  
}