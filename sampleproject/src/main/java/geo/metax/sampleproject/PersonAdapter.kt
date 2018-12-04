package geo.metax.sampleproject

import android.view.ViewGroup
import android.widget.Toast
import geo.metax.recyclerviewlib.GMRecyclerAdapter
import geo.metax.recyclerviewlib.GMRecyclerViewHolder
import geo.metax.sampleproject.databinding.ItemPersonBinding

class PersonAdapter : GMRecyclerAdapter<Person, PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(parent.inflateDataBindingView(R.layout.item_person))

    class PersonViewHolder(private val itemPersonBinding: ItemPersonBinding) :
        GMRecyclerViewHolder<Person>(itemPersonBinding, true) {
        override fun bindModel(item: Person, selected: Boolean) {
            super.bindModel(item, selected)
            itemPersonBinding.item = item

            callbackForItemSelected = {
                Toast.makeText(itemPersonBinding.root.context, it.fullName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

