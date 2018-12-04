package geo.metax.recyclerviewlib

import android.support.v7.widget.RecyclerView

abstract class GMRecyclerViewHolder<Element>(
    private val dataBindingView: android.databinding.ViewDataBinding,
    private val enableSelection: Boolean = false
) : RecyclerView.ViewHolder(dataBindingView.root) {
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