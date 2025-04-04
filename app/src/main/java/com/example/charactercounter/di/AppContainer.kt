package com.example.charactercounter.di

import com.example.charactercounter.counting.presentation.CharacterCounterViewModel

class AppContainer {
    // this holds a singleton instance of your ViewModel
    val characterCounterViewModel = CharacterCounterViewModel()
}