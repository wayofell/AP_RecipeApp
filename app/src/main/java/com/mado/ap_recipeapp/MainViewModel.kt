package com.mado.ap_recipeapp
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCategories()
                _categoriesState.value = categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categoriesState.value = categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching categories: ${e.message}"
                )
            }
        }
    }
}

data class RecipeState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null
)
