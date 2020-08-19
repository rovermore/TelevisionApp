package com.example.televisionapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.televisionapp.R
import com.example.televisionapp.TelevisionApp
import com.example.televisionapp.utils.ScreenState
import com.example.televisionapp.utils.gone
import com.example.televisionapp.utils.visible
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel.initialize()
        setupObservers()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    init { TelevisionApp.daggerAppComponent().inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupReloadButton()
    }

    private fun setupReloadButton() {
        reloadButton.setOnClickListener { mainViewModel.loadData() }
    }

    private fun setupObservers() {
        observeData()
        observeState()
    }

    private fun observeState() {
        mainViewModel.uiState.observe(this, Observer {
            updateUI(it)
        })
    }

    private fun observeData() {
        mainViewModel.uiModel.observe(this, Observer {
            adapter.clearMainAdapter()
            adapter.updateTransactionList(it.toMutableList())
        })
    }

    private fun setupUI() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView = mainRecycler
        recyclerView.visibility = View.GONE
        recyclerView.layoutManager = GridLayoutManager(context,2)
        adapter = MainAdapter( null)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun updateUI(it: ScreenState?) {
        when (it) {
            ScreenState.Error -> {
                progressBar.gone()
                recyclerView.gone()
                errorView.visible()
            }
            ScreenState.Loading -> progressBar.visible()
            ScreenState.Success -> {
                progressBar.gone()
                recyclerView.visible()
            }
        }
    }
}