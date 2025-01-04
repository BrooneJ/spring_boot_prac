package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Experience
import com.example.spring_boot_prec.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
  @Autowired val experienceRepository: ExperienceRepository
) {

  val DATA_SIZE = 10

  private fun createExperience(n: Int): Experience {
    val experience = Experience(
      title = "Experience $n",
      description = "Description $n",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )

    val details = mutableListOf<ExperienceDetail>()
    for (i in 1..n) {
      val experienceDetail = ExperienceDetail(content = "Detail $i", isActive = true)
      details.add(experienceDetail)
    }
    experience.addDetails(details)

    return experience
  }

  @BeforeAll
  fun beforeAll() {
    println("----- Start: Search data before initialization -----")
    val beforeInitialize = experienceRepository.findAll()
    assertThat(beforeInitialize).hasSize(0)
    println("----- End: Search data before initialization -----")

    println("----- Start: Initialize test data -----")
    val experiences = mutableListOf<Experience>()
    for (i in 1..DATA_SIZE) {
      val experience = createExperience(i)
      experiences.add(experience)
    }
    experienceRepository.saveAll(experiences)
    println("----- End: Initialize test data -----")
  }

  @Test
  fun testFindAll() {
    println("----- Start: Search all data -----")
    val experiences = experienceRepository.findAll()
    assertThat(experiences).hasSize(DATA_SIZE)
    println("----- End: Search all data -----")
  }

  @Test
  fun testFindAllByIsActive() {
    println("----- Start: Search all data by isActive -----")
    val experiences = experienceRepository.findAllByIsActive(true)
    assertThat(experiences).hasSize(DATA_SIZE)
    println("----- End: Search all data by isActive -----")
  }
}