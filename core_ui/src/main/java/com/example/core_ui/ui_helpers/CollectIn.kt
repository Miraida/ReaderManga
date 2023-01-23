package com.example.core_ui.ui_helpers

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectIn(
  owner: LifecycleOwner,
  minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
  crossinline action: suspend (value: T) -> Unit,
): Job = owner.lifecycleScope.launch {
  owner.repeatOnLifecycle(state = minActiveState) {
    Log.e("$owner","Start collecting $owner $minActiveState...")
    collect { action(it) }
  }
}