package com.vast.testmvvm.ui.extensions

import androidx.appcompat.app.AppCompatActivity

inline fun <reified T> AppCompatActivity.requireExtra(key: String): Lazy<T> {
    return lazy { intent?.extras?.get(key) as T }
}