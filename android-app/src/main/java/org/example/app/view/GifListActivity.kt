package org.example.app.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.MvvmActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import org.example.app.AppComponent
import org.example.app.BR
import org.example.app.R
import org.example.app.databinding.ActivityGifListBinding
import org.example.library.domain.entity.Gif
import org.example.library.feature.list.presentation.ListViewModel

class GifListActivity : MvvmActivity<ActivityGifListBinding, ListViewModel<Gif>>() {
    override val layoutId: Int = R.layout.activity_gif_list
    override val viewModelClass = ListViewModel::class.java as Class<ListViewModel<Gif>>
    override val viewModelVariableId: Int = BR.viewModel

    override fun viewModelFactory(): ViewModelProvider.Factory = createViewModelFactory {
        AppComponent.factory.gifsFactory.createListViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding.refreshLayout) {
            setOnRefreshListener {
                viewModel.onRefresh { isRefreshing = false }
            }
        }
    }
}
