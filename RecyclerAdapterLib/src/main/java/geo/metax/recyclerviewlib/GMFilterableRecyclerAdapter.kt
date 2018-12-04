package geo.metax.recyclerviewlib

import android.widget.Filterable

abstract class GMFilterableRecyclerAdapter<Element,
        ViewHolder : GMRecyclerViewHolder<Element>>
    : GMRecyclerAdapter<Element, ViewHolder>(), Filterable {
    var dataFiltered: MutableList<Element> = mutableListOf()

    override fun add(item: Element?, notifyDataSetChanged: Boolean) {
        super.add(item, false)
        updateDataFiltered(notifyDataSetChanged)
    }


    override fun replace(
        items: MutableList<Element>?,
        comparator: Comparator<Element>?,
        notifyDataSetChanged: Boolean
    ) {
        clear(false)
        super.replace(items, comparator, false)
        updateDataFiltered(notifyDataSetChanged)
    }

    override fun sort(comparator: Comparator<Element>) {
        super.sort(comparator)
        dataFiltered.sortWith(comparator)
    }

    override fun clear(notifyDataSetChanged: Boolean) {
        super.clear(false)
        dataFiltered.clear()
        if (notifyDataSetChanged)
            notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataFiltered.size

    override fun getItem(position: Int): Element = dataFiltered[position]

    private fun updateDataFiltered(notifyDataSetChanged: Boolean = true) {
        dataFiltered = data
        if (notifyDataSetChanged)
            notifyDataSetChanged()
    }

}
