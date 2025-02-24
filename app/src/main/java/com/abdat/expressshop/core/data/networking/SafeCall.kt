package com.abdat.expressshop.core.data.networking


import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.core.domain.util.Result.*
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import kotlin.coroutines.coroutineContext


suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse,
): Result<NetworkError, T> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        return Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: SerializationException) {
        return Error(NetworkError.SERIALIZATION_ERROR)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Error(NetworkError.UNKNOWN_ERROR)
    }
    return responseToResult(response)
}
