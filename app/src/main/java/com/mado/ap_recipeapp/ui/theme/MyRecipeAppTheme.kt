package com.mado.ap_recipeapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun MyRecipeAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography,
        content = content
    )
}
