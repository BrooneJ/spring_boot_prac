package com.example.spring_boot_prec.domain.repository

import com.example.spring_boot_prec.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long>