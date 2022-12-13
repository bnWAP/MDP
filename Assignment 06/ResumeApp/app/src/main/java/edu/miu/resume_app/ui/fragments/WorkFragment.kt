package edu.miu.resume_app.ui.fragments

import CVBuilderApp.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.resume_app.models.WorkExperience
import edu.miu.resume_app.ui.dialog.WorkExperienceDialog
import edu.miu.resume_app.adapter.WorkAdapter

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<WorkExperience>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                WorkExperience(
                    getString(R.string.tesla),
                    getString(R.string.MLEngineer),
                    getString(R.string._2020_present),
                    R.drawable.meta
                ),
                WorkExperience(
                    getString(R.string.google),
                    getString(R.string.application_developer),
                    getString(R.string._2018_2020),
                    R.drawable.google
                ),
                WorkExperience(
                    getString(R.string.drishticon),
                    getString(R.string.sr_eng),
                    getString(R.string._2014_2016),
                    R.drawable.drishticon
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkExperienceDialog()
        dialog.show(parentFragmentManager, WorkExperienceDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(workExperience: WorkExperience) {
        workList.add(workExperience)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}