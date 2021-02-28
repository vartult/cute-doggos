/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            } else {
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
