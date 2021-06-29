package com.example.assignmentLowes.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentLowes.R
import com.example.assignmentLowes.databinding.ItemMovieBinding
import com.example.assignmentLowes.repository.model.SummaryModel

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 1:00 PM
 */
class MovieListAdapter(private val listItems: ArrayList<SummaryModel>, listener: ItemClickListener) : RecyclerView.Adapter<MovieListAdapter.DataViewHolder>() {

    private var itemClickListener: ItemClickListener = listener

    class DataViewHolder(@NonNull itemViewBinding: ItemMovieBinding) : RecyclerView.ViewHolder(
            itemViewBinding.root
    ) {
        private val itemMovieBinding: ItemMovieBinding = itemViewBinding

        fun bind(summaryModel: SummaryModel, itemClickListener: ItemClickListener) {
            itemMovieBinding.setVariable(BR.summaryModel, summaryModel)
            itemMovieBinding.executePendingBindings()
            itemMovieBinding.container.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(it, absoluteAdapterPosition, summaryModel)
                }
            }

            itemMovieBinding.root.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(it, absoluteAdapterPosition, summaryModel)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_movie,
                        parent,
                        false
                )
        )
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val summaryModel = listItems[position]
        holder.bind(summaryModel, itemClickListener)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    /**
     * Method to add the list of items
     * */
    fun addMovieReviewList(movieList: List<SummaryModel>) {
        this.listItems.apply {
            clear()
            addAll(movieList)
        }
    }

    /**
     * This interface is used to navigate to {@link DetailFragment} from MovieReviewListFragment
     * */
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int, summaryModel: SummaryModel)
    }
}