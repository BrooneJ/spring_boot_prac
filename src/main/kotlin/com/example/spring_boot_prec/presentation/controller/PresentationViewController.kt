package com.example.spring_boot_prec.presentation.controller

import com.example.spring_boot_prec.domain.constant.SkillType
import com.example.spring_boot_prec.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
  private val presentationService: PresentationService
) {

  @GetMapping("/")
  fun index(model: Model): String {

    val introductions = presentationService.getIntroductions()
    model.addAttribute("introductions", introductions)

    val links = presentationService.getLinks()
    model.addAttribute("links", links)

    return "presentation/index"
  }

  @GetMapping("/resume")
  fun resume(model: Model): String {
    val resume = presentationService.getResume()
    model.addAttribute("resume", resume)
    model.addAttribute("skillType", SkillType.values())

    return "presentation/resume"
  }

  @GetMapping("/projects")
  fun projects(model: Model): String {
    val projects = presentationService.getProjects()
    model.addAttribute("projects", projects)

    return "presentation/projects"
  }
}