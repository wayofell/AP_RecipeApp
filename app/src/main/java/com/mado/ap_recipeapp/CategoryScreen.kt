package com.mado.ap_recipeapp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryScreen(categories: List<Category>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(categories) { category ->
            CategoryItem(category = category)
        }
    }
}
