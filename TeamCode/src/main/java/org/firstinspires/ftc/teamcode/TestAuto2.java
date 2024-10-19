package org.firstinspires.ftc.teamcode;

//Importing

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;

//##################################
//#                                #
//# Made by Coder Ricky Adams (14) #
//#      for the 2023-2024         #
//#       Centerstage FTC,         #
//#     with teammates Michael     #
//#    Shenback and Max Corum      #
//# (and a little help from Ethan) #
//#  as engineers. Use this as a   #
//#  basis for any code you need   #
//#     for future events.         #
//#                                #
//#  -Team Dinomite8472 10/7/2023  #
//#                                #
//##################################


//Note to used Android studio to show errors in code, and the robot
//control console (ip address to connect directly to control hub,
//in my case http://192.168.43.1:8080/?page=connection.html&pop=true)
//to export the code into the mini i-pad (Driver hub)


//Replace ' name = "OpMode3" ' with the name you want
//to display on control hub, and ' class OpMode3 ' with
//the name of the file.
@TeleOp(name = "TestAuto002")
public class TestAuto2 extends LinearOpMode {

    private String action;
    private final int waitTime = 5;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    public ServoController ControlHub_ServoController;
    public ServoController ExpansionHub2_ServoController;


    @Override
    public void runOpMode() {
        boolean Running = true;
        // Report that op mode has been initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //***VERY IMPORTANT**
        //Replace the device name (ex frontLeft) with the NAME OF THE
        //MOTORS DEFINED IN THE DRIVER HUB
        ControlHub_ServoController = hardwareMap.get(ServoController.class, "Control Hub");
        ExpansionHub2_ServoController = hardwareMap.get(ServoController.class, "Expansion Hub 2");

        // Wait for the game to start (driver presses PLAY)
        boolean Start = false;
        boolean DriveTest = false;
        boolean CameraTest = false;
        boolean DistanceTest = false;
        boolean testMode = true;
        boolean armTest = true;
        boolean turnTest = false;

        while (Start = false) {
            if (gamepad1.dpad_down)
            {
                Start = true;
            }

            if (gamepad1.x)
            {
                DriveTest = true;
            }

            if (gamepad1.b)
            {
                CameraTest = true;
            }

            if (gamepad1.y)
            {
                DistanceTest = true;
            }

            if (gamepad1.a)
            {
                armTest = true;
            }

            telemetry.addData("Running == ", Running);
            telemetry.addData("Drive Test == ", DriveTest);
            telemetry.addData("Camera Test == ", CameraTest);
            telemetry.addData("Distance Test == ", DistanceTest);
            telemetry.addData("Arm Test == ", armTest);
            telemetry.addData("Turn Test == ", turnTest);

            telemetry.update();
        }
        waitForStart();
        runtime.reset();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////// Driving starts here//////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////


        if(DriveTest == true) {
            // 16in = 1000


            ///
            //NOTE TO KIRO M/ANYONE PROGRAMMING!!!
            //THE AUTO CODE HAS BEEN MOVED TO IntoTheDeepAuto1
            //DO NOT USE THIS FOR COMPETITION!!!
            ///






            // Drive to pixel
            //Fix Strafe
            Functions.drive(this, hardwareMap, telemetry, -0.5, 0.5, 0.5, 0.5, -0.5, testMode);
            Functions.pause(0.25);

            //Drive forward
            Functions.drive(this, hardwareMap, telemetry, 39, 39, 0.5, 39, 39,  testMode);
            Functions.drive(this, hardwareMap, telemetry, 1, 1, 0.25, 1, 1, testMode);
            Functions.pause(0.25);

            //go back
            Functions.drive(this, hardwareMap, telemetry, -16, -18, 0.5, -16, -16,  testMode);
            Functions.pause(0.25);

            //strafe to 1
            Functions.drive(this, hardwareMap, telemetry, -55, 55, 0.5, 55, -55, testMode);
            Functions.pause(0.25);

            //drive forward
            Functions.drive(this, hardwareMap, telemetry, 12, 12, 0.5, 12, 12, testMode);
            Functions.pause(0.25);

            //Turn
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
            Functions.pause(0.25);

            //go Go front
            Functions.drive(this, hardwareMap, telemetry, 48, 48, 0.5, 48, 48, testMode);
            Functions.pause(0.25);

            //Strafe right
            Functions.drive(this, hardwareMap, telemetry, -6, 6, 0.5, 6, -6, testMode);
            Functions.pause(0.25);

            //Functions.drive(this, hardwareMap, telemetry, -1, 1, 0.5, 1, -1, testMode);
            //Shimmy
            //Functions.drive(this, hardwareMap, telemetry, 1, -1, 0.5, -1, 1, testMode);
            //Functions.pause(0.25);

            //Go back to position
            Functions.drive(this, hardwareMap, telemetry, -12, -12,  0.5, -12, -12,  testMode);
            Functions.pause(0.25);

            //Strafe right
            Functions.drive(this, hardwareMap, telemetry, 6, -6, 0.5, -6, 6, testMode);

            //Go back to position
            Functions.drive(this, hardwareMap, telemetry, -34, -34,  0.5, -34, -34,  testMode);
            Functions.pause(0.25);

            //Strafe for 2
            Functions.drive(this, hardwareMap, telemetry, -12.5, 12.5, 0.5, 12.5, -12.5, testMode); //Strafe for 2
            Functions.pause(0.25);

            Functions.drive(this, hardwareMap, telemetry, 43, 43,  0.5, 43, 43,  testMode);
            Functions.pause(0.25);

            //Go back
            Functions.drive(this, hardwareMap, telemetry, -43, -43,  0.5, -43, -43,  testMode);

            //Drift to the side for 3
            Functions.drive(this, hardwareMap, telemetry, -7, 7, 0.5, 7, -7, testMode); //Strafe for 2
            Functions.pause(0.25);

            //Go forward
            Functions.drive(this, hardwareMap, telemetry, 40, 40,  0.5, 40, 40,  testMode);
            Functions.pause(0.25);

            //go back
            Functions.drive(this, hardwareMap, telemetry, -40, -40,  0.5, -40, -40,  testMode);
            Functions.pause(0.25);


            //Functions.drive(this, hardwareMap, telemetry, -430, 430, 0.5, 430, -430, testMode);

            /*
            Functions.drive(this, hardwareMap, telemetry, 2000, 2000, 0.5, 2000, 2000, testMode);

            Functions.turn(this, hardwareMap, telemetry, "Right", 0.5, testMode);
            Functions.drive(this, hardwareMap, telemetry, 700, 700, 0.5, 700, 700, testMode);
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
            Functions.drive(this, hardwareMap, telemetry, 700, 700, 0.5, 700, 700, testMode);

            Functions.drive(this, hardwareMap, telemetry, -700, -700, 0.5, -700, -700, testMode);
            Functions.turn(this, hardwareMap, telemetry, "Right", 0.5, testMode);
            Functions.drive(this, hardwareMap, telemetry, -700, -700, 0.5, -700, -700, testMode);
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);

            Functions.drive(this, hardwareMap, telemetry, -2000, -2000, 0.5, -2000, -2000, testMode);
        */
        }


        if(armTest == true)
        {
            //Functions.slideUp(this, hardwareMap, telemetry, ControlHub_ServoController, ExpansionHub2_ServoController);
            //Functions.drive(this, hardwareMap, telemetry, 3000, 3000, 0.1, 3000, 3000, testMode);
            //Functions.pause(4);
            //Functions.slideStop(this, hardwareMap, telemetry, ControlHub_ServoController, ExpansionHub2_ServoController);
            //Functions.dropYellow(this, hardwareMap, telemetry, "Up", 0.2, 1.5, ControlHub_ServoController, ExpansionHub2_ServoController);
            //Functions.pause(1);

        }

        if (turnTest == true)
        {
            //IMU.getRobotYawPitchRollAngles;
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
            Functions.pause(2);
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
            Functions.pause(2);
            Functions.turn(this, hardwareMap, telemetry, "Right", 0.5, testMode);
            Functions.pause(2);
            Functions.turn(this, hardwareMap, telemetry, "Left", 0.5, testMode);
            Functions.pause(2);

        }

        /*
        Drone.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Drone.setTargetPosition(6000);
        telemetry.addData("Drone Start", Drone.getCurrentPosition());
        telemetry.update();

        Drone.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        Drone.setPower(0.01);

        while (opModeIsActive() && Drone.isBusy())
        {
            telemetry.addData("Drone ", Drone.getCurrentPosition());
            telemetry.addData("Drone-Busy ", Drone.isBusy());
            telemetry.update();
            idle();
        }

        Drone.setPower(0);
        */


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