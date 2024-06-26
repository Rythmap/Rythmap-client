package com.mvnh.rythmap.retrofit.account

import com.mvnh.rythmap.retrofit.account.entities.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface AccountApi {
    @POST("account/register")
    fun register(@Body request: AccountRegister): Call<AccountAuth>

    @POST("account/login")
    fun login(@Body request: AccountLogin): Call<AccountAuth>

    @GET("account/info/public")
    fun getPublicAccountInfo(@Query("nickname") nickname: String): Call<AccountInfoPublic>

    @GET("account/info/private")
    fun getPrivateAccountInfo(@Query("token") token: String?): Call<AccountInfoPrivate>

    @GET("account/info/media/{type}")
    fun getMedia(
        @Query("type") type: String,
        @Query("id") id: String
    ): Call<ResponseBody>

    @DELETE("account/delete")
    fun deleteAccount(
        @Query("login") login: String,
        @Query("password") password: String
    ): Call<ResponseBody>

    @POST("account/update/info")
    fun updateInfo(@Body request: AccountUpdateInfo): Call<ResponseBody>

    @POST("account/update/nickname")
    fun updateNickname(
        @Query("token") token: String,
        @Query("new_nickname") newNickname: String
    ): Call<ResponseBody>

    @POST("account/update/password")
    fun updatePassword(
        @Query("nickname") nickname: String,
        @Query("current_password") currentPassword: String,
        @Query("new_password") newPassword: String
    ): Call<ResponseBody>

    @Multipart
    @POST("account/update/media/{type}")
    fun updateMedia(
        @Query("token") token: String,
        @Query("type") type: String,
        @Part media: MultipartBody.Part
    ): Call<ResponseBody>

    @POST("friends/request/send")
    fun sendFriendRequest(
        @Body request: SendFriendRequest
    ): Call<ResponseBody>

    @POST("friends/request/accept")
    fun acceptFriendRequest(
        @Body request: AnyOtherFriendRequest
    ): Call<ResponseBody>

    @POST("friends/request/decline")
    fun declineFriendRequest(
        @Body request: AnyOtherFriendRequest
    ): Call<ResponseBody>

    @POST("friends/request/cancel")
    fun cancelFriendRequest(
        @Body request: AnyOtherFriendRequest
    ): Call<ResponseBody>

    @POST("friends/remove")
    fun removeFriend(
        @Body request: AnyOtherFriendRequest
    ): Call<ResponseBody>

    @GET("friends/search")
    fun searchFriends(
        @Query("nickname") nickname: String
    ): Call<Map<String, AccountInfoPublic>>
}