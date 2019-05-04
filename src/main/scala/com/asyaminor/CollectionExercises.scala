package com.asyaminor

object CollectionExercises {
  // 6.8.4.1 Union of Sets
  def union[T](set1: Set[T], set2: Set[T]): Set[T] = {
    set2.foldLeft(set1)((acc, item) => {
      if (acc.contains(item)) { acc }
      else { acc + item }
    })
  }

  // 6.8.4.2 Union of Maps
  def union[T](map1: Map[T, Int], map2: Map[T, Int]): Map[T, Int] = {
    map1.foldLeft(map2)((m, item) => {
      m.get(item._1) match {
        case Some(i) => m.updated(item._1, i + item._2)
        case None => m + item
      }
    })
  }
}
