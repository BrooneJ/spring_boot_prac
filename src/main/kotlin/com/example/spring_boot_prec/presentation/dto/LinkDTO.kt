package com.example.spring_boot_prec.presentation.dto

import com.example.spring_boot_prec.domain.entity.Link

data class LinkDTO(
  val name: String,
  val content: String
) {

  constructor(link: Link) : this(
    name = link.name.lowercase(),
    content = link.content
  )
}