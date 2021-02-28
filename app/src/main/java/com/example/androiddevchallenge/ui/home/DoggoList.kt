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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Doggo
import com.example.androiddevchallenge.ui.theme.pastelColors
import com.example.androiddevchallenge.ui.utils.StaggeredVerticalGrid
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DoggoList(
    doggoList: List<Doggo>,
    navigateToDetails: (Doggo) -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 250.dp,
            modifier = Modifier.padding(4.dp)
        ) {
            doggoList.forEach { doggo ->
                CreateGridItem(doggo = doggo, navigateToDetails)
            }
        }
    }
}

@Composable
private fun CreateGridItem(
    doggo: Doggo,
    navigateToDetails: (Doggo) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navigateToDetails.invoke(doggo)
            }
    ) {
        CoilImage(
            data = doggo.image.url,
            contentDescription = doggo.name,
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .background(Color.LightGray)
                .aspectRatio(doggo.image.aspectRatio)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    pastelColors
                        .random()
                        .copy(alpha = 0.5f)
                )
                .padding(vertical = 10.dp, horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var isSelected = remember{
                    mutableStateOf(false)
                }
                Text(
                    text = doggo.name,
                    style = MaterialTheme.typography.subtitle2
                )
                Image(
                    painter = painterResource(if(isSelected.value) R.drawable.ic_heart_enable else R.drawable.ic_heart_disable),
                    contentDescription = "Like",
                    modifier = Modifier
                        .size(18.dp)
                        .clickable {
                            isSelected.value = !isSelected.value
                        }
                )
            }
            Text(
                text = doggo.breedGroup,
                style = MaterialTheme.typography.body2
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "${doggo.gender.value}, ${doggo.ageString}",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}
