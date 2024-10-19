    package org.firstinspires.ftc.teamcode;

    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    import com.qualcomm.robotcore.hardware.ServoController;
    import com.qualcomm.robotcore.util.ElapsedTime;

    @Autonomous(name = "IntoTheDeepAuto3SimplePark")
    public class IntoTheDeepAuto3 extends LinearOpMode {
        // Declare OpMode members.
        private ElapsedTime runtime = new ElapsedTime();
        public ServoController ControlHub_ServoController;


        @Override
        public void runOpMode() {

            boolean Running = true;
            boolean testMode = true; // Shows Telemetry data for Functions.drive and Functions.turn
    
            // Report that op mode has been initialized
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            //***VERY IMPORTANT**
            //Replace the device name (ex frontLeft) with the NAME OF THE
            //MOTORS DEFINED IN THE DRIVER HUB
            ControlHub_ServoController = hardwareMap.get(ServoController.class, "Control Hub");


            waitForStart();
            runtime.reset();

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////// Driving starts here//////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // 10in = 572

            if(Running)
            {
                // Drive to pixel
                //Fix Strafe
                Functions.drive(this, hardwareMap, telemetry, 2, 2, 0.65, 2, 2, testMode);
                Functions.pause(0.25);

                Functions.drive(this, hardwareMap, telemetry, -57, 57, 0.8, 57, -57, testMode);
            }
        }

        //Very complicated code to make it so that when it is showing
        //seconds it has gone (directionTime) will be a one decimal number,
        //ex 0.2. Add 0's to both tens to increase the number of decimal
        //places shown.
        private String formatSeconds(double inputSeconds){
            double fixedValue = Math.floor(inputSeconds * 10) / 10;
            return String.valueOf(fixedValue);
        }
    }