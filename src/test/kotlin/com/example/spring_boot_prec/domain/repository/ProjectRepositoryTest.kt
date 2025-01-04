package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.constant.SkillType
import com.example.spring_boot_prec.domain.entity.Project
import com.example.spring_boot_prec.domain.entity.ProjectDetail
import com.example.spring_boot_prec.domain.entity.ProjectSkill
import com.example.spring_boot_prec.domain.entity.Skill
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectRepositoryTest(
  @Autowired val projectRepository: ProjectRepository,
  @Autowired val skillRepository: SkillRepository
) {

  val DATA_SIZE = 10

  private fun createProject(n: Int): Project {
    val project = Project(
      name = "Project $n",
      description = "Description $n",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )

    val details = mutableListOf<ProjectDetail>()
    for (i in 1..n) {
      val projectDetail = ProjectDetail(content = "Detail $i", url = null, isActive = true)
      details.add(projectDetail)
    }
    project.addDetails(details)

    val skills = skillRepository.findAll()
    val skillsUsedInProject = skills.subList(0, n)
    for (skill in skillsUsedInProject) {
      val projectSkill = ProjectSkill(project = project, skill = skill)
      project.skills.add(projectSkill)
    }

    return project
  }

  @BeforeAll
  fun beforeAll() {
    println("----- START: Initialize skill data for test -----")
    val skills = mutableListOf<Skill>()
    for (i in 1..DATA_SIZE) {
      val skillTypes = SkillType.values()
      val skill = Skill(name = "Skill $i", type = skillTypes[i % skillTypes.size].name, isActive = true)
      skills.add(skill)
    }
    skillRepository.saveAll(skills)
    println("----- END: Initialize skill data for test -----")

    println("----- START: Initialize project data for test -----")
    val projects = mutableListOf<Project>()
    for (i in 1..DATA_SIZE) {
      val project = createProject(i)
      projects.add(project)
    }
    projectRepository.saveAll(projects)
    println("----- END: Initialize project data for test -----")
  }

  @Test
  fun testFindAll() {
    println("----- Start: Search all data -----")
    val projects = projectRepository.findAll()
    assertThat(projects).hasSize(DATA_SIZE)
    println("----- End: Search all data -----")
  }

  @Test
  fun testFindAllByIsActive() {
    println("----- Start: Search all data by isActive -----")
    val projects = projectRepository.findAllByIsActive(true)
    assertThat(projects).hasSize(DATA_SIZE)
    println("----- End: Search all data by isActive -----")
  }
}