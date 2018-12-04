package geo.metax.sampleproject

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup

fun <T : ViewDataBinding> ViewGroup.inflateDataBindingView(layout: Int): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layout, this, false)

fun <T : ViewDataBinding> Activity.inflateDataBindingView(layout: Int): T = DataBindingUtil.setContentView(this, layout)

