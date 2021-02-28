package com.ifancc.petadoption
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

enum class Screen { PetList, PetDetail }
// WIP
fun Fragment.navigate(to: Screen, from: Screen) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    when (to) {
//        Screen.PetList -> {
//            findNavController().navigate(R.id.welcome_fragment)
//        }
//        Screen.PetDetail -> {
//            findNavController().navigate(R.id.sign_up_fragment)
//        }
    }
}