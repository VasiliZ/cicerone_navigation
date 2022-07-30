package com.github.rtyvz.cicerone_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SampleFragment : Fragment() {

    private val router = CiceroneApp.getRouter()

    companion object {
        const val ID_EXTRA = "ID"

        fun newInstance(id: String): SampleFragment {
            return SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ID_EXTRA, id)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.sample_fragment, container, false)

        view.findViewById<TextView>(R.id.agrsTextView)?.text = arguments?.getString(ID_EXTRA)
        view.findViewById<Button>(R.id.openFragmentsButton).setOnClickListener {
            router?.newChain(
                Screens.sampleFragment("2"),
                Screens.sampleFragment("3"),
                Screens.sampleFragment("4")
            )
        }

        view.findViewById<Button>(R.id.finishChainFragmentsButton).setOnClickListener {
            router?.finishChain()
        }

        return view
    }
}