package com.zanoApp.sleep_tracker.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.zanoApp.sleep_tracker.R
import com.zanoApp.sleep_tracker.viewModels.UserDataViewModel

class UserDataFragment : Fragment() {

    companion object {
        fun newInstance() = UserDataFragment()
    }

    private lateinit var viewModel: UserDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
