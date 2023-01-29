package com.example.gmzucolo.marvel_app.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM: ViewModel> : Fragment() {

    protected abstract val viewModel: VM
}