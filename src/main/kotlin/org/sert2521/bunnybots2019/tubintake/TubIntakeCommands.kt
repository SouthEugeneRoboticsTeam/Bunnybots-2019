package org.sert2521.bunnybots2019.tubintake

import kotlinx.coroutines.cancel
import org.sert2521.bunnybots2019.oi.Controls
import org.sert2521.sertain.Robot
import org.sert2521.sertain.events.onTick
import org.sert2521.sertain.subsystems.doTask
import org.sert2521.sertain.subsystems.use

suspend fun Robot.teleopIntakeControl() = doTask {
    val intake = use<TubIntake>()
    action {
         val job = onTick {
             if(Controls.tubintakeInButton == true) {
                intake.spinIntake()
             } else if(Controls.tubintakeOutButton == true) {
                intake.spinOutake()
             } else {
                intake.stopSpin()
             }

             if(false/*Controls.ArmUpButton == true && intake.ArmRunning == false*/) {
                 intake.runArmToPosition(ARM_UP_TICKS)
             }

             if(false/*Controls.ArmDownButton == true && intake.ArmRunning == false*/) {
                 intake.runArmToPosition(ARM_DOWN_TICKS)
             }

         }
    }
}