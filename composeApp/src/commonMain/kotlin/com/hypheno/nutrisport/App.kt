package com.hypheno.nutrisport

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import com.nutrisport.navigation.SetupNavGraph
import com.nutrisport.shared.Constants
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        var isAppReady by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            GoogleAuthProvider.create(credentials = GoogleAuthCredentials(serverId = Constants.WEB_CLIENT_ID))
            isAppReady = true
        }

        AnimatedVisibility(
            visible = isAppReady,
            modifier = Modifier.fillMaxSize()
        ) {
            SetupNavGraph()
        }
    }
}
