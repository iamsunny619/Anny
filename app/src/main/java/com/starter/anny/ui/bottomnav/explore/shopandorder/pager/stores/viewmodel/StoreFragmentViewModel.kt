package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity
import com.starter.anny.domain.shopandpickup.usecase.GetShopAndPickUpUseCase
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.GetShopAndPickUpStoresData
import com.starter.anny.ui.utils.SingleLiveEvent
import com.starter.basestructure.ui.base.BaseObservableViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StoreFragmentViewModel @Inject constructor(
    val getShopAndPickUpUseCase: GetShopAndPickUpUseCase,
    val app: Application
) : BaseObservableViewModel(app) {

    private val _getShopAndPickUpStores = MutableLiveData<List<GetShopAndPickUpStoresData>?>()
    val getShopAndPickUpStores: LiveData<List<GetShopAndPickUpStoresData>?> =
        _getShopAndPickUpStores

    private val _errorLiveData = SingleLiveEvent<Throwable?>()
    val errorLiveData: LiveData<Throwable?> = _errorLiveData

    private val _progressLiveData = MutableLiveData<Boolean?>()
    val progressLiveData: LiveData<Boolean?> = _progressLiveData

    fun getStores(city: String) {
        var cityName = city
        if (cityName.isEmpty()) {
            cityName = "Blacksburg"
        }
        _progressLiveData.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                getShopAndPickUpUseCase(GetShopAndPickUpUseCase.Params(cityName))
            }.onSuccess {
                _getShopAndPickUpStores.postValue(it?.map { getShopAndPickUpStoresEntity ->
                    getShopAndPickUpStoresEntity.run {
                        GetShopAndPickUpStoresData(
                            bpId, categories?.map { category ->
                                category?.run {
                                    GetShopAndPickUpStoresData.Category(
                                        categoryId,
                                        categoryName,
                                        count,
                                        subCategories?.map { subCategory ->
                                            subCategory?.run {
                                                GetShopAndPickUpStoresData.Category.SubCategory(
                                                    categoryId,
                                                    count,
                                                    subCategoryId,
                                                    subCategoryName
                                                )
                                            }
                                        })
                                }
                            }, city,
                            imageURL,
                            retailerName,
                            state,
                            storeAddress,
                            storeid,
                            zipcode
                        )
                    }
                })
            }.onFailure {
                Log.e("errorFound", it.toString())
                _errorLiveData.postValue(it)
            }
            _progressLiveData.postValue(false)
        }
    }
}