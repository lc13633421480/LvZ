package com.sprout.vm.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.sprout.base.BaseViewModel
import com.sprout.model.BrandData
import com.sprout.model.GoodData

import com.sprout.net.Injection

import kotlinx.coroutines.launch

class TagsViewModel:BaseViewModel(Injection.repository) {

    var bList:MutableLiveData<BrandData> = MutableLiveData()
    var gList:MutableLiveData<GoodData> = MutableLiveData()

    var bpage = 0
    var gpage = 0
    var size = 10

    fun getBrand(){
        viewModelScope.launch {
            var result = repository.getBrand(bpage,size)
            if(result.errno == 0){
                bList.postValue(result.data)
            }
        }
    }

    fun getGood(){
        viewModelScope.launch {
            var result = repository.getGood(gpage,size)
            if(result.errno == 0){
                gList.postValue(result.data)
            }
        }
    }

}