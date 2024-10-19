    package org.firstinspires.ftc.teamcode;

    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    import com.qualcomm.robotcore.hardware.ServoController;
    import com.qualcomm.robotcore.util.ElapsedTime;

    @Autonomous(name = "IntoTheDeepAuto2Sub")
    public class IntoTheDeepAuto2 extends LinearOpMode {
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
                Functions.drive(this, hardwareMap, telemetry, -0.5, 0.5, 0.65, 0.5, -0.5, testMode);
                Functions.pause(0.25);

                //Drive forward
                Functions.drive(this, hardwareMap, telemetry, 40, 40, 0.65, 40, 40,  testMode);
                Functions.pause(0.25);

                //go back
                Functions.drive(this, hardwareMap, telemetry, -16, -16, 0.65, -16, -16,  testMode);
                Functions.pause(0.25);

                //strafe to 1
                Functions.drive(this, hardwareMap, telemetry, -55, 55, 0.65, 55, -55, testMode);

                //drive forward
                Functions.drive(this, hardwareMap, telemetry, 12, 12, 0.6, 12, 12, testMode);
                Functions.pause(0.25);

                //Turn
                Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
                Functions.pause(0.25);

                //go Go front
                Functions.drive(this, hardwareMap, telemetry, 48, 48, 0.6, 48, 48, testMode);

                //Strafe right
                Functions.drive(this, hardwareMap, telemetry, -6.5, 6.5, 0.6, 6.5, -6.5, testMode);

                //Functions.drive(this, hardwareMap, telemetry, -1, 1, 0.5, 1, -1, testMode);
                //Shimmy
                //Functions.drive(this, hardwareMap, telemetry, 1, -1, 0.5, -1, 1, testMode);
                //Functions.pause(0.25);

                //Go back to position
                Functions.drive(this, hardwareMap, telemetry, -12, -12,  0.6, -12, -12,  testMode);

                //Strafe right
                Functions.drive(this, hardwareMap, telemetry, 6.5, -6.5, 0.6, -6.5, 6.5, testMode);

                //Go back to position
                Functions.drive(this, hardwareMap, telemetry, -34, -34,  0.65, -34, -34,  testMode);

                //Strafe for 2
                Functions.drive(this, hardwareMap, telemetry, -12.5, 12.5, 0.6, 12.5, -12.5, testMode); //Strafe for 2

                Functions.drive(this, hardwareMap, telemetry, 43, 43,  0.65, 43, 43,  testMode);

                //Go back
                Functions.drive(this, hardwareMap, telemetry, -43, -43,  0.65, -43, -43,  testMode);

                //Drift to the side for 3
                Functions.drive(this, hardwareMap, telemetry, -10, 10, 0.6, 10, -10, testMode); //Strafe for 2

                //Go forward
                Functions.drive(this, hardwareMap, telemetry, 40, 40,  0.65, 40, 40,  testMode);

                //go back
                Functions.drive(this, hardwareMap, telemetry, -17, -17,  0.6, -17, -17,  testMode);

                Functions.drive(this, hardwareMap, telemetry, 112, -112, 0.8, -112, 112, testMode);

                Functions.drive(this, hardwareMap, telemetry, 19, 19,  0.6, 19, 19,  testMode);
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