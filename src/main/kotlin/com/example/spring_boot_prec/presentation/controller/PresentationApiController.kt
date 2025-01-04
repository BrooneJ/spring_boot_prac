package com.example.spring_boot_prec.presentation.controller

import com.example.spring_boot_prec.presentation.dto.IntroductionDTO
import com.example.spring_boot_prec.presentation.dto.LinkDTO
import com.example.spring_boot_prec.presentation.dto.ProjectDTO
import com.example.spring_boot_prec.presentation.dto.ResumeDTO
import com.example.spring_boot_prec.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
  private val presentationService: PresentationService
) {

  @GetMapping("/v1/introductions")
  fun getIntroductions(): List<IntroductionDTO> {
    return presentationService.getIntroductions()
  }

  @GetMapping("/v1/links")
  fun getLinks(): List<LinkDTO> {
    return presentationService.getLinks()
  }

  @GetMapping("/v1/resume")
  fun getResume(): ResumeDTO {
    return presentationService.getResume()
  }

  @GetMapping("/v1/projects")
  fun getProject(): List<ProjectDTO> {
    return presentationService.getProjects()
  }
}