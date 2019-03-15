package geo.metax.sampleproject

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup

fun <T : ViewDataBinding> ViewGroup.inflateDataBindingView(layout: Int): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layout, this, false)

fun <T : ViewDataBinding> Activity.inflateDataBindingView(layout: Int): T = DataBindingUtil.setContentView(this, layout)

