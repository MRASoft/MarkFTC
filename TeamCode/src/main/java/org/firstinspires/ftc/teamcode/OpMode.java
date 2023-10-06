package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
	 //  backRightWheel = new robotDirection();
	// private robotDirection goForward = new this.robotDirection();
	// goBackward.robotDirection(-1, -1, -1, -1);
	// goForward.robotDirection(1, 1, 1, 1);

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        frontLeftWheel  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRight");
        backLeftWheel   = hardwareMap.get(DcMotor.class, "backLeft");
        backRightWheel  = hardwareMap.get(DcMotor.class, "backRight");
        frontColorSensor = hardwareMap.get(ColorSensor.class, "frontColorSensor");
      

        frontLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotor.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        backRightWheel.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double frontLeftPower;
            double frontRightPower;
            double backLeftPower;
            double backRightPower;
          
			telemetry.addData("Alpha", frontColorSensor.alpha());  // Turn the LED on
            telemetry.addData("red", frontColorSensor.red());
            telemetry.addData("green", frontColorSensor.green());
            telemetry.addData("blue", frontColorSensor.blue());
            telemetry.addData("argb", frontColorSensor.argb());

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
			// driveSeconds(this.goForward, 5);
	

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "fl (%.2f), fr (%.2f), bl (%.2f), br (%.2f)", frontLeftPower, frontRightPower, backLeftPower, backRightPower);
            telemetry.update();
        }
    }


  	// Drive A specific direction for the number of seconds
  	private void driveSeconds(direction newDirection, double seconds) {
		frontLeftWheel.setPower(newDirection.frontLeftPower);
        frontRightWheel.setPower(newDirection.frontRightPower);
        backLeftWheel.setPower(newDirection.backLeftPower);
        backRightWheel.setPower(newDirection.backRightPower);

        if (opModeIsActive()) {

        }
  	}
}

public class robotDirection {
	double frontLeftPower;
	double frontRightPower;
	double backLeftPower;
	double backRightPower;

}
