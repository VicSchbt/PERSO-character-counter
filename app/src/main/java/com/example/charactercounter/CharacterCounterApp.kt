package com.example.charactercounter

import android.app.Application
import com.example.charactercounter.di.AppContainer

class CharacterCounterApp: Application() {

    // Instance of AppContainer that will be used by all the activities of the application
    val appContainer = AppContainer()
}
