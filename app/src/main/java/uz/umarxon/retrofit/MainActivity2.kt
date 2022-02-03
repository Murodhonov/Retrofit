package uz.umarxon.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import com.squareup.picasso.Picasso
import uz.umarxon.retrofit.databinding.ActivityMain2Binding
import uz.umarxon.retrofit.models.Movie

class MainActivity2 : AppCompatActivity() {

    lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getSerializableExtra("user") as Movie

        Picasso.get().load(user.imageurl).into(binding.image)

        binding.name.text = user.bio



    }
}