package com.twf.tritimings.domain

class CalculateTimeUseCase() {
    operator fun invoke(unit: Unit, sport: Sport, distance: Distance, pace: Double) {
        when(sport) {
         Sport.Run -> calculateRun(unit, distance, pace)
         Sport.Swim -> calculateSwim(unit, distance, pace)
         Sport.Bike -> calculateBike(unit, distance, pace)
        }
    }

    private fun calculateSwim(unit: Unit, distance: Distance, pace: Double) {
    }

    private fun calculateBike(unit: Unit, distance: Distance, pace: Double) {}

    private fun calculateRun(unit: Unit, distance: Distance, pace: Double) {}

}



