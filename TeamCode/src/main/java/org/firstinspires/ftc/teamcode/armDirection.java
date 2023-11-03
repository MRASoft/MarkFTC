package org.firstinspires.ftc.teamcode;
public class armDirection {
    double leftArmPower;
    double rightArmPower;
    String direction;

    armDirection(double leftArm, double rightArm, String directionName) {
        this.leftArmPower = leftArm;
        this.rightArmPower = rightArm;
        this.direction = directionName;
    }
}