package com.kiun.functionary.utils


inline fun List<String>.pairMap() : MutableMap<String, String>{

    if (this.size % 2 != 0){
        throw Exception("数组长度必须为偶数")
    }

    val map = HashMap<String, String>()
    for (i in 0 until this.size step 2){
        map[this[i]] = this[i+1]
    }
    return map
}

inline fun<K,V> Map<K, V>.getKey(v: V): K? {

    for (entry in this){
        if(entry.value == v){
            return entry.key
        }
    }
    return null
}

inline fun<K,V> Map<K, V>.hasValue(v: V): Boolean {

    for (entry in this){
        if(entry.value == v){
            return true
        }
    }
    return false
}
