package com.example.graphingtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphingtest.databinding.CatalogBinding
import com.example.graphingtest.ui.AAchart.AADemoList
import com.example.graphingtest.ui.MPA.MPADemoList
import com.example.graphingtest.ui.anychart.AnyDemoList
import com.example.graphingtest.ui.main.GridViewAdapter
import com.example.graphingtest.ui.main.GridViewItem
import com.example.graphingtest.ui.vico.VicoDemoList

class CatalogFragment : Fragment(R.layout.catalog)  {
    private lateinit var binding: CatalogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = CatalogBinding.inflate(layoutInflater)

        val items = listOf(
            GridViewItem(VicoDemoList::class.java, getString(R.string.tab_text_1), R.drawable.vico),
            GridViewItem(MPADemoList::class.java, getString(R.string.tab_text_2), R.drawable.mpa),
            GridViewItem(AnyDemoList::class.java, getString(R.string.tab_text_3), R.drawable.anychart),
            GridViewItem(AADemoList::class.java, getString(R.string.tab_text_4), R.drawable.aachart),
        )

        binding.gvLibraries.adapter = GridViewAdapter(items)

        return binding.root
    }
}