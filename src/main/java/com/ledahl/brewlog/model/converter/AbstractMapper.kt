package com.ledahl.brewlog.model.converter

abstract class Mapper<in T , out V> {
    abstract fun map(v: T?) : V?
    abstract fun map(v: List<T>?) : List<V?>
}