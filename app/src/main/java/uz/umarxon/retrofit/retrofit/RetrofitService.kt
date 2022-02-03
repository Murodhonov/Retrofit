package uz.umarxon.retrofit.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query
import uz.umarxon.retrofit.models.Movie
import uz.umarxon.retrofit.models.SIngleUser
import uz.umarxon.retrofit.models.UserResponse

interface RetrofitService {

    @GET("users")
    fun getUsers():Call<UserResponse>

    @GET("users/{id}")
    fun getUserById(@Query("id") id:Int):Call<SIngleUser>

}