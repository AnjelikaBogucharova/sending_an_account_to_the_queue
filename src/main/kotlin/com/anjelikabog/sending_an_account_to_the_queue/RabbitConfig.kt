package com.anjelikabog.sending_an_account_to_the_queue

import com.anjelikabog.sending_an_account_to_the_queue.repo.PersonsRepository
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Sender(
        val template: RabbitTemplate,
        val queue: Queue,
        val personsRepository: PersonsRepository
)
{
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send(){
        personsRepository.findAllByStatus("new").forEach{
            val message = it.account
            template.convertAndSend(queue.getName(), message!!)
            it.status="received"
            personsRepository.save(it)
            println("[x] Sent account '$message'")
        }

    }
}


@Configuration
@EnableScheduling
class TutorialConfiguration
{
    @Bean
    fun account() = Queue("account")


}