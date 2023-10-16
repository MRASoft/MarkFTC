package org.firstinspires.ftc.teamcode;

//Importing
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

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
@TeleOp(name = "OpMode3")
public class OpMode3 extends LinearOpMode {

    private String action;
    private final int waitTime = 5;

    // Declare OpMode members.
    private DcMotor frontLeftWheel  = null;
    private DcMotor frontRightWheel = null;
    private DcMotor backLeftWheel  = null;
    private DcMotor backRightWheel = null;

    @Override
    public void runOpMode() {
        // Report that op mode has been initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables

        //***VERY IMPORTANT**
        //Replace the device name (ex frontLeft) with the NAME OF THE
        //MOTORS DEFINED IN THE DRIVER HUB
        frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRight");
        backLeftWheel = hardwareMap.get(DcMotor.class, "backLeft");
        backRightWheel = hardwareMap.get(DcMotor.class, "backRight");

        // Set the wheel directions
        frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotor.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        backRightWheel.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        int noPower = 0;
        float vertical;
        float horizontal;
        double tSpeed = 0.5;
        int bumperSpeed = 1;

        // Put initialization blocks here.
        waitForStart();

        while (opModeIsActive()) {
            vertical = gamepad1.right_stick_x;
            horizontal = -gamepad1.right_stick_y;

            backLeftWheel.setPower(vertical - horizontal);
            backRightWheel.setPower(vertical + horizontal);
            frontLeftWheel.setPower(vertical + horizontal);
            frontRightWheel.setPower(vertical - horizontal);

            if (gamepad1.left_bumper) {
                backLeftWheel.setPower(bumperSpeed);
                frontLeftWheel.setPower(-bumperSpeed);
                backRightWheel.setPower(bumperSpeed);
                frontRightWheel.setPower(-bumperSpeed);
            } else if (gamepad1.right_bumper) {
                backLeftWheel.setPower(-bumperSpeed);
                backRightWheel.setPower(-bumperSpeed);
                frontLeftWheel.setPower(bumperSpeed);
                frontRightWheel.setPower(bumperSpeed);
            } else {
                backLeftWheel.setPower(noPower);
                backRightWheel.setPower(noPower);
                frontLeftWheel.setPower(noPower);
                frontRightWheel.setPower(noPower);
            }
            if (gamepad1.dpad_up) {
                telemetry.addData("Direction", "Foreward");
                backLeftWheel.setPower(-tSpeed);
                backRightWheel.setPower(tSpeed);
                frontLeftWheel.setPower(tSpeed);
                frontRightWheel.setPower(-tSpeed);
            } else if (gamepad1.dpad_down) {
                telemetry.addData("Direction", "Bac");
                backLeftWheel.setPower(tSpeed);
                backRightWheel.setPower(-tSpeed);
                frontLeftWheel.setPower(-tSpeed);
                frontRightWheel.setPower(tSpeed);
            } else if (gamepad1.x) {
                telemetry.addData("Direction", "Ex Girlfriend");
                backLeftWheel.setPower(-tSpeed);
                backRightWheel.setPower(-tSpeed);
                frontLeftWheel.setPower(tSpeed);
                frontRightWheel.setPower(tSpeed);
            } else if (gamepad1.b) {
                telemetry.addData("Direction", "Bee");
                backLeftWheel.setPower(tSpeed);
                frontLeftWheel.setPower(-tSpeed);
                backRightWheel.setPower(tSpeed);
                frontRightWheel.setPower(-tSpeed);
            } else if (gamepad1.dpad_left) {
                telemetry.addData("Direction", "Lect");
                backLeftWheel.setPower(-tSpeed);
                backRightWheel.setPower(-tSpeed);
                frontLeftWheel.setPower(-tSpeed);
                frontRightWheel.setPower(-tSpeed);
            } else if (gamepad1.dpad_right) {
                telemetry.addData("Direction", "Write");
                backLeftWheel.setPower(tSpeed);
                backRightWheel.setPower(tSpeed);
                frontLeftWheel.setPower(tSpeed);
                frontRightWheel.setPower(tSpeed);
            } else {
                backLeftWheel.setPower(noPower);
                backRightWheel.setPower(noPower);
                frontLeftWheel.setPower(noPower);
                frontRightWheel.setPower(noPower);
            }
            // Put run blocks here.
            // Put loop blocks here.
            telemetry.update();
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
