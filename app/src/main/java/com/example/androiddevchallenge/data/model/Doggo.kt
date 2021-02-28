package com.example.androiddevchallenge.data.model

data class Doggo(
    val id: String,
    val name: String,
    val breedGroup: String,
    val height: String,
    val age: String,
    val gender: Gender,
    val lifeSpan: String,
    val color: String,
    val image: Image,
    val weight: Int = (10..50).random(),
    val description: String
) {

    enum class Gender(val value: String) {
        MALE("Male"),
        FEMALE("Female")
    }

    val ageString: String
        get() {
            val ageInYears = (age.toInt() / 12).toFloat()
            return if (ageInYears <= 0) {
                "$age months"
            }
            else{
                "${ageInYears.toInt()} years"
            }
        }
}

data class Image(
    val url: String,
    val width: Int,
    val height: Int
) {

    val aspectRatio: Float
        get() {
            return width.toFloat().div(height.toFloat())
        }
}