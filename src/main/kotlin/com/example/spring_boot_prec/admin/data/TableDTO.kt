package com.example.spring_boot_prec.admin.data

class TableDTO(
  val name: String,
  val columns: List<String>,
  val records: List<List<String>>
)