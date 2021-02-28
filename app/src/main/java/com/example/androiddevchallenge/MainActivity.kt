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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.navigation.compose.NavHost
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.repository.DoggosRepository
import com.example.androiddevchallenge.navigation.Navigation
import com.example.androiddevchallenge.ui.details.DetailsScreen
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val doggos = DoggosRepository.doggosList
    val navController = rememberNavController()
    NavHost(navController, startDestination = Navigation.HomeScreen.title) {
        composable(Navigation.HomeScreen.title) {
            HomeScreen(
                doggos = doggos,
                navigateToDetails = { doggo ->
                    navController.navigate(Navigation.DetailScreen.title + "/${doggo.id}")
                }
            )
        }
        composable(Navigation.DetailScreen.title + "/{id}") { backStackEntry ->
            val doggoId = backStackEntry.arguments?.getString("id")
            val doggo = doggos.find { it.id == doggoId }
                ?: throw IllegalStateException("Invalid Dog Id")
            DetailsScreen(
                doggo = doggo,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
