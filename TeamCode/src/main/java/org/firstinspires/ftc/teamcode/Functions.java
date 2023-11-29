package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
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
}