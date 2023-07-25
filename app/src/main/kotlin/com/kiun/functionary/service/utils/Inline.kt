package com.kiun.functionary.service.utils

inline fun<T> Array<T>.mapOfLine():Map<T, T> {

    var map = HashMap<T, T>()
    for (i in this.indices step 2){
        map[this[i]] = this[i+1]
    }
    return map
}
