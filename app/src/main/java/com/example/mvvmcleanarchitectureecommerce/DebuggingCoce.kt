package com.example.mvvmcleanarchitectureecommerce

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = hashMapOf<Int, Int>()
    for (num in nums1) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val result = mutableListOf<Int>()
    for (num in nums2) {
        if (map.getOrDefault(num, 0) > 0) {
            result.add(num)
            map[num] = map[num]!! - 1
        }
    }

    return result.toIntArray()
}

fun main() {
    println(intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString())
    println(intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).joinToString())
}