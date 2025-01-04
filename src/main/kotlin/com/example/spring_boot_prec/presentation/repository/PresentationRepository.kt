package com.example.spring_boot_prec.presentation.repository

import com.example.spring_boot_prec.domain.entity.*
import com.example.spring_boot_prec.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
  private val achievementRepository: AchievementRepository,
  private val experienceRepository: ExperienceRepository,
  private val introductionRepository: IntroductionRepository,
  private val linkRepository: LinkRepository,
  private val projectRepository: ProjectRepository,
  private val skillRepository: SkillRepository,
) {

  fun getActiveAchievements(): List<Achievement> {
    return achievementRepository.findAllByIsActive(true)
  }

  fun getActiveExperiences(): List<Experience> {
    return experienceRepository.findAllByIsActive(true)
  }

  fun getActiveIntroductions(): List<Introduction> {
    return introductionRepository.findAllByIsActive(true)
  }

  fun getActiveLinks(): List<Link> {
    return linkRepository.findAllByIsActive(true)
  }

  fun getActiveProjects(): List<Project> {
    return projectRepository.findAllByIsActive(true)
  }

  fun getActiveSkills(): List<Skill> {
    return skillRepository.findAllByIsActive(true)
  }
}
