package org.ery.project.core.domain.util

sealed interface Result <out D, out E: Error> {
    data class Success <out D>(val data: D): Result<D, Nothing>
    data class Error <out E: org.ery.project.core.domain.util.Error>(val error: org.ery.project.core.domain.util.Error): Result<Nothing, E>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<Error> {
    return map { }
}

typealias EmptyResult<E> = Result<Unit, E>