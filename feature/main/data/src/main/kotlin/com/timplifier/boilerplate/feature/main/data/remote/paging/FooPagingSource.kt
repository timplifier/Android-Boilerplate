package com.timplifier.boilerplate.feature.main.data.remote.paging

import com.timplifier.boilerplate.core.data.foundation.remote.PagingSource
import com.timplifier.boilerplate.feature.main.data.remote.dtos.FooDTO
import com.timplifier.boilerplate.feature.main.domain.models.FooModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.Url

class FooPagingSource(httpClient: HttpClient) : PagingSource<FooDTO, FooModel>({
    httpClient.get(url = Url("foo")) {}.body()
})