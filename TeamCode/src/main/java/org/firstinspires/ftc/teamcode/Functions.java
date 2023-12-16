package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.List;
public class Functions {

    public static void pause(double waitTime) {
        ElapsedTime elapsedTime = new ElapsedTime();

        while (elapsedTime.seconds() < waitTime) {
            //STOP, wait a minute
        }
    }

    public static String formatSeconds(double inputSeconds){
        double fixedValue = Math.floor(inputSeconds * 10) / 10;
        return String.valueOf(fixedValue);
    }

    public static void drive(com.qualcomm.robotcore.eventloop.opmode.LinearOpMode opMode, com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, int BackLeft_target, int BackRight_target, double Speed, int FrontLeft_target, int FrontRight_target) {
        DcMotor BackLeft;
        DcMotor BackRight;
        DcMotor FrontLeft;
        DcMotor FrontRight;

        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");

        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.FORWARD);
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);

        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BackLeft.setTargetPosition(BackLeft_target);
        BackRight.setTargetPosition(BackRight_target);
        FrontLeft.setTargetPosition(FrontLeft_target);
        FrontRight.setTargetPosition(FrontRight_target);

        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BackLeft.setPower(Speed);
        BackRight.setPower(Speed);
        FrontLeft.setPower(Speed);
        FrontRight.setPower(Speed);

        while (opMode.opModeIsActive() && BackLeft.isBusy() && BackRight.isBusy() && FrontLeft.isBusy() && FrontRight.isBusy())
        {
            telemetry.addData("bk-left-end", BackLeft.getCurrentPosition() + "," + BackLeft.getPower());
            telemetry.addData("bk-right-end", BackRight.getCurrentPosition() + "," + BackRight.getPower());
            telemetry.addData("fwd-left-end", FrontLeft.getCurrentPosition() + "," + FrontLeft.getPower());
            telemetry.addData("fwd-right-end", FrontRight.getCurrentPosition() + "," + FrontRight.getPower());
            telemetry.addData("bk-left-endBusy", BackLeft.isBusy());
            telemetry.addData("bk-right-endBusy", BackRight.isBusy());
            telemetry.addData("fwd-left-endBusy", FrontLeft.isBusy());
            telemetry.addData("fwd-right-endBusy", FrontRight.isBusy());
            telemetry.update();
            opMode.idle();
        }

        BackLeft.setPower(0);
        BackRight.setPower(0);
        FrontLeft.setPower(0);
        FrontRight.setPower(0);

    }


    public static void turn(com.qualcomm.robotcore.eventloop.opmode.LinearOpMode opMode, com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, String direction, double Speed) {
        DcMotor BackLeft;
        DcMotor FrontLeft;
        DcMotor FrontRight;
        DcMotor BackRight;

        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");

        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.FORWARD);

        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int distance = 1300;

        if (direction == "Right") {
            BackLeft.setTargetPosition(distance);
            BackRight.setTargetPosition(-distance);
            FrontLeft.setTargetPosition(distance);
            FrontRight.setTargetPosition(-distance);
        } else if (direction == "Left") {
            BackLeft.setTargetPosition(-distance);
            BackRight.setTargetPosition(distance);
            FrontLeft.setTargetPosition(-distance);
            FrontRight.setTargetPosition(distance);
        }

        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BackLeft.setPower(Speed);
        BackRight.setPower(Speed);
        FrontLeft.setPower(Speed);
        FrontRight.setPower(Speed);

        while (opMode.opModeIsActive() && BackLeft.isBusy() && BackRight.isBusy() && FrontLeft.isBusy() && FrontRight.isBusy())
        {
            telemetry.addData("encoder-bk-left-end", BackLeft.getCurrentPosition());
            telemetry.addData("encoder-bk-right-end", BackRight.getCurrentPosition());
            telemetry.addData("encoder-fwd-left-end", FrontLeft.getCurrentPosition());
            telemetry.addData("encoder-fwd-right-end", FrontRight.getCurrentPosition());
            telemetry.addData("encoder-bk-left-endBusy", BackLeft.isBusy());
            telemetry.addData("encoder-bk-right-endBusy", BackRight.isBusy());
            telemetry.addData("encoder-fwd-left-endBusy", FrontLeft.isBusy());
            telemetry.addData("encoder-fwd-right-endBusy", FrontRight.isBusy());
            telemetry.update();
            opMode.idle();
        }

        BackLeft.setPower(0);
        BackRight.setPower(0);
        FrontLeft.setPower(0);
        FrontRight.setPower(0);

    }

    public static void dropYellow(com.qualcomm.robotcore.eventloop.opmode.LinearOpMode opMode, com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, String Direction, double speed) {

        CRServo BackDropExpansion = null;
        CRServo BackDropControl = null;

        BackDropExpansion = hardwareMap.get(CRServo.class, "BackDropExpansion");
        BackDropControl = hardwareMap.get(CRServo.class, "BackDropControl");

        if (Direction == "Down") {
            BackDropExpansion.setPower(-speed);
            BackDropControl.setPower(speed);

        } else if (Direction == "Up") {
            BackDropExpansion.setPower(speed);
            BackDropControl.setPower(-speed);
        }

        Functions.pause(2);

        BackDropExpansion.setPower(0);
        BackDropControl.setPower(0);
    }
}