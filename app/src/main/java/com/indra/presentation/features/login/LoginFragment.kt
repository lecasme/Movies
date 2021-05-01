package com.indra.presentation.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.indra.databinding.FragmentLoginBinding
import com.indra.presentation.commons.BaseFragment
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.utils.setOnSafeClickListener
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModel()
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnSafeClickListener {
            viewModel.login(
                binding.txtUsername.text.toString(),
                binding.txtPassword.text.toString()
            )
        }

        viewModel.status.observe(viewLifecycleOwner,{
           findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        })

    }

    override fun getViewModel(): BaseViewModel = viewModel

}