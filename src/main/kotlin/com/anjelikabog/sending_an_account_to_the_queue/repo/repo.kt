package com.anjelikabog.sending_an_account_to_the_queue.repo

import com.anjelikabog.sending_an_account_to_the_queue.modelDataBase.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonsRepository : JpaRepository<PersonsDB, Long> {
    fun findAllByStatus(status: String): List<PersonsDB>
}

@Repository
interface HobbyRepository : JpaRepository<HobbyDB, Long>

