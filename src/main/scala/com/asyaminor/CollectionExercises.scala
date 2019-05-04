package com.asyaminor

object CollectionExercises {
  // 6.8.4.1 Union of Sets
  def union[T](set1: Set[T], set2: Set[T]): Set[T] = {
    set2.foldLeft(set1)((acc, item) => {
      if (acc.contains(item)) { acc }
      else { acc + item }
    })
  }
}
