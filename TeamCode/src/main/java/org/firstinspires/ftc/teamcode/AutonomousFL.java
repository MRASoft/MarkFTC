package org.firstinspires.ftc.teamcode;

//Importing
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
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
@Autonomous(name = "AutonomousFL")
public class AutonomousFL extends LinearOpMode {

    private String action;
    private final int waitTime = 5;

    // Declare OpMode members.
    private ColorSensor backColorSensor;
    private ColorSensor leftColorSensor;
    private ColorSensor rightColorSensor;
    private DistanceSensor distanceSensor;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftWheel  = null;
    private DcMotor frontRightWheel = null;
    private DcMotor backLeftWheel  = null;
    private DcMotor backRightWheel = null;
    private DcMotor leftArm = null;
    private DcMotor rightArm = null;

    // Initialize directions
    private final robotDirection goForward = new robotDirection(1, 1, 1, 1, "Forward");
    private final robotDirection goBackward = new robotDirection(-1, -1, -1, -1, "Back");
    private final robotDirection fullStop = new robotDirection(0, 0, 0, 0, "Pause");
    private final robotDirection strafeLeft = new robotDirection(1, 1, -1, -1, "SLeft");
    private final robotDirection strafeRight = new robotDirection(-1, -1, 1, 1, "SRight");
    private final armDirection armStop = new armDirection(0, 0, "AStop");
    private final armDirection armUp = new armDirection(0.5, 0.5, "AUp");
    private final armDirection armDown = new armDirection(-0.5, -0.5, "ADown");

    //Set color thresholds
    private final int blueThreshold = 1000;
    private final int redThreshold = 1000;
    private final int greenThreshold = 1000;

    // Store the current direction
    private robotDirection currentDirection = fullStop;
    private armDirection currentArmDirection = armStop;

    @Override
    public void runOpMode() {
        // Report that op mode has been initialized
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables

        //***VERY IMPORTANT**
        //Replace the device name (ex frontLeft) with the NAME OF THE
        //MOTORS DEFINED IN THE DRIVER HUB
        frontLeftWheel = hardwareMap.get(DcMotor.class, "FrontLeft");
        frontRightWheel = hardwareMap.get(DcMotor.class, "FrontRight");
        backLeftWheel  = hardwareMap.get(DcMotor.class, "BackLeft");
        backRightWheel = hardwareMap.get(DcMotor.class, "BackRight");
        leftArm = hardwareMap.get(DcMotor.class, "LeftArm");
        rightArm = hardwareMap.get(DcMotor.class, "RightArm");

        //color 3
        backColorSensor = hardwareMap.get(ColorSensor.class, "BackColorSensor");
        //
        leftColorSensor = hardwareMap.get(ColorSensor.class, "LeftColorSensor");
        //
        rightColorSensor = hardwareMap.get(ColorSensor.class, "RightColorSensor");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "DistanceSensor");

        // Set the wheel directions
        frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotor.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        backRightWheel.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();


        // Go forward for five seconds
        //driveSeconds(goForward, 5);

        //Stop of 2 Seconds
        //driveSeconds(fullStop, 2);

        // Go backward for three seconds
        //driveSeconds(goBackward, 3);

        //Strafe left for 3.5 seconds
        //driveSeconds(strafeLeft, 3.5);

        //Strafe right for 3.5 seconds
        //driveSeconds(strafeRight, 3.5);

        boolean distanceWasReached;
        distanceWasReached = driveUntilDistanceAway(goForward, 12.7, 8.6);
        telemetry.addData("Got to ", distanceWasReached);
        telemetry.update();
        ElapsedTime waitTimerD = new ElapsedTime();
        while (opModeIsActive() && waitTimerD.seconds() < waitTime) {
            //AHHHHHHHHHHHHHHHHHHHHHHHHH
        }

        boolean colorWasFound;
        colorWasFound = driveUntilColor(goForward, "red", 5, backColorSensor);
        telemetry.addData("Found color", colorWasFound);
        telemetry.update();
        ElapsedTime waitTimerC = new ElapsedTime();
        while (opModeIsActive() && waitTimerC.seconds() < waitTime) {
            //AHHHHHHHHHHHHHHHHHHHHHHHHH
        }

        // Now just monitor the color
        /*while (opModeIsActive()) {
            // Get the color sensor data
            telemetry.addData("Alpha", backColorSensor.alpha());
            telemetry.addData("red", backColorSensor.red());
            telemetry.addData("green", backColorSensor.green());
            telemetry.addData("blue", backColorSensor.blue());
            telemetry.addData("argb", backColorSensor.argb());

            //*Must add to have data show up on the driver hub*
            telemetry.update();
        }
        */
    }


    // Drive A specific direction for the number of seconds
    private void driveSeconds(robotDirection newDirection, double seconds) {
        // Set the current direction
        currentDirection = newDirection;

        // Set the drive time
        ElapsedTime driveTime = new ElapsedTime();

        while (opModeIsActive() && driveTime.seconds() < seconds) {
            //telemetry.addData("Current Direction", "fl (%.2f), fr (%.2f), bl (%.2f), br (%.2f)", currentDirection.frontLeftPower, currentDirection.frontRightPower, currentDirection.backLeftPower, currentDirection.backRightPower);
            telemetry.addData("Direction", currentDirection.direction);
            telemetry.addData("Direction Time", formatSeconds(driveTime.seconds()) + "/" + seconds);
            telemetry.update();
            setPower();
        }


        // Stop the robot
        currentDirection = fullStop;

        setPower();
    }

    private void armSeconds(armDirection newArmDirection, double seconds) {
        // Set the current direction
        currentArmDirection = newArmDirection;

        // Set the drive time
        ElapsedTime driveTime = new ElapsedTime();

        while (opModeIsActive() && driveTime.seconds() < seconds) {
            //telemetry.addData("Current Direction", "al (%.2f), ar (%.2f), currentArmDirection.leftArmPower, currentArmDirection.rightArmPower);
            telemetry.addData("Direction", currentArmDirection.direction);
            telemetry.addData("Direction Time", formatSeconds(driveTime.seconds()) + "/" + seconds);
            telemetry.update();
            setPower();
        }


        // Stop the robot
        currentArmDirection = armStop;

        setPower();
    }

    private boolean driveUntilColor(robotDirection newDirection, String colorType, double searchTime, ColorSensor colorSensorType) {
        // Will keep going until is true
        boolean colorFound = false;
        int threshold = 0;

        // Set the current direction
        currentDirection = newDirection;

        // Set the drive time
        ElapsedTime driveTime = new ElapsedTime();

        while (opModeIsActive() && driveTime.seconds() < searchTime && colorFound == false) {
            switch (colorType){
                case "blue":
                    colorFound = colorSensorType.blue() > blueThreshold;
                    break;
                case "red":
                    colorFound = colorSensorType.red() > redThreshold;
                    break;
                case "green":
                    colorFound = colorSensorType.green() > greenThreshold;
                    break;
            }
            if (colorFound) {
                telemetry.addData("Found ", colorType);
            }
            else {
                telemetry.addData("Searching for:", colorType);
                telemetry.addData("In Direction:", currentDirection.direction);
                telemetry.addData("Time remaining until return", formatSeconds(driveTime.seconds()) + "/" + searchTime);
                telemetry.update();
                setPower();
            }
        }

        // Stop the robot
        currentDirection = fullStop;

        setPower();

        return colorFound;
    }

    private boolean driveUntilDistanceAway(robotDirection newDirection, double distance, double searchTime) {
        // Will keep going until is true
        boolean distanceReached = false;

        // Set the current direction
        currentDirection = newDirection;

        // Set the drive time
        ElapsedTime driveTime = new ElapsedTime();

        while (opModeIsActive() && driveTime.seconds() < searchTime && distanceReached == false) {

            // Get current distance
            double currentDistance = distanceSensor.getDistance(DistanceUnit.CM);

            if (distance > currentDistance) {
                distanceReached = true;
            }

            if (distanceReached) {
                telemetry.addData("Got to ", distance);
            } else {
                telemetry.addData("Distance:", currentDistance + "/" + distance);
                telemetry.addData("In Direction:", currentDirection.direction);
                telemetry.addData("Time remaining until return", formatSeconds(driveTime.seconds()) + "/" + searchTime);
                telemetry.update();
                setPower();
            }
        }

        // Stop the robot
        currentDirection = fullStop;

        setPower();

        return distanceReached;
    }

    //This is used in defining directions (goForward) so you can just
    //replace the numbers with the power you want it to go at (will
    //vary in speed depending on the battery level)
    private void setPower() {
        frontLeftWheel.setPower(currentDirection.frontLeftPower);
        frontRightWheel.setPower(currentDirection.frontRightPower);
        backLeftWheel.setPower(currentDirection.backLeftPower);
        backRightWheel.setPower(currentDirection.backRightPower);
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