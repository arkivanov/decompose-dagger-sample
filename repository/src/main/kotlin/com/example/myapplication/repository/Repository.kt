package com.example.myapplication.repository

interface Repository {

    fun getItems(): List<Item>

    fun getItem(id: String): Item
}

