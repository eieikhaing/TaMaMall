package com.kinetichub.tamamall.ui.home

import MyCommunityFragment
import NewsFeedFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kinetichub.tamamall.R
import com.kinetichub.tamamall.base.BaseFragment
import com.kinetichub.tamamall.databinding.FragmentHomeBinding
import com.kinetichub.tamamall.ui.common_pager_adapter.CommonPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    private var currentTab: Int = 0

    override fun observeViewModel() {
    }

    private var viewPagerFragments = listOf(
        MyCommunityFragment(),
        NewsFeedFragment()
    )

    override fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tabLayout = binding.tblHome
        val viewPager = binding.viewpager
        val pagerAdapter =
            CommonPagerAdapter(
                this, viewPagerFragments
            )
        viewPager.adapter = pagerAdapter
        viewPager.isSaveEnabled = false
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.newsfeed)
                1 -> tab.text = getString(R.string.my_community)
            }
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                currentTab = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        return binding.root
    }
}