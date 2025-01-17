package com.android.bottlerocket.common

/**
 * A generic class that represents data with its loading state to be handled by UI.
 */
data class Result<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?) = Result(
            Status.SUCCESS,
            data,
            null
        )

        fun <T> error(message: String, data: T? = null) =
            Result(
                Status.ERROR,
                data,
                message
            )

        fun <T> loading(data: T? = null) =
            Result(
                Status.LOADING,
                data,
                null
            )
    }
}