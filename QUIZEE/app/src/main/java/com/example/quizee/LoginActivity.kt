package com.example.quizee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizee.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.button2.setOnClickListener{
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
            binding.password.editText?.text.toString()).addOnCompleteListener{

                if(it.isSuccessful)
                    {
Toast.makeText(this,"User Created !!!", Toast.LENGTH_LONG).show()
                    }
                else
                {
                    Toast.makeText(this,"User Not Created !!!", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}

