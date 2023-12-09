package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.List;
public class ImageDetection {

    public static boolean findBlue(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, double searchTime) {
        ElapsedTime elapsedTime = new ElapsedTime();

        TfodProcessor tfod = new TfodProcessor.Builder()
                .setModelFileName("/sdcard/FIRST/tflitemodels/BlueSquarev1.tflite")
                .setModelLabels(new String[]{"BoxBlue"})
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        builder.addProcessor(tfod);

        VisionPortal visionPortal = builder.build();

        while (elapsedTime.seconds() < searchTime) {
            List<Recognition> currentRecognitions = tfod.getRecognitions();

            if (currentRecognitions.size() > 0){
                return true;
            }
        }

        return false;
    }

    public static boolean findRed(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, double searchTime) {
        ElapsedTime elapsedTime = new ElapsedTime();

        TfodProcessor tfod = new TfodProcessor.Builder()
                .setModelFileName("/sdcard/FIRST/tflitemodels/RedSquarev1.tflite")
                .setModelLabels(new String[]{"BoxRed"})
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        builder.addProcessor(tfod);

        VisionPortal visionPortal = builder.build();

        while (elapsedTime.seconds() < searchTime) {
            List<Recognition> currentRecognitions = tfod.getRecognitions();

            if (currentRecognitions.size() > 0){
                return true;
            }
        }

        return false;
    }

    public static boolean findPixel(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap, org.firstinspires.ftc.robotcore.external.Telemetry telemetry, double searchTime) {
        try {

            ElapsedTime elapsedTime = new ElapsedTime();

            TfodProcessor tfod = new TfodProcessor.Builder()
                    .setModelFileName("/sdcard/FIRST/tflitemodels/CenterStage.tflite")
                    .setModelLabels(new String[]{"Pixel"})
                    .build();
            tfod.setMinResultConfidence((float) 0.6);

            VisionPortal.Builder builder = new VisionPortal.Builder();

            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
            builder.addProcessor(tfod);

            VisionPortal visionPortal = builder.build();

            while (elapsedTime.seconds() < searchTime) {
                List<Recognition> currentRecognitions = tfod.getRecognitions();

                if (currentRecognitions.size() > 0) {
                    //visionPortal.close();
                    return true;
                }
            }

            //visionPortal.close();
            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }
}