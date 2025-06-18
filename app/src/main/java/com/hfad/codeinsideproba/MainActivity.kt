package com.hfad.codeinsideproba

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hfad.codeinsideproba.navigation.Navigation
import com.hfad.codeinsideproba.ui.theme.CodeinsideProbaTheme

// Главная Activity приложения
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // Включаем edge-to-edge режим (на весь экран)
        enableEdgeToEdge()
        // Устанавливаем Compose содержимое
        setContent {
            // Применяем собственную тему приложения
            CodeinsideProbaTheme {
                // Surface - базовый контейнер с фоном
                Surface(
                    // Занимает весь доступный размер
                    modifier = Modifier.fillMaxSize(),
                    // Цвет фона из темы
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Отображаем основной экран с картой офиса
                    Navigation()
                }
            }
        }
    }
}