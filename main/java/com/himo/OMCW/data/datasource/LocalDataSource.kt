package com.himo.OMCW.data.datasource

import android.content.Context
import com.google.gson.Gson
import com.himo.OMCW.data.model.CategoriesData
import com.himo.OMCW.data.model.ItemsData
import java.io.InputStreamReader

class LocalDataSource(private val context: Context) {
    private val gson = Gson()

    fun loadItems(): ItemsData {
        return try {
            val inputStream = context.resources.openRawResource(
                context.resources.getIdentifier("items", "raw", context.packageName)
            )
            val reader = InputStreamReader(inputStream)
            gson.fromJson(reader, ItemsData::class.java)
        } catch (e: Exception) {
            ItemsData(emptyList())
        }
    }

    fun loadCategories(): CategoriesData {
        return try {
            val inputStream = context.resources.openRawResource(
                context.resources.getIdentifier("categories", "raw", context.packageName)
            )
            val reader = InputStreamReader(inputStream)
            gson.fromJson(reader, CategoriesData::class.java)
        } catch (e: Exception) {
            CategoriesData(emptyList())
        }
    }
}
