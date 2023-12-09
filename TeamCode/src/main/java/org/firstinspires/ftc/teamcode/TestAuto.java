package org.firstinspires.ftc.teamcode;

//Importing

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
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
@Autonomous(name = "TestAuto")
public class TestAuto extends LinearOpMode {

    private String action;
    private final int waitTime = 5;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Drone = null;
    private CRServo Drop1 = null;
    private CRServo Drop2 = null;
    private CRServo Drop3 = null;
    private CRServo Drop4 = null;


    @Override
    public void runOpMode() {
        // Report that op mode has been initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables

        //***VERY IMPORTANT**
        //Replace the device name (ex frontLeft) with the NAME OF THE
        //MOTORS DEFINED IN THE DRIVER HUB
        Drone = hardwareMap.get(DcMotor.class, "Drone");

        // Set the wheel directions
        Drone.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////// Driving starts here//////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // 16in = 1000

        Functions.drive(this, hardwareMap, telemetry, -2000, -2000, 0.5, -2000, -2000);

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