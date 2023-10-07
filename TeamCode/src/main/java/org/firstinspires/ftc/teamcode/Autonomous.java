public class RobotGoBackAndRightThenStraightAndLeft {

    public static void main(String[] args) {
        // Create four wheel objects.
        FrontRightWheel frontRightWheel = new FrontRightWheel();
        BackRightWheel backRightWheel;
        FrontLeftWheel frontLeftWheel;
        BackLeftWheel backLeftWheel;

        // Set the front right and back left wheels to -1 and the front left and back right wheels to 1 to make the robot go back and right.
        frontRightWheel.setPower(-1);
        backLeftWheel.setPower(-1);
        frontLeftWheel.setPower(1);
        backRightWheel.setPower(1);

        // Wait for 2 seconds.
        Thread.sleep(2000);

        // Set all four wheels to 0 to make the robot stop.
        frontRightWheel.setPower(0);
        backRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backLeftWheel.setPower(0);

        // Wait for 3 seconds.
        Thread.sleep(3000);

        // Set the front right and back left wheels to 1 and the front left and back right wheels to -1 to make the robot go forward and left.
        frontRightWheel.setPower(1);
        backLeftWheel.setPower(1);
        frontLeftWheel.setPower(-1);
        backRightWheel.setPower(-1);

        // Wait for 2 seconds.
        Thread.sleep(2000);

        // Set all four wheels to 0 to make the robot stop.
        frontRightWheel.setPower(0);
        backRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backLeftWheel.setPower(0);
    }

    class FrontRightWheel {

        private double power;

        public void setPower(double power) {
            this.power = power;
        }

        public double getPower() {
            return power;
        }
    }

    class BackRightWheel {

        private double power;

        public void setPower(double power) {
            this.power = power;
        }

        public double getPower() {
            return power;
        }
    }

    class FrontLeftWheel {

        private double power;

        public void setPower(double power) {
            this.power = power;
        }

        public double getPower() {
            return power;
        }
    }

    class BackLeftWheel {

        private double power;

        public void setPower(double power) {
            this.power = power;
        }

        public double getPower() {
            return power;
        }
    }
}
