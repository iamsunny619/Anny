package com.starter.anny.ui.utils.extension

import androidx.annotation.MainThread
import androidx.lifecycle.*

// region LiveData
/**
 *same as [LiveData.observe] but ignores null value
 */
@MainThread
inline fun <T> LiveData<T?>.observeNotNull(
        owner: LifecycleOwner,
        crossinline onChanged: (T) -> Unit
): Observer<T?> {
    val wrappedObserver = Observer<T?> { t -> if (t != null) onChanged.invoke(t) }
    observe(owner, wrappedObserver)
    return wrappedObserver
}
// endregion