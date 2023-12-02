package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import com.qualcomm.robotcore.hardware.DcMotor;
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

    public static void drive(com.qualcomm.robotcore.eventloop.opmode.LinearOpMode opMode, com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, int BackLeft_target, int BackRight_target, double Speed, int FrontLeft_target, int FrontRight_target) {
        DcMotor BackLeft;
        DcMotor FrontLeft;
        DcMotor FrontRight;
        DcMotor BackRight;

        int Leftpos = 0;
        int Rightpos = 0;

        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");

        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Leftpos += BackLeft_target;
        Rightpos += BackRight_target;
        BackLeft.setTargetPosition(Leftpos);
        BackRight.setTargetPosition(Rightpos);
        FrontLeft.setTargetPosition(Leftpos);
        FrontRight.setTargetPosition(Rightpos);

        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        BackLeft.setPower(Speed);
        BackRight.setPower(Speed);
        FrontLeft.setPower(Speed);
        FrontRight.setPower(Speed);

        while (opMode.opModeIsActive())
        {
            telemetry.addData("encoder-fwd-left-end", BackLeft.getCurrentPosition());
            telemetry.addData("encoder-fwd-right-end", BackRight.getCurrentPosition());
            telemetry.addData("encoder-fwd-left-end", BackLeft.getCurrentPosition());
            telemetry.addData("encoder-fwd-right-end", BackRight.getCurrentPosition());
            telemetry.update();
            opMode.idle();
        }

        while (opMode.opModeIsActive() && BackRight.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && FrontLeft.isBusy()) {
            opMode.idle();
        }


        BackLeft.setPower(0);
        BackRight.setPower(0);
        FrontLeft.setPower(0);
        FrontRight.setPower(0);

    }
}