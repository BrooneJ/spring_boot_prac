package com.example.spring_boot_prec.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
  title: String,
  description: String,
  achievementDate: LocalDate?,
  host: String,
  isActive: Boolean
) : BaseEntity() {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "achievement_id")
  var id: Long? = null

  var title: String = title

  var description: String = description

  var achievement: LocalDate? = achievementDate

  var host: String = host

  var isActive: Boolean = isActive
}