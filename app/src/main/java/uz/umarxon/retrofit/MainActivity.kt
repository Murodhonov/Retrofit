package uz.umarxon.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.umarxon.retrofit.databinding.ActivityMainBinding
import uz.umarxon.retrofit.models.Data
import uz.umarxon.retrofit.models.SIngleUser
import uz.umarxon.retrofit.models.UserResponse
import uz.umarxon.retrofit.retrofit.Common
import uz.umarxon.retrofit.retrofit.RetrofitService

class MainActivity : AppCompatActivity() {

    lateinit var retrofitService: RetrofitService
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = Common.retrofitService(this)

        binding.search.setOnClickListener {
            if (binding.number.text.isNotEmpty()) {
                retrofitService.getUserById(binding.number.toString().toDouble().toInt()).enqueue(object : Callback<SIngleUser> {
                    override fun onResponse(
                        call: Call<SIngleUser>,
                        response: Response<SIngleUser>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("TAG", "onResponse: ${response.body()}")
                            Picasso.get().load(response.body()!!.dataX.avatar).into(binding.image)
                            binding.firstname.text = response.body()!!.dataX.first_name
                            binding.lastname.text = response.body()!!.dataX.last_name
                            binding.email.text = response.body()!!.dataX.email
                            binding.iduser.text = response.body()!!.dataX.id.toString()
                        }
                    }

                    override fun onFailure(call: Call<SIngleUser>, t: Throwable) {
                        Log.d("TAG", "onFailure: ${t.message}")
                    }
                })
            }
        }

        retrofitService.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    list = ArrayList()
                    list.addAll(response.body()?.data!!)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })


    }
}