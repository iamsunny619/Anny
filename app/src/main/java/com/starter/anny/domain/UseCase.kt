package com.starter.anny.domain

import java.io.IOException

/**
 * A Use Case or Interactor in terms of Clean Architecture.
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 */
interface UseCase<in Params, Result> {

    /**
     * executes the current usecase.
     *
     * @param params Parameters used to build this use case.
     * @return the usecase outcome
     */
    @Throws(IOException::class)
    suspend operator fun invoke(params: Params): Result

}

suspend operator fun <R> UseCase<Unit, R>.invoke() = this(Unit)