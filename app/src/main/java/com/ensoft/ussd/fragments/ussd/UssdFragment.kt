package com.ensoft.ussd.fragments.ussd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ensoft.ussd.R
import com.ensoft.ussd.UssdData
import com.ensoft.ussd.UssdAdapter


class UssdFragment : Fragment() {

    private lateinit var ussdRecyclerView: RecyclerView
    private var mList = ArrayList<UssdData>()
    private lateinit var ussdAdapter: UssdAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ussd, container, false)
        ussdRecyclerView = view.findViewById(R.id.ussdRecyclerView)

        ussdRecyclerView.setHasFixedSize(true)
        ussdRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()
        ussdAdapter = UssdAdapter(mList)
        ussdRecyclerView.adapter = ussdAdapter
        return view
    }

    private fun addDataToList() {
        mList.add(
            UssdData(
                "*102#",
                "Balans",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*104#",
                "Mening raqamim",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*144#",
                "Menga qo’ng’iroq qiling",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*141#",
                "Boshqa raqamga yo’naltirish",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*441#",
                "Vaqtincha aloqada emasman",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*535#",
                "Ko’ngilocha chat",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*111#",
                "Men kimman",
                getString(R.string.balans)
            )
        )
        mList.add(
            UssdData(
                "*096#",
                "Mega boom",
                getString(R.string.balans)
            )
        )
    }

}