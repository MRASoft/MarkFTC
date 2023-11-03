package org.firstinspires.ftc.teamcode;
public class robotDirection {
    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;
    String direction;

    robotDirection(double frontLeft, double frontRight, double backLeft, double backRight, String directionName) {
        this.frontLeftPower = frontLeft;
        this.frontRightPower = frontRight;
        this.backLeftPower = backLeft;
        this.backRightPower = backRight;
        this.direction = directionName;
    }

    robotDirection(String direction) {
        switch (direction){
            case "Forward":
                frontLeftPower = -1;
                frontRightPower = -1;
                backLeftPower = -1;
                backRightPower = -1;
                break;
            case "Forward/2":
                frontLeftPower = -0.5;
                frontRightPower = -0.5;
                backLeftPower = -0.5;
                backRightPower = -0.5;
                break;
            case "ForwardSl":
                frontLeftPower = -0.25;
                frontRightPower = -0.25;
                backLeftPower = -0.25;
                backRightPower = -0.25;
                break;
            case "Back":
                frontLeftPower = 1;
                frontRightPower = 1;
                backLeftPower = 1;
                backRightPower = 1;
                break;
            case "Back/2":
                frontLeftPower = 0.5;
                frontRightPower = 0.5;
                backLeftPower = 0.5;
                backRightPower = 0.5;
                break;
            case "BackSl":
                frontLeftPower = 0.25;
                frontRightPower = 0.25;
                backLeftPower = 0.25;
                backRightPower = 0.25;
                break;
            case "Pause":
                frontLeftPower = 0;
                frontRightPower = 0;
                backLeftPower = 0;
                backRightPower = 0;
                break;
            case "SRight":
                frontLeftPower = 0.25;
                frontRightPower = -0.25;
                backLeftPower = -0.25;
                backRightPower = 0.28;
                break;
            case "SLeft":
                frontLeftPower = -0.25;
                frontRightPower = 0.25;
                backLeftPower = 0.25;
                backRightPower = -0.28;
                break;

        }
    }

    /*
    public final robotDirection goBackward = new robotDirection(1, 1, 1, 1, "Forward");
    public final robotDirection halfBackward = new robotDirection(0.5, 0.5, 0.5, 0.5, "Forward/2");
    public final robotDirection slowBackward = new robotDirection(0.25, 0.25, 0.25, 0.25, "ForwardSl");
    public final robotDirection goForward = new robotDirection(-1, -1, -1, -1, "Back");
    public final robotDirection halfForward = new robotDirection(-0.5, -0.5, -0.5, -0.5, "Back/2");
    public final robotDirection slowForward = new robotDirection(-0.25, -0.25, -0.25, -0.25, "BackSl");
    public final robotDirection fullStop = new robotDirection(0, 0, 0, 0, "Pause");
    public final robotDirection strafeRight = new robotDirection(-0.25, 0.25, 0.25, -0.28, "SLeft");
    public final robotDirection strafeLeft = new robotDirection(0.25, -0.25, -0.25, 0.28, "SRight");
    */
}