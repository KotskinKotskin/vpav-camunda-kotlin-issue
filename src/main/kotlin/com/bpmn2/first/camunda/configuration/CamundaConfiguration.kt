package com.bpmn2.first.camunda.configuration

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CamundaConfiguration {

    @Bean
    fun processCorsFilter(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)

        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.setOrder(0)
        return bean
    }

    @Bean
    @ConditionalOnMissingBean(name = ["spinProcessEnginePlugin"])
    fun spinProcessEnginePlugin(): ProcessEnginePlugin {
        return SpinProcessEnginePlugin()
    }
}
