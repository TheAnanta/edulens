package dev.theananta.edulens.model

sealed class User {
    data class Student(
        val rollNumber: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val image: String
    ): User()
}