package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name = "OpMode")
public class OpMode extends LinearOpMode {
    // Declare OpMode members.
    private ColorSensor frontColorSensor;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftWheel  = null;
    private DcMotor frontRightWheel = null;
    private DcMotor backLeftWheel  = null;
    private DcMotor backRightWheel = null;

    // Initialize directions
    private final robotDirection goForward = new robotDirection(1, 1, 1, 1);
    private final robotDirection goBackward = new robotDirection(-1, -1, -1, -1);
    private final robotDirection fullStop = new robotDirection(0, 0, 0, 0);

    // Store the current direction
    private robotDirection currentDirection = fullStop;

    @Override
    public void runOpMode() {
        // Report that op mode has been initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables
        frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRight");
        backLeftWheel  = hardwareMap.get(DcMotor.class, "backLeft");
        backRightWheel = hardwareMap.get(DcMotor.class, "backRight");
        frontColorSensor = hardwareMap.get(ColorSensor.class, "frontColorSensor");

        // Set the wheel directions
        frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotor.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        backRightWheel.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // Go forward for five seconds
        driveSeconds(goForward, 5);

        // Go backward for three seconds
        driveSeconds(goBackward, 3);

        // Now just monitor the color
        while (opModeIsActive()) {
            // Get the color sensor data
            telemetry.addData("Alpha", frontColorSensor.alpha());
            telemetry.addData("red", frontColorSensor.red());
            telemetry.addData("green", frontColorSensor.green());
            telemetry.addData("blue", frontColorSensor.blue());
            telemetry.addData("argb", frontColorSensor.argb());

            // Show the elapsed game time and wheel power.
            telemetry.update();
        }
    }


    // Drive A specific direction for the number of seconds
    private void driveSeconds(robotDirection newDirection, double seconds) {
        // Set the current direction
        currentDirection = newDirection;

        // Set the drive time
        ElapsedTime driveTime = new ElapsedTime();

        if (opModeIsActive() && driveTime.seconds() < seconds) {
            telemetry.addData("Current Direction", "fl (%.2f), fr (%.2f), bl (%.2f), br (%.2f)", currentDirection.frontLeftPower, currentDirection.frontRightPower, currentDirection.backLeftPower, currentDirection.backRightPower);
            telemetry.addData("Direction Time", driveTime.seconds() + "/" + seconds);
            setPower();
        }

        // Stop the robot
        currentDirection = fullStop;

        setPower();
    }

    private void setPower() {
        frontLeftWheel.setPower(currentDirection.frontLeftPower);
        frontRightWheel.setPower(currentDirection.frontRightPower);
        backLeftWheel.setPower(currentDirection.backLeftPower);
        backRightWheel.setPower(currentDirection.backRightPower);
    }
}

class robotDirection {
    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;

    robotDirection(double frontLeft, double frontRight, double backLeft, double backRight) {
        this.frontLeftPower = frontLeft;
        this.frontRightPower = frontRight;
        this.backLeftPower = backLeft;
        this.backRightPower = backRight;
    }
}