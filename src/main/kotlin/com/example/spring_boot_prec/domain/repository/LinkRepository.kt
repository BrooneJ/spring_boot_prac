package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>