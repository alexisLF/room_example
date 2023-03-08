package com.example.foo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddFoo(title: String, onFooAdded: (String) -> Unit) {
    Row {
        val text = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = {
                    Text(text = title)
            },
            modifier = Modifier
                .weight(1f, true)
        )
        Button(
            onClick = {
                val newFoo = text.value.text
                if (newFoo.isNotBlank()) {
                    onFooAdded(newFoo)
                    text.value = TextFieldValue("")
                }
            },
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "", modifier = Modifier.size(20.dp))
        }
    }
}
