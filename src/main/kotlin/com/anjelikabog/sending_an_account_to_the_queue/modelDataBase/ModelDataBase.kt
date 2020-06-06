package com.anjelikabog.sending_an_account_to_the_queue.modelDataBase

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "person")
data class PersonsDB(
        @Id
        @SequenceGenerator(name = "person_id_seq", sequenceName = "persons_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
        @Column(name = "id", nullable = false, insertable = false)
        val idPersons: Long? = null,

        @Column
        val fullname: String? = null,

        @Column
        val birthday: Date? = null,

        @Column
        var status: String? = null,

        @OneToMany(mappedBy = "idPersons", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val hobbies: MutableList<HobbyDB> = mutableListOf(),
        @Column
        val account: String? = null
)

@Entity
@Table(name = "hobbies")
data class HobbyDB(
        @Id
        @SequenceGenerator(name = "hob_id_seq", sequenceName = "hobbies_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hob_id_seq")
        @Column(name = "id", nullable = false, insertable = false)
        val idHobby: Long? = null,

        @Column(nullable = false)
        val complexity: Int? = null,

        @Column(nullable = false)
        val hobby_name: String? = null,


        @ManyToOne
        @JoinColumn(name="id_person", nullable = false)
        val idPersons: PersonsDB? =null
)