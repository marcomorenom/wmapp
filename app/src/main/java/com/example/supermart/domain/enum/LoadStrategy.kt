package com.example.supermart.domain.enum

sealed class LoadStrategy {
    object ForceOnline : LoadStrategy()
    object Default : LoadStrategy()
}
