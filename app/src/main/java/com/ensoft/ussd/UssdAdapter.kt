package com.ensoft.ussd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class UssdAdapter(private var mList: List<UssdData>) :
    RecyclerView.Adapter<UssdAdapter.USSDViewHolder>() {

    inner class USSDViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUssdCode: TextView = itemView.findViewById(R.id.tv_ussd_code)
        var tvUssdBalance: TextView = itemView.findViewById(R.id.tv_ussd_balance)
        val tvUssdDesc: TextView = itemView.findViewById(R.id.tv_ussd_desc)
        val btnUssdCheck: Button = itemView.findViewById(R.id.btn_ussd_check)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

        fun collapseExpandedView(){
            btnUssdCheck.visibility = View.GONE
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): USSDViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ussd_row_item, parent, false)
        return USSDViewHolder(view)
    }

    override fun onBindViewHolder(holder: USSDViewHolder, position: Int) {

        val ussdData = mList[position]
        holder.tvUssdCode.text = ussdData.ussdCode
        holder.tvUssdBalance.text = ussdData.ussdHeader
        holder.tvUssdDesc.text = ussdData.ussdDesc

        val isExpandable: Boolean = ussdData.isExpandable
        holder.btnUssdCheck.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            ussdData.isExpandable = !ussdData.isExpandable
            notifyItemChanged(position , Unit)
        }

    }

    private fun isAnyItemExpanded(position: Int){
        val temp = mList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            mList[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }

    override fun onBindViewHolder(
        holder: USSDViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}