package com.example.spring_boot_prec.admin.data

abstract class FormElementDTO(
  val name: String,
  val size: Int,
  val type: String
)

class TextFormElemetDTO(
  name: String,
  size: Int
) : FormElementDTO(name, size, "text")

class DateFormElementDTO(
  name: String,
  size: Int
) : FormElementDTO(name, size, "date")

class SelectFormElementDTO(
  name: String,
  size: Int,
  options: List<Any>
) : FormElementDTO(name, size, "select") {
  val options: List<Any> = options
}