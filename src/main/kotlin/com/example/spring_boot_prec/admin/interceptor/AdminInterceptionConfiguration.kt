package com.example.spring_boot_prec.admin.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AdminInterceptionConfiguration(
  val adminInterceptor: AdminInterceptor
) : WebMvcConfigurer {

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry.addInterceptor(adminInterceptor)
      .addPathPatterns("/admin/**")
      .excludePathPatterns("/assets/**", "/css/**", "/js/**", "h2**")
  }
}