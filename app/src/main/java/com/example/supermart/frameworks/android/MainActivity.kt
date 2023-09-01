package com.example.supermart.frameworks.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.supermart.application.viewModels.ProductListViewModel
import com.example.supermart.frameworks.ui.screens.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val productsViewModel: ProductListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListScreen(
                screenViewModel = productsViewModel
            )
        }
    }

    override fun onStart() {
        super.onStart()
        productsViewModel.loadProducts()
    }
}