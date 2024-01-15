package com.zzk.timemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zzk.timemanager.config.APPRoute
import com.zzk.timemanager.ui.screen.mainnav.MainNavView
import com.zzk.timemanager.ui.screen.start.StartPageView
import com.zzk.timemanager.ui.theme.TimeManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeManagerTheme {
                val appNavController = rememberNavController()
                NavHost(navController = appNavController, startDestination = APPRoute.MAIN_NAV) {
                    // 添加你的路由
                    composable(APPRoute.START_SCREEN) {
                        StartPageView(appNavController)
                    }
                    composable(APPRoute.MAIN_NAV) {
                        MainNavView()
                    }
                }
            }
        }
    }
}
