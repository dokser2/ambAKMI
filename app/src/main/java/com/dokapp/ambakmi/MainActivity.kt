package com.dokapp.ambakmi

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.dokapp.ambakmi.ui.theme.AmbAKMITheme
import com.dokapp.ambakmi.viewModel.ViewItem
import java.io.File
import java.io.IOException

class MainActivity : ComponentActivity() {

    private var context: Context? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmbAKMITheme {
            ViewItem()

            }
        }
    }
}




