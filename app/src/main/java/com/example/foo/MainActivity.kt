package com.example.foo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import com.example.foo.database.FoosViewModel
import com.example.foo.ui.AddFoo
import com.example.foo.ui.ShowFoos

class MainActivity : ComponentActivity() {
    private val notesViewModel by viewModels<FoosViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                AddFoo("Add Foo") {
                    notesViewModel.addFoo("CO1", it)
                }

                ShowFoos(notesViewModel.foos) {
                    notesViewModel.removeFoo(it)
                }

            }
        }
    }
}