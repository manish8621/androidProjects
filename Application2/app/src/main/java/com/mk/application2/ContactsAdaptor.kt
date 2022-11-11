package com.mk.application2

import android.provider.ContactsContract.Data
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mk.application2.databinding.FragmentHomeBinding
import com.mk.application2.databinding.RecyclerCardLayoutBinding
private const val  ITEM_VIEW_TYPE_HEADER = 0;
private const val  ITEM_VIEW_TYPE_ITEM = 1;


class ContactsAdaptor(val contactClickListener:ContactClickListener): ListAdapter<DataItem, RecyclerView.ViewHolder>(ContactDiffUtilCallback()) {

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
        }
    }

    //whenever list is updated
    fun addHeaderAndSubmitList(list:List<Contact>?)
    {
        val items = when(list) {
            null -> listOf(DataItem.HeaderItem)
            else -> listOf(DataItem.HeaderItem)+list.map { DataItem.ContactItem(it) }
        }
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
        //holder.bind(contact,contactClickListener)
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
                //this will no longer be needed when we use data binding
                //val view =layoutInflator.inflate(layout.recycler_card_layout, parent, false)
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
class ContactDiffUtilCallback:DiffUtil.ItemCallback<DataItem>()
{
    override fun areItemsTheSame(oldItem:DataItem,newItem:DataItem):Boolean = oldItem.mobNumber == newItem.mobNumber
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean = oldItem==newItem
}
class ContactClickListener(val clickListener:(name:String)->Unit){
    fun onclick(contact:Contact) = clickListener(contact.name)
}
sealed class DataItem()
{
    //mobile number used to identify same Items
    data class ContactItem(val contact:Contact):DataItem(){
        override val mobNumber: String = contact.mobNumber
    }
    object HeaderItem:DataItem(){
        override val mobNumber: String=""
    }
    abstract val mobNumber :String
}
