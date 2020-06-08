package com.starter.anny.di.modules.ActivityModule.fragmentmodule

import com.starter.anny.di.scope.FragmentScoped
import com.starter.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.StoresFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.StoreItemsAndBuyFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart.CartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ShopAndOrderFragmentModule {
    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeShopAndOrderFragment(): ShopAndOrderFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeStoresFragment(): StoresFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeStoreItemsAndBuyFragment(): StoreItemsAndBuyFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeCartFragment(): CartFragment
}