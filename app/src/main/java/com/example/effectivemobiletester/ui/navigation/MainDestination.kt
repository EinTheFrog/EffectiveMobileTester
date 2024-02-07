package com.example.effectivemobiletester.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.effectivemobiletester.R

enum class MainDestination(val route: String, @DrawableRes val icon: Int, @StringRes val label: Int) {
    MAIN("main_main", R.drawable.ic_main_24, R.string.main),
    CATALOG("main_catalog", R.drawable.ic_catalog_24, R.string.catalog),
    CART("main_cart", R.drawable.ic_cart_24, R.string.cart),
    DISCOUNTS("main_discounts", R.drawable.ic_discount_24, R.string.discounts),
    PROFILE("main_profile", R.drawable.ic_profile_24, R.string.profile);

    companion object {
        fun getByRoute(route: String): MainDestination {
            return when (route) {
                "main_main" -> MAIN
                "main_catalog" -> CATALOG
                "main_cart" -> CART
                "main_discounts" -> DISCOUNTS
                "main_profile" -> PROFILE
                else -> throw IllegalArgumentException()
            }
        }
    }
}