package com.example.spring_boot_prec.presentation.dto

import com.example.spring_boot_prec.domain.entity.Skill

data class SkillDTO(
  val name: String,
  val type: String
) {

  constructor(skill: Skill) : this(
    name = skill.name,
    type = skill.type.name
  )
}