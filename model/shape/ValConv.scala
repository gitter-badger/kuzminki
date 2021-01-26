package kuzminki.model

import io.rdbc.sapi.Row


trait ValConv[T] {
  def get(row: Row, index: Int): T
}




