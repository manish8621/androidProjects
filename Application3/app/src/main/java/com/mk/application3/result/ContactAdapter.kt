package com.mk.application3


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mk.application3.database.Contact
import com.mk.application3.databinding.RecyclerCardLayoutBinding


private const val  ITEM_VIEW_TYPE_HEADER = 0;
private const val  ITEM_VIEW_TYPE_ITEM = 1;


class ContactsAdapter(val contactClickListener:ContactClickListener): ListAdapter<DataItem, RecyclerView.ViewHolder>(ContactDiffUtilCallback()) {

//    var data = listOf<Contact>()
//    set(value) {
//        field= value
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position))
        {
            is DataItem.HeaderItem -> ITEM_VIEW_TYPE_HEADER
            is DataItem.ContactItem -> ITEM_VIEW_TYPE_ITEM
            else -> {throw IllegalArgumentException("Illegal argument type")}
        }
    }

    //whenever list is updated
    fun addHeaderAndSubmitList(list:List<Contact>?)
    {
        val items = when(list) {
            null -> listOf(DataItem.HeaderItem)
            //add the header to top of list
            else -> listOf(DataItem.HeaderItem)+list.map { DataItem.ContactItem(it) }
        }
        //after all modifications submit list
        submitList(items)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,position: Int) {
        //use getItem instead of data[]
        //using when to find if dataItem is not header
        when(holder){
            is CardViewHolder->{
                val contact = getItem(position) as DataItem.ContactItem
                holder.bind(contact.contact,contactClickListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType)
        {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> CardViewHolder.from(parent)
            else -> throw IllegalArgumentException("unknown view type")
        }
    }

    class CardViewHolder private constructor(private val binding: RecyclerCardLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(contact: Contact,contactClickListener: ContactClickListener) {
            with(binding){
                binding.clickListener = contactClickListener
                avatarIv.setImageResource(
                    when (contact.gender) {
                        "male" -> R.drawable.maleavatar
                        else -> R.drawable.femaleavatar
                    }
                )
                //we no longer need this after data bind use the properties directly in xml to ini the text
//                nameTv.text = contact.name
//                numberTv.text = contact.mobNumber
//                personRelationTv.text = contact.relation
                binding.contact = contact
            }
        }
        companion object {
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflator =  LayoutInflater.from(parent.context)
                val view = RecyclerCardLayoutBinding.inflate(layoutInflator,parent,false)
                return CardViewHolder(view)
            }
        }
    }
    class TextViewHolder(view: View):RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent:ViewGroup):TextViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.text_header_layout,parent,false)
                return TextViewHolder(view)
            }
        }
    }


}

//more efficient than the notifyDatasetChanged()
//compares the list items and finds the modified item
class ContactDiffUtilCallback:DiffUtil.ItemCallback<DataItem>()
{
    override fun areItemsTheSame(oldItem:DataItem,newItem:DataItem):Boolean = oldItem.number == newItem.number
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean = oldItem==newItem
}

//gets the onclick lambda as constructor arg
class ContactClickListener(val clickListener:(name:String)->Unit){
    //this function invoked from xml layout
    fun onclick(contact:Contact) = clickListener(contact.name)
}

//DataItem used as a parent class for both HeaderItem and Contact Item
//because we need to store them in one list.
sealed class DataItem()
{
    //mobile number used to identify same Items
    data class ContactItem(val contact:Contact):DataItem(){
        override val number: String = contact.number
    }
    object HeaderItem:DataItem(){
        override val number: String=""
    }
    //the abstract member can be useful when we want to access a member without casting into specific class
    abstract val number :String
}
