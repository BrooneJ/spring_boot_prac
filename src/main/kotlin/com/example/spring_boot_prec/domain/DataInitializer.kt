package com.example.spring_boot_prec.domain

import com.example.spring_boot_prec.domain.constant.SkillType
import com.example.spring_boot_prec.domain.entity.*
import com.example.spring_boot_prec.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
  private val achievementRepository: AchievementRepository,
  private val introductionRepository: IntroductionRepository,
  private val linkRepository: LinkRepository,
  private val skillRepository: SkillRepository,
  private val projectRepository: ProjectRepository,
  private val experienceRepository: ExperienceRepository
) {

  @PostConstruct
  fun initializeData() {

    println("Application is initializing test data...")

    val achievements = mutableListOf<Achievement>(
      Achievement(
        title = "Achievement 1",
        description = "Description 1",
        host = "Host 1",
        achievementDate = LocalDate.of(2025, 1, 1),
        isActive = true
      ),
      Achievement(
        title = "Achievement 2",
        description = "Description 2",
        host = "Host 2",
        achievementDate = LocalDate.of(2025, 2, 2),
        isActive = true
      ),
    )
    achievementRepository.saveAll(achievements)

    val introductions = mutableListOf<Introduction>(
      Introduction(content = "Introduction 1", isActive = true),
      Introduction(content = "Introduction 2", isActive = true),
      Introduction(content = "Introduction 3", isActive = true)
    )
    introductionRepository.saveAll(introductions)

    val links = mutableListOf<Link>(
      Link(name = "Link 1", content = "https://www.example.com", isActive = true),
      Link(name = "Link 2", content = "https://www.example.com", isActive = true),
      Link(name = "Link 3", content = "https://www.example.com", isActive = true)
    )
    linkRepository.saveAll(links)

    val experience1 = Experience(
      title = "Experience 1",
      description = "Description 1",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )
    experience1.addDetails(
      mutableListOf(
        ExperienceDetail(content = "Detail 1", isActive = true),
        ExperienceDetail(content = "Detail 2", isActive = true)
      )
    )

    val experience2 = Experience(
      title = "Experience 2",
      description = "Description 2",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )
    experience2.addDetails(
      mutableListOf(
        ExperienceDetail(content = "Detail 1", isActive = true),
        ExperienceDetail(content = "Detail 2", isActive = true)
      )
    )
    experienceRepository.saveAll(mutableListOf(experience1, experience2))

    val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
    val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
    val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
    val react = Skill(name = "React", type = SkillType.FRAMEWORK.name, isActive = true)
    val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
    val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
    skillRepository.saveAll(mutableListOf(java, kotlin, spring, react, mysql, kafka))

    val project1 = Project(
      name = "Project 1",
      description = "Description 1",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )
    project1.addDetails(
      mutableListOf(
        ProjectDetail(content = "Detail 1", url = null, isActive = true),
        ProjectDetail(content = "Detail 2", url = null, isActive = true)
      )
    )
    project1.skills.addAll(
      mutableListOf(
        ProjectSkill(project = project1, skill = java),
        ProjectSkill(project = project1, skill = spring),
        ProjectSkill(project = project1, skill = react),
        ProjectSkill(project = project1, skill = mysql),
      )
    )
    val project2 = Project(
      name = "Project 2",
      description = "Description 2",
      startYear = 2025,
      startMonth = 1,
      endYear = 2025,
      endMonth = 2,
      isActive = true
    )
    project2.addDetails(
      mutableListOf(
        ProjectDetail(content = "Detail 1", url = null, isActive = true),
        ProjectDetail(content = "Detail 2", url = null, isActive = true),
        ProjectDetail(content = "Detail 3", url = "https://github.com/BrooneJ", isActive = true)
      )
    )
    project2.skills.addAll(
      mutableListOf(
        ProjectSkill(project = project2, skill = kotlin),
        ProjectSkill(project = project2, skill = spring),
        ProjectSkill(project = project2, skill = kafka),
      )
    )
    projectRepository.saveAll(mutableListOf(project1, project2))
  }
}