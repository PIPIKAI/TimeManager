package com.zzk.timemanager.ui.screen.start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.zzk.timemanager.config.APPRoute
import com.zzk.timemanager.ui.theme.TimeManagerTheme
import kotlinx.coroutines.delay

@Composable
fun StartPageView(appNavController: NavHostController? = null) {
//    LaunchedEffect(Unit ){
//        delay(1500)
//        // 延迟1.5秒后跳转到主页面
//        appNavController.navigate(APPRoute.MAIN_NAV)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var contentVisible by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(Unit) {
            delay(550)
            contentVisible = true
            delay(550)
            appNavController?.navigate(APPRoute.MAIN_NAV)
        }
        AnimatedVisibility(
            visible = contentVisible,
            enter = expandVertically(expandFrom = Alignment.Bottom) + fadeIn(initialAlpha = 0.1f)
        ) {
            Text(text = "時間管理大師", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPageViewPreview() {
    TimeManagerTheme {
        StartPageView()
    }
}
