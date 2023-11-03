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

    armDirection(String direction) {
        switch (direction){
            case "AStop":
                leftArmPower = 0;
                rightArmPower = 0;
                break;
            case "AUp":
                leftArmPower = 0.5;
                rightArmPower = 0.5;
                break;
            case "ADown":
                leftArmPower = -0.5;
                rightArmPower = -0.5;
                break;
        }
    }

    /*
    private final armDirection armStop = new armDirection(0, 0, "AStop");
    private final armDirection armUp = new armDirection(0.5, 0.5, "AUp");
    private final armDirection armDown = new armDirection(-0.5, -0.5, "ADown");
    */
}