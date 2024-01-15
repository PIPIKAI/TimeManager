package com.zzk.timemanager.ui.screen.mainnav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zzk.timemanager.R
import com.zzk.timemanager.config.APPRoute
import com.zzk.timemanager.config.MainNavRoute
import com.zzk.timemanager.ui.screen.mainnav.home.HomeView
import com.zzk.timemanager.ui.screen.mainnav.setting.SettingView

@Composable
fun MainNavView() {
    val navList = listOf(Pair("主页", R.drawable.home), Pair("设置", R.drawable.setting))

    var nowActiveIndex by remember {
        mutableStateOf(0)
    }

    val mainNavController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        NavigationBar {
            navList.forEachIndexed { index, pair ->
                NavigationBarItem(selected = nowActiveIndex == index, onClick = {
                    nowActiveIndex = when (index) {
                        0 -> {
                            mainNavController.navigate(MainNavRoute.HOME)
                            index
                        }

                        1 -> {
                            mainNavController.navigate(MainNavRoute.SETTING)
                            index
                        }

                        else -> {
                            -1
                        }
                    }

                },
                    icon = {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = pair.second),
                            contentDescription = pair.first,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }, label = {
                        Text(text = pair.first)
                    }, colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = mainNavController, startDestination = MainNavRoute.HOME) {
                composable(route = MainNavRoute.HOME) {
                    HomeView()

                }
                composable(route = MainNavRoute.SETTING) {
                    SettingView()
                }
            }
        }
    }
}