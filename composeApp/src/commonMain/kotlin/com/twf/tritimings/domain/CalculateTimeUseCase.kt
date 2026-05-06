package com.twf.tritimings.domain

class CalculateTimeUseCase() {
    operator fun invoke(unit: Unit, sport: Sport, distance: Distance, paceInput: Double?): Double? {
        if (paceInput == null || paceInput <= 0.0) {
            return null
        }

        return when (sport) {
            Sport.Run -> calculateRun(unit, distance, paceInput)
            Sport.Swim -> calculateSwim(unit, distance, paceInput)
            Sport.Bike -> calculateBike(unit, distance, paceInput)
        }
    }

    private fun calculateSwim(unit: Unit, distance: Distance, pace: Double): Double {
        fun calcMetricSwim(): Double {
            return when (distance) {
                is Distance.Custom -> (distance.distance * 100) / pace
                Distance.HalfIron -> (HALF_IRON_SWIM_M * 100) / pace
                Distance.Iron -> (FULL_IRON_SWIM_M * 100) / pace
                Distance.Olympic -> (OLYMPIC_SWIM_M * 100) / pace
                Distance.Sprint -> (SPRINT_SWIM_M * 100) / pace
            }
        }

        fun calcImperialSwim(): Double {
            return when (distance) {
                is Distance.Custom -> (distance.distance * 100) / pace
                Distance.HalfIron -> (HALF_IRON_SWIM_Y * 100) / pace
                Distance.Iron -> (FULL_IRON_SWIM_Y * 100) / pace
                Distance.Olympic -> (OLYMPIC_SWIM_Y * 100) / pace
                Distance.Sprint -> (SPRINT_SWIM_Y * 100) / pace
            }
        }
        return when (unit) {
            Unit.Metric -> calcMetricSwim()
            Unit.Imperial -> calcImperialSwim()
        }
    }

    private fun calculateBike(unit: Unit, distance: Distance, pace: Double): Double {
        val timeHours = when (unit) {
            Unit.Metric -> when (distance) {
                is Distance.Custom -> distance.distance / pace
                Distance.HalfIron -> HALF_IRON_BIKE_KM / pace
                Distance.Iron -> FULL_IRON_BIKE_KM / pace
                Distance.Olympic -> OLYMPIC_BIKE_KM / pace
                Distance.Sprint -> SPRINT_BIKE_KM / pace
            }
            Unit.Imperial -> when (distance) {
                is Distance.Custom -> distance.distance / pace
                Distance.HalfIron -> HALF_IRON_BIKE_MI / pace
                Distance.Iron -> FULL_IRON_BIKE_MI / pace
                Distance.Olympic -> OLYMPIC_BIKE_MI / pace
                Distance.Sprint -> SPRINT_BIKE_MI / pace
            }
        }
        return (timeHours * 3600)
    }

    private fun calculateRun(unit: Unit, distance: Distance, pace: Double): Double {
        return when (unit) {
            Unit.Metric -> when (distance) {
                is Distance.Custom -> distance.distance * pace
                Distance.HalfIron -> HALF_IRON_RUN_KM * pace
                Distance.Iron -> FULL_IRON_RUN_KM * pace
                Distance.Olympic -> OLYMPIC_RUN_KM * pace
                Distance.Sprint -> SPRINT_RUN_KM * pace
            }
            Unit.Imperial -> when (distance) {
                is Distance.Custom -> distance.distance * pace
                Distance.HalfIron -> HALF_IRON_RUN_MI * pace
                Distance.Iron -> FULL_IRON_RUN_MI * pace
                Distance.Olympic -> OLYMPIC_RUN_MI * pace
                Distance.Sprint -> SPRINT_RUN_MI * pace
            }
        }
    }
}
