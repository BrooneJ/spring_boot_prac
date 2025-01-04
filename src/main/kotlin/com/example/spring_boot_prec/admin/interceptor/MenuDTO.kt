package com.example.spring_boot_prec.admin.interceptor

data class MenuDTO(
  val name: String,
  val pages: List<PageDTO>
)