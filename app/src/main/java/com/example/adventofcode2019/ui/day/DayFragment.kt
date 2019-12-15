package com.example.adventofcode2019.ui.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.adventofcode2019.R
import com.example.adventofcode2019.solutions.Day0
import com.example.adventofcode2019.solutions.Day1
import com.example.adventofcode2019.solutions.Day2
import kotlinx.android.synthetic.main.day_fragment.*

class DayFragment : Fragment() {

    companion object {
        fun newInstance() = DayFragment()
    }

    private lateinit var viewModel: DayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.day_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DayViewModel::class.java)
        viewModel.setSolution(activity?.intent?.getIntExtra("DAY", -1))
        viewModel.resources = resources

        part_1_button.setOnClickListener { viewModel.onClickGetSolution(Part.ONE, part_1_input.text.toString()) }
        part_2_button.setOnClickListener { viewModel.onClickGetSolution(Part.TWO, part_2_input.text.toString()) }

        viewModel.updatePart1.observe(
            this,
            Observer { part_1_solution.text = it })
        viewModel.updatePart2.observe(
            this,
            Observer { part_2_solution.text = it })
    }

}
