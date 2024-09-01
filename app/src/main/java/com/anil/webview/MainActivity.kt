package com.anil.webview

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.anil.webview.ui.theme.WebViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebViewTheme {
                OpenCustomTabButton()
            }
        }
    }
}

@Composable
fun OpenCustomTabButton() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            openGoogleSignIn(context)
        }, modifier = Modifier
            .padding(16.dp)) {
            Text(text = "Welcome to Vojan Services")
        }
    }
}
fun openGoogleSignIn(context: Context) {
    val googleSignInUrl = "https://vojanservice.com/DigitalMenu/App.php" // Your backend URL that initiates Google Sign-In

    CustomTabsIntent.Builder().apply {
        setShowTitle(false)
    }.build().launchUrl(context, Uri.parse(googleSignInUrl))
}

