package com.kinetichub.tamamall.ui.common_pager_adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CommonPagerAdapter(fragment: Fragment, private var fragments: List<Fragment>?) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragments!!.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments!![position]
    }

    private fun newInstance(fragment: Fragment, position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString(CommonPagerAdapter.PAGER_ARGUMENT, position.toString())
        fragment.arguments = bundle
        return fragment
    }

    companion object {
        const val PAGER_ARGUMENT = "pager_argument"
    }

}