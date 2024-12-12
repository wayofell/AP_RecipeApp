package com.mado.ap_recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mado.ap_recipeapp.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRecipeAppTheme {
                RecipeScreen()
            }
        }
    }
}
