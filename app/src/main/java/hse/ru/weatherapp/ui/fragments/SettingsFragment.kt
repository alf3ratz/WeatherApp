package hse.ru.weatherapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import hse.ru.avitoweather.viewmodels.WeatherViewModel
import hse.ru.weatherapp.R
import hse.ru.weatherapp.databinding.FragmentSettingsBinding
import hse.ru.weatherapp.databinding.WeatherFragmentBinding

class SettingsFragment : Fragment() {
    private var binding: FragmentSettingsBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.apply {
            changeColorButton.setOnClickListener {
                if (requireActivity().theme.equals(android.R.style.Theme)) {
                    changeColorButton.text = "dfdf"
                    requireActivity().setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen)
                } else {
                    changeColorButton.text = "triorot"
                    requireActivity().setTheme(android.R.style.Theme)
                }
            }
            imageBack.setOnClickListener {
                if (parentFragmentManager.backStackEntryCount > 0) {
                    parentFragmentManager.popBackStackImmediate()
                }
            }
        }
    }


}