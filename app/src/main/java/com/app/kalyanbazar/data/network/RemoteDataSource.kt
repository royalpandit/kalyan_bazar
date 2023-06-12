package com.app.kalyanbazar.data.network

import android.content.Context
import com.app.kalyanbazar.BuildConfig
import com.app.kalyanbazar.utils.Constants
import com.app.kalyanbazar.utils.MyApplication

import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.CookieHandler
import java.net.CookieManager
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class RemoteDataSource @Inject constructor() {


    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()

            //   .baseUrl(BuildConfig.BASE_URL_MAIN)

       .baseUrl("http://solar.betablackboard.in/")
       // .baseUrl(Constants.betaUrl)

  //  .baseUrl(Constants.betaUrl)
  // .baseUrl(Constants.betaUrl)

            .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
            //  .client(httpClient)

    //   .baseUrl(BuildConfig.BASE_URL_MAIN)
      // .baseUrl("http://solar.betablackboard.in/")
    //  .baseUrl("https://solar.codenamaste.in/")
     //         .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
          //  .client(httpClient)

            //     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(api)
    }

    private val httpClient: OkHttpClient
        get() {
            val cookieHandler: CookieHandler = CookieManager()
            val client = OkHttpClient().newBuilder().cookieJar(JavaNetCookieJar(cookieHandler))
                .cache(MyApplication.instance?.let {
                    Cache(
                        it.cacheDir,
                        (10 * 1024 * 1024).toLong()
                    )
                }) // 10 MB
                .connectTimeout(1, TimeUnit.MINUTES)
                .addNetworkInterceptor(AddHeaderInterceptor())
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
            if (BuildConfig.DEBUG) {
                val interceptor =
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(interceptor)
            }
            //     MyApplication.instance?.let {client.addInterceptor( ChuckerInterceptor(it) )}
            return client.build()
        }

    private class AddHeaderInterceptor : Interceptor {
        @kotlin.jvm.Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()
            builder.addHeader("Accept", "application/json; charset=utf-8")
            val token = MyApplication.tinyDB.getString(
                Constants.SharedPref.ACCESS_TOKEN,
                "not_selected"
            )
            if (!token.isNullOrEmpty())
                builder.addHeader(
                    "Authorization",
//                    "Bearer " + AES.decrypt(token, Constants.SharedPref.ACCESS_TOKEN)
                    "Bearer $token"
                )
            return chain.proceed(builder.build())
        }
    }
}