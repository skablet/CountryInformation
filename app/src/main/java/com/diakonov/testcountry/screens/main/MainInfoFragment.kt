package com.diakonov.testcountry.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.testcountry.APP
import com.diakonov.testcountry.R
import com.diakonov.testcountry.databinding.FragmentMainInfoBinding
import com.diakonov.testcountry.model.InfoItem

class MainInfoFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val viewModel = ViewModelProvider(this).get(MainInfoViewModel::class.java)
        val bindingMainFragment = FragmentMainInfoBinding.inflate(inflater)

        recyclerView = bindingMainFragment.rvMain
        adapter = MainAdapter()
        recyclerView.adapter = adapter
        bindingMainFragment.btnRefresh.setOnClickListener{viewModel.getCountries()
        }

        viewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let{
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        viewModel.getCountries()
        viewModel.countryList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }


        return bindingMainFragment.root
    }


    companion object {
        fun clickItem(infoItem: InfoItem) {
            val bundle = Bundle()
            bundle.putString("flag", infoItem.flags.png)
            bundle.putString("cap",infoItem.capital)
            bundle.putString("name",infoItem.name)
            bundle.putString("region",infoItem.region)
            bundle.putString("currencies",infoItem.currencies.component1().name)
            bundle.putString("zones",infoItem.timezones.component1())
            APP.navController.navigate(R.id.action_mainInfoFragment2_to_detailedInfoFragment2, bundle)

        }
    }
}
