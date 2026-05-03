package com.twf.tritimings.domain

sealed class Unit {
    data object Metric: Unit()
    data object Imperial: Unit()
}

sealed class Sport {
    data object Swim: Sport()
    data object Bike: Sport()
    data object Run: Sport()
}

sealed class Distance {
    data object Sprint: Distance()
    data object Olympic: Distance()
    data object HalfIron: Distance()
    data object Iron: Distance()
    data class Custom(val distance: Int): Distance()
}

// --- SPRINT ---
const val SPRINT_SWIM_M = 750
const val SPRINT_SWIM_Y = 820
const val SPRINT_BIKE_KM = 20.0
const val SPRINT_BIKE_MI = 12.4
const val SPRINT_RUN_KM = 5.0
const val SPRINT_RUN_MI = 3.1

// --- OLYMPIC (Standard) ---
const val OLYMPIC_SWIM_M = 1500
const val OLYMPIC_SWIM_Y = 1640
const val OLYMPIC_BIKE_KM = 40.0
const val OLYMPIC_BIKE_MI = 24.8
const val OLYMPIC_RUN_KM = 10.0
const val OLYMPIC_RUN_MI = 6.2

// --- HALF-IRONMAN (70.3) ---
const val HALF_IRON_SWIM_M = 1900
const val HALF_IRON_SWIM_Y = 2100 // Approx 1.2 miles
const val HALF_IRON_BIKE_KM = 90.0
const val HALF_IRON_BIKE_MI = 56.0
const val HALF_IRON_RUN_KM = 21.1
const val HALF_IRON_RUN_MI = 13.1

// --- FULL IRONMAN (140.6) ---
const val FULL_IRON_SWIM_M = 3800
const val FULL_IRON_SWIM_Y = 4220 // Approx 2.4 miles
const val FULL_IRON_BIKE_KM = 180.0
const val FULL_IRON_BIKE_MI = 112.0
const val FULL_IRON_RUN_KM = 42.2
const val FULL_IRON_RUN_MI = 26.2
