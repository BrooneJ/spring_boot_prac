package com.example.spring_boot_prec.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiResponse<T>(status: HttpStatus) : ResponseEntity<T>(status) {

  companion object {
    fun successCreate(): ResponseEntity<Any> {
      return ok("Created")
    }

    fun successUpdated(): ResponseEntity<Any> {
      return ok("Updated")
    }

    fun successDeleted(): ResponseEntity<Any> {
      return ok("Deleted")
    }
  }
}