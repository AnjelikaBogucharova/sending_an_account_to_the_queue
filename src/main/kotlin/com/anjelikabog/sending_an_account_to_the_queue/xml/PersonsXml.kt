package com.anjelikabog.sending_an_account_to_the_queue.xml

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.text.SimpleDateFormat
import java.util.*

@JacksonXmlRootElement(localName = "Persons")
data class Persons(
        @field: JacksonXmlElementWrapper(useWrapping = false)
        @field: JacksonXmlProperty(localName = "Person")
        var person: List<Person>? = null
) {
    override fun toString(): String {
        return """
Persons: $person
""".trimMargin()
    }
}


data class Person(
        var name: String? = null,
        var birthday: Date? = null,
        var account: String? = null,
        var hobbies: Hobbies? = null
)
{
    override fun toString(): String {
        val sf = SimpleDateFormat("dd.MM.yyyy")
        return """

name: $name
birthday: ${sf.format(birthday)} 
hobbies: $hobbies 
""".trimIndent()
    }
}

data class Hobbies(
        @field: JacksonXmlElementWrapper(useWrapping = false)
        var hobby: List<Hobby>? = null
){
    override fun toString()="""
$hobby
""".trimIndent()
}

data class Hobby(
        var complexity: Int? = null,
        var hobby_name: String? = null
) {
    override fun toString()="""

Hobby:
complexity: $complexity
hobby_name: $hobby_name  
""".trimIndent()
}