package com.himo.OMCW.data.model

data class Item(
    val id: String,
    val name: String,
    val category: String,
    val image: String,
    val description: String,
    val stackSize: Int = 64,
    val howToObtain: List<ObtainMethod> = emptyList(),
    val usedIn: List<String> = emptyList(),
    val relatedItems: List<String> = emptyList()
)

data class ObtainMethod(
    val method: String,
    val source: String? = null,
    val tool: String? = null,
    val description: String
)

data class ItemsData(
    val items: List<Item>
)
