package com.timplifier.boilerplate.core.data.foundation.remote

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.timplifier.boilerplate.core.data.foundation.DTOMapper
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.utils.io.errors.IOException

abstract class PagingSource<DTO : DTOMapper<Model>, Model : Any>(
    private val request: suspend (position: Int) -> PagingResponse<DTO>,
) : PagingSource<Int, Model>() {

    private var nextOffset: Int? = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Model> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX
        return try {
            val response = request(position)
            nextOffset = response.next?.let {
                val uri = Uri.parse(it)
                uri.getQueryParameter("offset")?.toInt()
            }

            LoadResult.Page(
                data = response.results.map { it.toDomain() },
                prevKey = null,
                nextKey = nextOffset
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpRequestTimeoutException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Model>): Int? {
        return null
    }

    private companion object {
        private const val BASE_STARTING_PAGE_INDEX = 0
    }
}