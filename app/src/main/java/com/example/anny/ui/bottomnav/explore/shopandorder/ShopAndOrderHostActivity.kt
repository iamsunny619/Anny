package com.example.anny.ui.bottomnav.explore.shopandorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anny.R
import com.example.anny.databinding.ActivityShopAndOrderHostBinding
import com.example.anny.ui.base.BaseBindingActivity
import timber.log.Timber

class ShopAndOrderHostActivity :BaseBindingActivity<ActivityShopAndOrderHostBinding>(){
    override val contentView: Int
        get() = R.layout.activity_shop_and_order_host


    //this is a host fragment for the fragment only for the hosting purpose
    //can be use as a logic behind if u want to

    override fun viewModelSetUp() {

    }

    override fun viewSetUp() {
       Timber.d("Shop And Order View Created")
    }

    override fun createSavedInstanceState(savedInstanceState: Bundle?) {

    }

}