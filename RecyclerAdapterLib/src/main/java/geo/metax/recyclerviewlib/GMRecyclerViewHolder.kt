package geo.metax.recyclerviewlib

import androidx.recyclerview.widget.RecyclerView

abstract class GMRecyclerViewHolder<Element>(
    private val dataBindingView: androidx.databinding.ViewDataBinding,
    private val enableSelection: Boolean = false
) : androidx.recyclerview.widget.RecyclerView.ViewHolder(dataBindingView.root) {
    open fun bindModel(item: Element, selected: Boolean = false) {
        if (enableSelection)
            dataBindingView.root.isSelected = selected

        dataBindingView.root.setOnClickListener {
            if (enableSelection)
                selectedCallback.invoke()
            callbackForItemSelected?.invoke(item)
        }
    }

    protected var callbackForItemSelected: ((item: Element) -> Unit)? = null
    lateinit var selectedCallback: (() -> Unit)

    fun onClick() {
        dataBindingView.root.performClick()
    }

}