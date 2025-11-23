package com.himo.OMCW.data.repository

import com.himo.OMCW.data.datasource.LocalDataSource
import com.himo.OMCW.data.model.Category
import com.himo.OMCW.data.model.Item

class ItemRepository(private val dataSource: LocalDataSource) {
    private var allItems: List<Item> = emptyList()
    private var allCategories: List<Category> = emptyList()

    init {
        loadData()
    }

    private fun loadData() {
        allItems = dataSource.loadItems().items
        allCategories = dataSource.loadCategories().categories
    }

    fun getAllItems(): List<Item> = allItems

    fun getItemById(id: String): Item? = allItems.find { it.id == id }

    fun searchItems(query: String): List<Item> {
        if (query.isBlank()) return allItems
        return allItems.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true)
        }
    }

    fun getItemsByCategory(category: String): List<Item> {
        return allItems.filter { it.category == category }
    }

    fun getAllCategories(): List<Category> = allCategories
}
