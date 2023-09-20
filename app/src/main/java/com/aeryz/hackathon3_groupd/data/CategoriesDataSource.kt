package com.aeryz.hackathon3_groupd.data

import com.aeryz.hackathon3_groupd.model.Categories

interface CategoriesDataSource{
    fun getCategories(): List<Categories>
}

class CategoriesDataSourceImpl : CategoriesDataSource {
    override fun getCategories(): List<Categories> = listOf(
        Categories(
            position = 1,
            name = "Groceries",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_groceries.png"
        ),
        Categories(
            position = 2,
            name = "Fruits",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_fruits.png"
        ),
        Categories(
            position = 3,
            name = "Spices",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_spices.png"
        ),
        Categories(
            position = 4,
            name = "Herbs",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_herbs.png"
        ),
        Categories(
            position = 5,
            name = "Seasoning",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_seasoning.png"
        ),
        Categories(
            position = 6,
            name = "Meat",
            imgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_meat.png"
        )
    )


}