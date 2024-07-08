package com.example.sitter_carandai_test.data.prompts

val TROUBLE_SHOOTING_MANUAL: String = """
            [
                {
                  "Symptom": "Charging cannot be performed",
                  "Possible cause": "The Li-ion battery is already fully charged.",
                  "Possible solution": "Confirm the available Li-ion battery power remaining by checking Li-ion battery available charge gauge. If the gauge indicates full, the Li-ion battery is already fully charged and cannot be charged. Charging automatically turns off if the Li-ion battery is fully charged."
                },
                {
                  "Symptom": "Charging cannot be performed",
                  "Possible cause": "The 12-volt battery is discharged.",
                  "Possible solution": "The Li-ion battery cannot be charged if the vehicle electrical systems cannot be turned on. If the 12-volt battery is discharged, charge or jump start the 12-volt battery. See 'Jump starting' (P.6-15)."
                },
                {
                  "Symptom": "Charging cannot be performed",
                  "Possible cause": "The vehicle has a malfunction.",
                  "Possible solution": "The vehicle or charger may have a malfunction. Confirm if the warning light on the meter is illuminated. Confirm if the indicator on the charger is indicating a malfunction. If a warning is displayed, stop charging and consult a qualified electrician to have the outlet checked."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "There is no electrical power coming from the outlet.",
                  "Possible solution": "Confirm that there has not been a power failure. Make sure the circuit breaker is active. If an electrical outlet or charging station with a timer device installed is used, power will only be available at the time set by the timer."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "The plug is not connected correctly.",
                  "Possible solution": "Confirm the plug is connected correctly."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "There is no electrical power coming from the normal charging station.",
                  "Possible solution": "Confirm operation procedure of the charging station."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "The charge connector is not connected correctly.",
                  "Possible solution": "Confirm the charge connector is connected correctly."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "The EVSE or charging device may have a malfunction.",
                  "Possible solution": "If Genuine NISSAN EVSE is used, see 'Charging troubleshooting guide' (P.CH-50) for the device."
                },
                {
                  "Symptom": "Normal or trickle charge cannot be performed",
                  "Possible cause": "The outlet (that the EVSE is connected to) is not connected to the power source correctly.",
                  "Possible solution": "Confirm the condition according to the illumination pattern of the indicator light on the EVSE. For additional information, see 'NISSAN EVSE (Electric Vehicle Supply Equipment) control box indicator light' (P.CH-47)."
                },
                {
                  "Symptom": "Immediate charge cannot be performed",
                  "Possible cause": "Charging timer has been set.",
                  "Possible solution": "Push the immediate charge switch or turn off the charging timer. See 'Charging methods' (P.CH-43)."
                },
                {
                  "Symptom": "Timer charging cannot be performed",
                  "Possible cause": "The charge cable is not connected.",
                  "Possible solution": "Connect the charge cable."
                },
                {
                  "Symptom": "Timer charging cannot be performed",
                  "Possible cause": "The time on the clock is wrong.",
                  "Possible solution": "The charging timer does not start charging based on the clock located on the vehicle information display. Adjust the time. (See 'Clock' (P.2-29).) If the 12-volt battery is discharged or if the Li-ion battery is disconnected, the time setting must be updated."
                },
                {
                  "Symptom": "Timer charging cannot be performed",
                  "Possible cause": "Charging timer has not been set.",
                  "Possible solution": "Set the charging timer schedule. See 'Charging timer' (P.CH-43)."
                },
                {
                  "Symptom": "Timer charging cannot be performed",
                  "Possible cause": "Charging does not start because the charging timer start time and end time are set and the current time is before the set start time.",
                  "Possible solution": "Confirm when the charging timer time is set to start charging. Change the charging timer setting to the desired charge time or push the immediate charge switch. See 'Charging methods' (P.CH-43)."
                },
                {
                  "Symptom": "Timer charging cannot be performed",
                  "Possible cause": "The immediate charge switch is pushed.",
                  "Possible solution": "To cancel the immediate charge, push the immediate charge switch again while connecting the charge connector to the vehicle. The charge mode returns to a standby state."
                },
                {
                  "Symptom": "Normal charge stops during charging",
                  "Possible cause": "There is no electrical power coming from the outlet.",
                  "Possible solution": "There may have been an electrical power failure, or the circuit breaker may have failed. Charging will resume when the power source is reset."
                },
                {
                  "Symptom": "Normal charge stops during charging",
                  "Possible cause": "The charge cable has been disconnected.",
                  "Possible solution": "Check that the charge cable has not been disconnected."
                },
                {
                  "Symptom": "Normal charge stops during charging",
                  "Possible cause": "Charging timer end time has been reached.",
                  "Possible solution": "When the charging timer is set and the charge end time is reached, charging will be stopped, even if the Li-ion battery is not fully charged."
                },
                {
                  "Symptom": "Normal charge stops during charging",
                  "Possible cause": "The electrical power supply from the normal charging station was stopped.",
                  "Possible solution": "Confirm operation procedure of the charging station."
                },
                {
                  "Symptom": "Normal charge connector cannot be removed",
                  "Possible cause": "The charge connector lock is locked.",
                  "Possible solution": "Unlock the charge connector lock. See 'Unlock operation' (P.CH-41)."
                },
                {
                  "Symptom": "Normal charge connector cannot be removed",
                  "Possible cause": "The vehicle has a malfunction.",
                  "Possible solution": "If the normal charge connector cannot be removed when the connector has been unlocked, follow the unlocking steps. See 'If the charge connector cannot be unlocked' (P.CH-41)."
                },
                {
                  "Symptom": "Quick charge cannot be performed",
                  "Possible cause": "The quick charge connector is not connected correctly.",
                  "Possible solution": "Check that the charge connector is connected correctly. If it is not connected correctly, insert the charge connector straight into the charge port all the way in."
                },
                {
                  "Symptom": "Quick charge cannot be performed",
                  "Possible cause": "The self-diagnostic function of the quick charge device returns a negative result.",
                  "Possible solution": "There is a possibility that the vehicle has a malfunction. Stop charging and it is recommended that you contact a NISSAN certified ARIYA dealer."
                },
                {
                  "Symptom": "Quick charge cannot be performed",
                  "Possible cause": "The power switch of the quick charger is off.",
                  "Possible solution": "Check the power switch of the quick charger."
                },
                {
                  "Symptom": "Quick charge stops during charging",
                  "Possible cause": "Charging is stopped by the quick charge timer.",
                  "Possible solution": "Charging will stop depending on the timer function setting of the quick charge device. If you need to charge the Li-ion battery more, start the charging procedure again."
                },
                {
                  "Symptom": "Quick charge stops during charging",
                  "Possible cause": "The power supply for the quick charger is off.",
                  "Possible solution": "Check whether the power supply for the quick charger is off."
                },
                {
                  "Symptom": "Quick charge connector cannot be removed",
                  "Possible cause": "The charge connector is locked.",
                  "Possible solution": "If it is necessary to remove the charge connector without starting to charge, wait at least 3 minutes until the data communication between the vehicle and the quick charger is stopped, then unlock the vehicle's door from the locked state. If the vehicle's door is already unlocked, lock it first then unlock it."
                },
                {
                  "Symptom": "Quick charge connector cannot be removed",
                  "Possible cause": "The vehicle has a malfunction.",
                  "Possible solution": "If the quick charge connector cannot be removed when the connector has been unlocked, follow the unlocking steps. See 'If the charge connector cannot be unlocked' (P.CH-41)."
                }
            ]
""".trimIndent()