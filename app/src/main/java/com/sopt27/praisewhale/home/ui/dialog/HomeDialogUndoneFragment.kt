package com.sopt27.praisewhale.home.ui.dialog

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.sopt27.praisewhale.MainActivity
import com.sopt27.praisewhale.R
import com.sopt27.praisewhale.databinding.DialogHomeResultBinding
import com.sopt27.praisewhale.home.ui.HomeFragment
import com.sopt27.praisewhale.util.COUNT_UNDONE
import com.sopt27.praisewhale.util.LAST_PRAISE_STATUS
import com.sopt27.praisewhale.util.MyApplication


class HomeDialogUndoneFragment : DialogFragment() {

    private var _viewBinding: DialogHomeResultBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val sharedPreferences = MyApplication.mySharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = DialogHomeResultBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setDialogContents()
    }

    override fun onResume() {
        super.onResume()
        setDialogBackground()
    }

    private fun setListeners() {
        viewBinding.apply {
            imageButtonClose.setOnClickListener(fragmentClickListener)
            buttonConfirm.setOnClickListener(fragmentClickListener)
        }
    }

    private fun setDialogContents() {
        when (sharedPreferences.getValue(COUNT_UNDONE, "0").toInt()) {
            0, 1 -> {
                viewBinding.apply {
                    textViewTitle.text = "아쉽고래!"
                    textViewSubTitle.text = "내일은 꼭 칭찬해요!"
                    imageViewWhale.setImageResource(R.drawable.no_1_img_whale)
                }
            }
            2, 3 -> {
                viewBinding.apply {
                    textViewTitle.text = "춤 추고 싶고래.."
                    textViewSubTitle.text = "칭찬으로 저를 춤 추게 해주세요!"
                    imageViewWhale.setImageResource(R.drawable.no_2_img_whale)
                }
            }
            4, 5 -> {
                viewBinding.apply {
                    textViewTitle.text = "고래고래 소리지를고래!"
                    textViewSubTitle.text = "칭찬하는 습관을 가져봐요!"
                    imageViewWhale.setImageResource(R.drawable.no_3_img_whale)
                }
            }
        }
    }

    private fun setDialogBackground() {
        val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
        val dialogHorizontalMargin = (Resources.getSystem().displayMetrics.density * 42) * 2
        dialog!!.window!!.apply {
            setLayout((deviceWidth - dialogHorizontalMargin).toInt(), WindowManager.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawableResource(R.drawable.background_rectangle_radius_15_stroke_2)
        }
    }

    private val fragmentClickListener = View.OnClickListener {
        viewBinding.apply {
            when (it.id) {
                imageButtonClose.id -> {
                    dialog!!.dismiss()
                }
                buttonConfirm.id -> {
                    dialog!!.dismiss()
                    updateHomeFragmentView()
                    updateSharedPreferences()
                }
            }
        }
    }

    private fun updateHomeFragmentView() {
        sharedPreferences.setValue(LAST_PRAISE_STATUS, "undone")
        (activity as MainActivity).changeFragment(HomeFragment())
    }

    private fun updateSharedPreferences() {
        sharedPreferences.apply {
            when (val countUndone = getValue(COUNT_UNDONE, "0").toInt()) {
                5 -> setValue(COUNT_UNDONE, "0")
                else -> setValue(COUNT_UNDONE, (countUndone + 1).toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }


    class CustomDialogBuilder {
        private val dialog = HomeDialogUndoneFragment()

        fun create(): HomeDialogUndoneFragment {
            return dialog
        }
    }
}