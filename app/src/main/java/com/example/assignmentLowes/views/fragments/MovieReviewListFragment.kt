package com.example.assignmentLowes.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentLowes.R
import com.example.assignmentLowes.databinding.FragmentMainBinding
import com.example.assignmentLowes.repository.model.SummaryModel
import com.example.assignmentLowes.utils.DataViewModelFactory
import com.example.assignmentLowes.utils.Utils
import com.example.assignmentLowes.views.adapter.MovieListAdapter
import com.example.assignmentLowes.views.viewModel.BaseViewModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 11:30 AM
 */
class MovieReviewListFragment : Fragment(), MovieListAdapter.ItemClickListener {

    private lateinit var fragmentBinding: FragmentMainBinding
    private lateinit var baseViewModel: BaseViewModel
    private lateinit var adapter: MovieListAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = FragmentMainBinding.bind(view)
        this.fragmentBinding.lifecycleOwner = this

        setupViewModel()
        setupUI()
        setupObservers()

    }

    /**
     * Observing the data from viewModel
     * */
    private fun setupObservers() {

        if (Utils.isNetworkAvailable()) {
            baseViewModel.getMoviesList()
        } else {
            Toast.makeText(activity, "Internet not connected", Toast.LENGTH_SHORT).show()
        }

        baseViewModel.movieReviewList.observe(viewLifecycleOwner, {
            it?.let {
                showMoviewReviewList(it.summaryModel)
            }
        })

    }

    /**
     * Method to pass the data to adapter
     * */
    private fun showMoviewReviewList(movieList: List<SummaryModel>) {
        adapter.apply {
            addMovieReviewList(movieList)
            notifyDataSetChanged()
        }
    }

    /**
     * Setting up recyclerview & adding line separation
     * */
    private fun setupUI() {
        fragmentBinding.recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MovieListAdapter(arrayListOf(), this)
        fragmentBinding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                        fragmentBinding.recyclerView.context,
                        (fragmentBinding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        fragmentBinding.recyclerView.adapter = adapter
    }

    /**
     * Initializing ViewModel instance
     * */
    private fun setupViewModel() {
        val dataViewModelFactory = this.activity?.let {
            activity?.applicationContext?.let { it1 ->
                DataViewModelFactory(
                        it1
                )
            }
        }
        baseViewModel =
                ViewModelProviders.of(this, dataViewModelFactory).get(BaseViewModel::class.java)

    }

    /**
     * On complete Item click navigating to show detail review
     * */
    override fun onItemClick(view: View, position: Int, summaryModel: SummaryModel) {
        Navigation.findNavController(view)
                .navigate(MovieReviewListFragmentDirections.actionMainFragmentToDetailedFragment(summaryModel))
    }
}