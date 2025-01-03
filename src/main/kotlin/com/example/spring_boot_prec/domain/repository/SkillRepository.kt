package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.constant.SkillType
import com.example.spring_boot_prec.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long> {

  fun findAllByIsActive(isActive: Boolean): List<Skill>

  // select * from skill where lower(name) = lower(:name) and skill_type = :type
  fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>

}