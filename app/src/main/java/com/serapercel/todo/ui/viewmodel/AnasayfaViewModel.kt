package com.serapercel.todo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serapercel.todo.data.entity.YapilacakIs
import com.serapercel.todo.data.repo.YapilacakIsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    val yirepo = YapilacakIsRepository()
    var isListesi = MutableLiveData<List<YapilacakIs>>()

    init {
        isleriYukle()
    }

    fun isleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            isListesi.value = yirepo.isleriYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            isListesi.value = yirepo.ara(aramaKelimesi)
        }
    }

    fun sil(yapilacak_is_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            yirepo.sil(yapilacak_is_id)
        }
    }
}