package com.example.assignmentLowes.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.assignmentLowes.R
import com.example.assignmentLowes.databinding.FragmentDetailedBinding
import com.example.assignmentLowes.repository.model.SummaryModel
import com.example.assignmentLowes.utils.DataViewModelFactory
import com.example.assignmentLowes.views.viewModel.BaseViewModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 12:30 PM
 */
class DetailedFragment : Fragment() {

    private lateinit var detailedFragmentBinding: FragmentDetailedBinding
    private lateinit var summaryModel: SummaryModel
    private lateinit var baseViewModel: BaseViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailedFragmentBinding = FragmentDetailedBinding.bind(view)
        arguments?.let {
            summaryModel = DetailedFragmentArgs.fromBundle(it).detailReview
        }

        val dataViewModelFactory = this.activity?.let {
            activity?.applicationContext?.let { it1 ->
                DataViewModelFactory(
                        it1
                )
            }
        }
        baseViewModel =
                ViewModelProviders.of(this, dataViewModelFactory).get(BaseViewModel::class.java)


        detailedFragmentBinding.setVariable(BR.summaryModel, summaryModel)
        detailedFragmentBinding.executePendingBindings()

    }

}