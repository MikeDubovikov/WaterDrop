package com.mdubovikov.waterdrop.presentation.details

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mdubovikov.waterdrop.R
import com.mdubovikov.waterdrop.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding ?: throw IllegalStateException("Fragment $this binding cannot be accessed")

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            goodsId.text = "${resources.getText(R.string.id)}: ${args.goodsId}"
            goodsPrice.text = "${resources.getText(R.string.price)}: ${args.goodsPrice}"
            Glide.with(goodsImage)
                .load(Uri.parse(args.goodsImage))
                .into(goodsImage)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}