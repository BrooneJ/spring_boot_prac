package com.example.spring_boot_prec.presentation.dto

import com.example.spring_boot_prec.domain.entity.ProjectDetail

class ProjectDetailDTO(
  val content: String,
  val url: String?
) {

  constructor(projectDetail: ProjectDetail) : this(
    content = projectDetail.content,
    url = projectDetail.url
  )
}