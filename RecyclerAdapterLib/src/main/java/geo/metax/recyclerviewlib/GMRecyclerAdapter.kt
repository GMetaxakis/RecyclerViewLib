package geo.metax.recyclerviewlib

import android.support.v7.widget.RecyclerView
import java.util.*

abstract class GMRecyclerAdapter<Element, ViewHolder : GMRecyclerViewHolder<Element>> :
    RecyclerView.Adapter<ViewHolder>() {

    private var selectedItemPosition: Int = 0

    var data: MutableList<Element> = mutableListOf()
    override fun getItemCount(): Int = data.size

    open fun add(item: Element?, notifyDataSetChanged: Boolean = true) {
        item?.let {
            if (data.add(it) && notifyDataSetChanged) notifyItemInserted(data.size - 1)
        }
    }

    open fun remove(item: Element?, notifyDataSetChanged: Boolean = true) {
        item?.let {
            val index = data.indexOf(it)
            if (index != -1)
                if (data.remove(it) && notifyDataSetChanged) notifyItemRemoved(index)
        }
    }

    open fun replace(
        items: MutableList<Element>?,
        comparator: Comparator<Element>? = null,
        notifyDataSetChanged: Boolean = true
    ) {
        clear(false)
        addAll(items, false)

        comparator?.let { sort(it) }
        if (notifyDataSetChanged)
            notifyDataSetChanged()
    }

    open fun addAll(items: MutableList<Element>?, notifyDataSetChanged: Boolean = true) {
        items?.let {
            data.addAll(it.toMutableList())
            if (notifyDataSetChanged)
                notifyDataSetChanged()
        }
    }

    open fun clear(notifyDataSetChanged: Boolean = true) {
        data.clear()
        if (notifyDataSetChanged)
            notifyDataSetChanged()
    }

    open fun sort(comparator: Comparator<Element>) {
        data.sortWith(comparator)
    }

    open fun getItem(position: Int): Element {
        return data[position]
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.selectedCallback = {
            val notify = selectedItemPosition != position
            if (notify) notifyItemChanged(selectedItemPosition)
            selectedItemPosition = holder.adapterPosition
            if (notify) notifyItemChanged(selectedItemPosition)
        }

        holder.bindModel(getItem(position), selectedItemPosition == position)
    }

    fun list(): MutableList<Element>? = data
}