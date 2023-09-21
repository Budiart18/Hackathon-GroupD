package com.aeryz.hackathon3_groupd.data

import com.aeryz.hackathon3_groupd.model.Categories

interface CategoriesDataSource{
    fun getCategories(): List<Categories>
}

class CategoriesDataSourceImpl : CategoriesDataSource {
    override fun getCategories(): List<Categories> = listOf(
        Categories(
            name = "Groceries",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_groceries.png"
        ),
        Categories(
            name = "Fruits",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_fruits.png"
        ),
        Categories(
            name = "Spices",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_spices.png"
        ),
        Categories(
            name = "Herbs",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_herbs.png"
        ),
        Categories(
            name = "Seasoning",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_seasoning.png"
        ),
        Categories(
            name = "Meat",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_meat.png"
        )
    )
}