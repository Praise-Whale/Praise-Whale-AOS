package com.sopt27.praisewhale.collection.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sopt27.praisewhale.collection.ui.CardFragment
import com.sopt27.praisewhale.collection.ui.PraiseRankingFragment


class CollectionTabViewPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CardFragment()
            1 -> PraiseRankingFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}