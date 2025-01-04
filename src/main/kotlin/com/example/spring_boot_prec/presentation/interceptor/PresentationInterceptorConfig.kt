package com.example.spring_boot_prec.presentation.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PresentationInterceptorConfig(
  private val presentationInterceptor: PresentationInterceptor
) : WebMvcConfigurer {

  override fun addInterceptors(registry: InterceptorRegistry) {
    registry.addInterceptor(PresentationInterceptor)
      .addPathPatterns("/**")
      .excludePathPatterns(
        "/assets/**",
        "/css/**",
        "/js/**",
        "/images/**",
        "/admin/**",
        "h2**",
        "/favicon.ico",
        "/error"
      )
  }
}