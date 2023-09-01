package com.example.supermart.frameworks.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.supermart.application.viewModels.ProductListViewModel
import com.example.supermart.domain.entities.ProductEntity
import com.example.supermart.frameworks.ui.components.ProductComponent


@Composable
fun ProductListScreen(
    screenViewModel: ProductListViewModel,
    ) {

    val once = true
    val dynamicSectionsState: MutableState<List<ProductEntity>> = remember {
        screenViewModel.productsState
    }

    LaunchedEffect(key1 = once){
        // handle reactive observers
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            dynamicSectionsState.value.forEach { product ->
                item {
                    ProductComponent(
                        name = product.name,
                        cost = product.cost,
                        id = product.id,
                    )
                }
            }
        }
    }
}