package com.starter.anny.di.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * ViewModelFactory which uses Dagger to create the instances.
 */
class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = found?.value
            ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}

//below is the class took from java and conver

/*
class ViewModelProviderFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators) {

                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        requireNotNull(creator) { "unknown model class $modelClass" }

        // return the Provider
        return try {
            creator.get() as T
        } catch (e: java.lang.Exception) {
            throw java.lang.RuntimeException(e)
        }
    }

    companion object {
        private const val TAG = "ViewModelProviderFactor"
    }

}
*/
