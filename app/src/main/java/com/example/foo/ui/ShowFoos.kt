package com.example.foo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foo.database.Foo
import androidx.compose.foundation.lazy.items


@Composable
fun ShowFoos(items: List<Foo>, onNodeRemoved: (Foo) -> Unit) {

    LazyColumn() {
        items (items) {item ->
            Row {
                Text(
                    text = item.libelle,
                    modifier = Modifier
                        .weight(1f, true)
                        .align(Alignment.CenterVertically)
                )
                TextButton(
                    onClick = {
                        onNodeRemoved(item)
                    },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "", modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}