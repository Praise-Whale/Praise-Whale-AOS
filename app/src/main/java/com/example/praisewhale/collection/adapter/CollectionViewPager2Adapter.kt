package com.example.praisewhale.collection.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.praisewhale.collection.ui.CollectionTabFragment
import com.example.praisewhale.collection.ui.PraiseRankingCardFragment


class CollectionViewPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CollectionTabFragment()
            1 -> PraiseRankingCardFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}