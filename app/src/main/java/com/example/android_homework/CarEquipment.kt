package com.example.android_homework

class CarEquipment  (val equip: Assembler){

        fun howMuchHorsePower() = equip.horsepower
        fun drive() = equip.awd
        fun whatFuelType() = equip.fuelType
        fun howMuchPassengers() = equip.passengerCapacity


        companion object Assembler{
            var horsepower: Int = 100
            var awd: Boolean = false
            var fuelType: String = "Diesel"
            var passengerCapacity: Int = 4

            fun setHorsepower(horsepower: Int) = apply {this.horsepower = horsepower}
            fun setAwd(awd: Boolean) = apply { this.awd = awd }
            fun setPassengerCapacity(passengerCapacity: Int) = apply { this.passengerCapacity = passengerCapacity }
            fun setFuelType(fuelType: String) = apply { this.fuelType = fuelType }

            fun equip(): CarEquipment {
                return CarEquipment(this)
            }
        }

}