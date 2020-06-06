package com.anjelikabog.sending_an_account_to_the_queue

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConvertXmlConfig {

    @Bean
    fun xmlMapper() = XmlMapper()
}