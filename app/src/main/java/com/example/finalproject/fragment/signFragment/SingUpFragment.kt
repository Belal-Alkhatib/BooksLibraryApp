package com.example.finalproject.fragment.signFragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBookDescriptionBinding
import com.example.finalproject.databinding.FragmentSingUpBinding


class SingUpFragment : Fragment() {
    val binding = FragmentSingUpBinding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val singUpView = inflater.inflate(R.layout.fragment_sing_up, container, false)

        //The button that when pressed saves the information of the new user
        if(binding.tvName.text.isNotEmpty() && binding.tvPassword.text.isNotEmpty()
            && binding.tvRePassword.text.isNotEmpty()){
            binding.btnSignUp.setOnClickListener {
                val username = binding.tvName.text.toString()
                val email = binding.tvEmail.text.toString()
                val pass = binding.tvPassword.text.toString()
                val RePass = binding.tvPassword.text.toString()

                //To check whether the password in the first field is the same as in the second field
                if(pass.equals(RePass) ){
                    val bundle = Bundle()
                    bundle.putString("nameSignUp",username)
                    bundle.putString("emailSignUp",email)
                    bundle.putString("PasswordSignUp",pass)
                    bundle.putString("RePasswordSignUp",RePass)
                    /*
                    Here you enter the location to which you will transfer this data
                    */
                    swapFragment(LoginFragment())
                }else{
                    Toast.makeText(context , "Please verify that the password is correct" , Toast.LENGTH_SHORT).show()
                }
            }
        }else
            Toast.makeText(context , "Please Fill in The Required Fields" , Toast.LENGTH_SHORT).show()
//******************************************************  signInLink  *********************************************
        // The text that the user will click on if they already have an account
        binding.singInLink.setOnClickListener {
            swapFragment(LoginFragment())
        }
        return singUpView
    }

        @SuppressLint("UseRequireInsteadOfGet")
        fun swapFragment(fragment: Fragment){
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2,fragment)
                .addToBackStack(null).commit()
        }

}