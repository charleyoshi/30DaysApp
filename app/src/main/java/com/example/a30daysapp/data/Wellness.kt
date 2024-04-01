package com.example.a30daysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Wellness(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val day: Int,
    @StringRes val text: Int
)



val wellnesses = listOf(
    Wellness(R.drawable.day1, R.string.wellness_name1, 1, R.string.wellness_text1),
    Wellness(R.drawable.day2, R.string.wellness_name2, 2, R.string.wellness_text2),
    Wellness(R.drawable.day3, R.string.wellness_name3, 3, R.string.wellness_text3),
    Wellness(R.drawable.day4, R.string.wellness_name4, 4, R.string.wellness_text4),
    Wellness(R.drawable.day5, R.string.wellness_name5, 5, R.string.wellness_text5),
    Wellness(R.drawable.day6, R.string.wellness_name6, 6, R.string.wellness_text6),
    Wellness(R.drawable.day7, R.string.wellness_name7, 7, R.string.wellness_text7),
    Wellness(R.drawable.day8, R.string.wellness_name8, 8, R.string.wellness_text8),
    Wellness(R.drawable.day9, R.string.wellness_name9, 9, R.string.wellness_text9),
    Wellness(R.drawable.day10, R.string.wellness_name10, 10, R.string.wellness_text10),
    Wellness(R.drawable.day11, R.string.wellness_name11, 11, R.string.wellness_text11),
    Wellness(R.drawable.day12, R.string.wellness_name12, 12, R.string.wellness_text12),
    Wellness(R.drawable.day13, R.string.wellness_name13, 13, R.string.wellness_text13),
    Wellness(R.drawable.day14, R.string.wellness_name14, 14, R.string.wellness_text14),
    Wellness(R.drawable.day15, R.string.wellness_name15, 15, R.string.wellness_text15),
    Wellness(R.drawable.day16, R.string.wellness_name16, 16, R.string.wellness_text16),
    Wellness(R.drawable.day17, R.string.wellness_name17, 17, R.string.wellness_text17),
    Wellness(R.drawable.day18, R.string.wellness_name18, 18, R.string.wellness_text18),
    Wellness(R.drawable.day19, R.string.wellness_name19, 19, R.string.wellness_text19),
    Wellness(R.drawable.day20, R.string.wellness_name20, 20, R.string.wellness_text20),
    Wellness(R.drawable.day21, R.string.wellness_name21, 21, R.string.wellness_text21),
    Wellness(R.drawable.day22, R.string.wellness_name22, 22, R.string.wellness_text22),
    Wellness(R.drawable.day23, R.string.wellness_name23, 23, R.string.wellness_text23),
    Wellness(R.drawable.day24, R.string.wellness_name24, 24, R.string.wellness_text24),
    Wellness(R.drawable.day25, R.string.wellness_name25, 25, R.string.wellness_text25),
    Wellness(R.drawable.day26, R.string.wellness_name26, 26, R.string.wellness_text26),
    Wellness(R.drawable.day27, R.string.wellness_name27, 27, R.string.wellness_text27),
    Wellness(R.drawable.day28, R.string.wellness_name28, 28, R.string.wellness_text28),
    Wellness(R.drawable.day29, R.string.wellness_name29, 29, R.string.wellness_text29),
    Wellness(R.drawable.day30, R.string.wellness_name30, 30, R.string.wellness_text30)
)


