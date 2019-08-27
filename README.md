# RecyclerViewLib

This is an abstract adapter for easier use of recyclerviews

The library and the sample project are writen in kotlin language, with the usage of android data binding.

## How to use
![Bintray](https://img.shields.io/bintray/v/metaxas4/GMRecyclerAdapter/RecyclerViewLib.svg)
![GitHub](https://img.shields.io/github/license/MeTaXaS4/RecyclerViewLib.svg)

add `implementation 'geo.metax.recyclerviewlib:GMRecyclerAdapter:1.2'` in your gradle file


## Library

### description
The sample app is a simple list of `Person`s that an item can be selected, this sample is mostly to show off the easier way to create an adapter that will have all the `add`, `remove`, `addAll` calls that in other project we will need to write again and again for all of ours adapters.

### files to check 

[GMRecyclerAdapter.kt](RecyclerAdapterLib/src/main/java/geo/metax/recyclerviewlib/GMRecyclerAdapter.kt)
The first abstract adapter class with calls as `add`,`remove`,`replace`,`addAll`,`clear`,`sort`,`getItem`, the adapter also keeps the last selected item and notifies the UI if the user has set that it needs this usage. Almost all calls has as a parameter a boolean value `notifyDataSetChanged` to not notify the UI if the develper don't wants (default is true).

[GMFilterableRecyclerAdapter.kt](RecyclerAdapterLib/src/main/java/geo/metax/recyclerviewlib/GMFilterableRecyclerAdapter.kt)
This abstract adapter extends our first adapter with the interface `android.widget.Filterable`, so the developer can set the Filter() as he/she wants

[GMRecyclerViewHolder.kt](RecyclerAdapterLib/src/main/java/geo/metax/recyclerviewlib/GMRecyclerViewHolder.kt)
a simple base `ViewHolder` with `onClick` implementation and some code for the selected item


## Sample project
### description
The sample app is a simple list of `Person`s that an item can be selected, this sample is mostly to show off the easier way to create an adapter that will have all the `add`, `remove`, `addAll` calls that in other project we will need to write again and again for all of ours adapters.

### files to check 

[MainActivity.kt](sampleproject/src/main/java/geo/metax/sampleproject/MainActivity.kt)
our sample activity, inflates the databinding view, creates a list of persons, setting the adapter to the `RecyclerView`

[Person.kt](sampleproject/src/main/java/geo/metax/sampleproject/Person.kt)
a data class that we use in the example

[PersonAdapter.kt](sampleproject/src/main/java/geo/metax/sampleproject/PersonAdapter.kt)
the most important part, the adapter that extends our library.
As you can see you have only to set the `ViewHolder` and to say which databinding object and res layout file to use.
In the constructor of the parent `ViewHolder` you can set if the items are selectable or not


[ext.kt](sampleproject/src/main/java/geo/metax/sampleproject/ext.kt)
2 extension functions for easier databinding-inflate

[res/layout/activity_main.xml](sampleproject/src/main/res/layout/activity_main.xml)
a simple databinding layout with `ConstraintLayout` and a `RecyclerView`, the `LayoutManager` is also set here for the `RecyclerView`

[res/layout/item_person.xml](sampleproject/src/main/res/layout/item_person.xml)
a simple databinding layout for the item view. Important note, the background we use is a selector(check below)

[res/drawable/selected_row.xml](sampleproject/src/main/res/drawable/selected_row.xml)
our background selector, changes the color based on the state of the item (selected or not)



