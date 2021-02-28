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
package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Doggo
import com.example.androiddevchallenge.ui.theme.infoItemBg
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purpleButtonLight
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsScreen(
    doggo: Doggo,
    navigateBack: () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            // .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Header(doggo = doggo)
                Info(doggo = doggo)
                AdoptButtonBar()
            }
        }

        IconButton(onClick = navigateBack) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
}

@Composable
private fun Header(
    doggo: Doggo
) {
    CoilImage(
        data = doggo.image.url,
        contentDescription = doggo.name,
        contentScale = ContentScale.Crop,
        fadeIn = true,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(doggo.image.aspectRatio)
            .background(
                Color.White
            )
    )
}

@Composable
private fun Info(doggo: Doggo) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = doggo.name,
                style = MaterialTheme.typography.h4
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Paw",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Dallas",
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
                )
            }
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = doggo.breedGroup,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Text(
            text = "About",
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = doggo.description,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Text(
            text = "Vital Stats",
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoBanner(title = "Gender", value = doggo.gender.value)
            InfoBanner(title = "Age", value = doggo.ageString)
            InfoBanner(title = "Color", value = doggo.color)
            InfoBanner(title = "Weight", value = "${doggo.weight} Pounds")
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
        ) {
            InfoBanner(title = "Lifespan", value = doggo.lifeSpan)
            InfoBanner(title = "Height", value = doggo.height)
        }
    }
}

@Composable
fun AdoptButtonBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            elevation = null,
            modifier = Modifier
                .padding(16.dp)
                .weight(4f)
                .height(52.dp),
            onClick = { /*TODO*/ }
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_paw_print),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(top = 2.dp, end = 2.dp)
                )
                Text(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    text = "Adopt Me"
                )
            }
        }
        Button(
            elevation = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = purpleButtonLight),
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .weight(1f)
                .wrapContentWidth()
                .height(52.dp),
            onClick = { }
        ) {
            Icon(
                Icons.Filled.Phone, "phone",
                tint = purple200,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun InfoBanner(title: String, value: String) {
    Column(
        modifier = Modifier
            .defaultMinSize(
                minWidth = 90.dp
            )
            .background(
                color = infoItemBg,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.height(5.dp))
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = value,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Normal)
            )
        }
    }
}
