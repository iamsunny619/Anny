package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores

import android.app.SearchManager
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.starter.anny.R
import com.starter.anny.databinding.FragmentStoresBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.rcadapter.StoreShopListAdapter
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.viewmodel.StoreFragmentViewModel
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.extension.observeNotNull
import com.starter.anny.ui.utils.hideSoftInput
import kotlinx.android.synthetic.main.fragment_stores.*
import javax.inject.Inject


class StoresFragment : BaseBindingFragment<FragmentStoresBinding>(),
    SwipeRefreshLayout.OnRefreshListener {
    override val content: Int
        get() = R.layout.fragment_stores

    private val parentNavController
        get() = requireParentFragment().findNavController()

    private lateinit var mediaPlayer: MediaPlayer

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val storeFragmentViewModel by activityViewModels<StoreFragmentViewModel> { viewModelFactory }

    /* val img1: Int = R.drawable.bg_img_food_dummy
     val img2: Int = R.drawable.bg_img_dummydemo
     val img3: Int = R.drawable.bg_img_food_dummy*/

    private lateinit var storeShopListAdapter: StoreShopListAdapter

    override fun viewModelSetUp() {

        storeFragmentViewModel.getStores("Blacksburg")

        storeFragmentViewModel.progressLiveData.observeNotNull(this) {
            swipeRL?.isRefreshing = if (it) {
                swipeRL.hideSoftInput()
                true
            } else false
        }

        storeFragmentViewModel.errorLiveData.observeNotNull(this) {
            Boast.makeText(requireContext(), it.message.orEmpty())
        }

        storeFragmentViewModel.getShopAndPickUpStores.observe(this, Observer {
            if (it != null && it.isNotEmpty()) {
                storeShopListAdapter.items = it
                Log.d("aaa", it.toString())
            }
        })
    }

    override fun viewSetUp() {

        initMedia()
        initSearchView()
        initShopListRecycler()
        swipeRL.setOnRefreshListener(this)

    }

    private fun initMedia() {
        mediaPlayer = MediaPlayer.create(requireContext(),R.raw.twitter)
    }

    private fun initSearchView() {
        val searchManager =
            requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                storeShopListAdapter.filter.filter(query.toString().trim())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                storeShopListAdapter.filter.filter(newText.toString().trim())
                return false
            }
        })

//custom Search text and size
        /*val searchView =
            searchView.findViewById(com.google.android.material.R.id.search_plate) as View
        searchView.background = null

        val searchText =
            searchView.findViewById(com.google.android.material.R.id.search_src_text) as AutoCompleteTextView
        searchText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue_323b94))
        searchText.typeface = ResourcesCompat.getFont(requireContext(), R.font.montserrat_regular)*/
    }

    private fun initShopListRecycler() {
        storeShopListAdapter = StoreShopListAdapter(emptyList())
        { _, _, item ->
            Boast.makeText(requireContext(), item?.retailerName.toString(), Toast.LENGTH_SHORT)
                .show()
            //  val args =
//                    ShopAndOrderFragmentDirections.actionShopAndOrderFragmentToStoreItemsAndBuyFragment(
//                        item
//                    )
            // parentNavController.navigate(args)
        }

        storeShopListAdapter.listFound = { i ->
            setListFound(i)
        }

        rvShopStoresList.setHasFixedSize(true)
        rvShopStoresList.itemAnimator = DefaultItemAnimator()
        rvShopStoresList.adapter = storeShopListAdapter
        setListFound(storeShopListAdapter.itemCount)
    }

    private fun setListFound(i: Int) {
        if (i < 1) {
            txtResultFound.text = i.toString() + " items found"
        } else {
            txtResultFound.text = i.toString() + " items found"
        }
    }

    override fun onRefresh() {
        mediaPlayer.start()
        swipeRL.isRefreshing = false
        swipeRL.hideSoftInput()
    }
}