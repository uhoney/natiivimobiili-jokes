package com.example.natiivimobiili_jokes.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.natiivimobiili_jokes.R
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SettingsScreen(navController: NavController, screenTitle: String) {
    var checked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { CustomTAB(navController, screenTitle) },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Row {
                    Text(text = stringResource(R.string.settings_dark_theme))
                    Spacer(Modifier.weight(1f))
                    Switch(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        thumbContent = {
                            if (checked) {
                                Icon(
                                    imageVector = Icons.Filled.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            }
                        }
                    )
                }

            }
        }
    )
}