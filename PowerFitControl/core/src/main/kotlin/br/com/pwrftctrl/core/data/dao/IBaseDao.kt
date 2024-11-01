package br.com.pwrftctrl.core.data.dao

import org.jetbrains.exposed.sql.Query

interface IBaseDao<T> {
  abstract fun getAll(): Query
  abstract fun getById(pk: Int): Query
  abstract fun insert(model: T): Int
  abstract fun update(model: T): Int
  abstract fun delete(pk: Int): Int
}
