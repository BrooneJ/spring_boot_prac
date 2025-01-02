package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>