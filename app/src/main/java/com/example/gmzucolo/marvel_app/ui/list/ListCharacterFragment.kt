package com.example.gmzucolo.marvel_app.ui.list

import androidx.fragment.app.viewModels
import com.example.gmzucolo.marvel_app.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCharacterFragment : BaseFragment<ListCharacterViewModel>() {
    override val viewModel: ListCharacterViewModel by viewModels()
}