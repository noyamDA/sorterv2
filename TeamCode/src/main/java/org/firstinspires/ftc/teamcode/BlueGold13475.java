package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//this is a test for github - please ignore

    @Autonomous(name = "NO TOUCHY!BG", group = "Autonomous")
//@Disabled
    public class BlueGold13475 extends LinearOpMode {
        private GoldAlignDetector detector;

        private DcMotor leftDrive = null;
        private DcMotor rightDrive = null;


        private DcMotor landerRiser1 = null;
        private DcMotor landerRiser2 = null;
        private Servo flippy = null;

        private ElapsedTime runtime = new ElapsedTime();

        static final double COUNTS_PER_MOTOR_REV = 1220;    // eg: TETRIX Motor Encoder
        static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
        static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
        static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                (WHEEL_DIAMETER_INCHES * 3.1415);
        static final double DRIVE_SPEED = 0.6;
        static final double TURN_SPEED = 0.5;
        static final double RISER_SPEED = 0.5;


        @Override
        public void runOpMode() {

            setUp();
            waitForStart();

            if(detector.getXPosition()>=0 && (detector.getXPosition()<229)){
                //left
                detector.disable();
                encoderDrive(1,0,0,3,5);
                encoderDrive(.3, 2.5, 2.5, 0, 5.0);
                encoderDrive(.3, 3, -3, 0, 5.0);
                encoderDrive(.3, -3.5, -3.5, 0, 5.0);
                encoderDrive(.3, -3, 3, 0, 5.0);

                encoderDrive(DRIVE_SPEED, -13.5, 13.5, 0, 5.0);//turn to face balls
                encoderDrive(DRIVE_SPEED, 3, 3, 0, 5.0);//not totlly sure why this is here tbh
                encoderDrive(DRIVE_SPEED, 7.5, -7.5, 0, 5.0);//turn 60
                encoderDrive(DRIVE_SPEED, 18, 18, 0, 5.0); //move to ball 1
                encoderDrive(DRIVE_SPEED, 7.5, -7.5, 0, 5.0);//turn 60
                encoderDrive(DRIVE_SPEED, 15, 15, 0, 5.0);//onward

                encoderDrive(DRIVE_SPEED, 5, -5, 0, 5.0);//turn to hit ball
                encoderDrive(.2, -13, -13, 0, 5.0);//hit ball
                encoderDrive(DRIVE_SPEED, 13, 13, 0, 5.0);//reverse
                encoderDrive(DRIVE_SPEED, -6, 6, 0, 5.0);//reverse

                encoderDrive(DRIVE_SPEED, -70, -70, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -6, 6, 0, 5.0);//turn 60
                encoderDrive(DRIVE_SPEED, 40, 40, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -24, 24, 0, 5.0);
                flippy.setPosition(0);
                sleep(1000);
                flippy.setPosition(1);
                encoderDrive(DRIVE_SPEED, 54, 54, 0, 5.0);//backup





            }
            else if((detector.getXPosition()>=230) && (detector.getXPosition()<449)){
                //middle
                detector.disable();
                encoderDrive(.3, 2.5, 2.5, 0, 5.0);
                encoderDrive(.3, 3, -3, 0, 5.0);
                encoderDrive(.3, -3.5, -3.5, 0, 5.0);
                encoderDrive(.3, -3, 3, 0, 5.0);
                encoderDrive(DRIVE_SPEED, 11, -11, 0, 5.0);//turn to face balls
                encoderDrive(.3, -16, -16, 0, 5.0);//hit mid ball
                encoderDrive(DRIVE_SPEED, 4, 4, 0, 5.0);//return
                encoderDrive(DRIVE_SPEED, -11.5, 11.5, 0, 5.0);//turn to backup

                encoderDrive(DRIVE_SPEED, -45, -45, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -6, 6, 0, 5.0);//turn 60
                encoderDrive(DRIVE_SPEED, 50, 50, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -24.5, 24.5, 0, 5.0);
                flippy.setPosition(0);
                sleep(1000);
                flippy.setPosition(1);
                encoderDrive(DRIVE_SPEED, 54, 54, 0, 5.0);//backup



            }
            else if(detector.getXPosition()>=450){
                //right
                detector.disable();
                encoderDrive(.3, 2.5, 2.5, 0, 5.0);
                encoderDrive(.3, 3, -3, 0, 5.0);
                encoderDrive(.3, -3.5, -3.5, 0, 5.0);
                encoderDrive(.3, -3, 3, 0, 5.0);
                encoderDrive(DRIVE_SPEED, 11, -11, 0, 5.0);//turn to face balls
                encoderDrive(.3, -9, -9, 0, 5.0);//move into intersection
                encoderDrive(DRIVE_SPEED, -11.5, 11.5, 0, 5.0);//turn
                encoderDrive(DRIVE_SPEED, -11, -11, 0, 5.0);//move to ball
                encoderDrive(DRIVE_SPEED, 11.5, -11.5, 0, 5.0);//turn to face ball

                encoderDrive(.3, -13, -13, 0, 5.0);//hit ball
                encoderDrive(DRIVE_SPEED, 10, 10, 0, 5.0);//return
                encoderDrive(DRIVE_SPEED, -11.5, 11.5, 0, 5.0);//turn to backup

                encoderDrive(DRIVE_SPEED, -35, -35, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -6, 6, 0, 5.0);//turn 60
                encoderDrive(DRIVE_SPEED, 50, 50, 0, 5.0);//backup
                encoderDrive(DRIVE_SPEED, -24.5, 24.5, 0, 5.0);
                flippy.setPosition(0);
                sleep(1000);
                flippy.setPosition(1);
                encoderDrive(DRIVE_SPEED, 54, 54, 0, 5.0);//backup




            }

        }

        /*
         *  Move will stop if any of three conditions occur:
         *  1) Move gets to the desired position
         *  2) Move runs out of time
         *  3) Driver stops the opmode running.
         */
        public void encoderDrive(double speed,
                                 double leftInches, double rightInches, double riser,
                                 double timeoutS) {
            int newLeftTarget;
            int newRightTarget;
            int newRiserTarget;

            // Ensure that the opmode is still active
            if (opModeIsActive()) {

                // Determine new target position, and pass to motor controller
                newLeftTarget = leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
                newRightTarget = rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

                newRiserTarget = landerRiser1.getCurrentPosition() + (int) (riser * COUNTS_PER_INCH);
                newRiserTarget = landerRiser2.getCurrentPosition() + (int) (riser * COUNTS_PER_INCH);

                leftDrive.setTargetPosition(newLeftTarget);
                rightDrive.setTargetPosition(newRightTarget);

                landerRiser1.setTargetPosition(newRiserTarget);
                landerRiser2.setTargetPosition(newRiserTarget);

                // Turn On RUN_TO_POSITION
                leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                landerRiser1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                landerRiser2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                // reset the timeout time and start motion.
                runtime.reset();
                leftDrive.setPower(Math.abs(speed));
                rightDrive.setPower(Math.abs(speed));
                landerRiser1.setPower(Math.abs(speed));
                landerRiser2.setPower(Math.abs(speed));

                // keep looping while we are still active, and there is time left, and both motors are running.
                // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
                // its target position, the motion will stop.  This is "safer" in the event that the robot will
                // always end the motion as soon as possible.
                // However, if you require that BOTH motors have finished their moves before the robot continues
                // onto the next step, use (isBusy() || isBusy()) in the loop test.
                while (opModeIsActive() &&
                        (runtime.seconds() < timeoutS) &&
                        (leftDrive.isBusy() && rightDrive.isBusy() || landerRiser1.isBusy())) {

                    // Display it for the driver.
                    telemetry.addData("Path1", "Running to %7d :%7d :%7d", newLeftTarget, newRightTarget, newRiserTarget);
                    telemetry.addData("Path2", "Running at %7d :%7d :%7d",
                            leftDrive.getCurrentPosition(),
                            rightDrive.getCurrentPosition(),
                            landerRiser1.getCurrentPosition());
                    telemetry.update();
                }

                // Stop all motion;
                leftDrive.setPower(0);
                rightDrive.setPower(0);
                landerRiser1.setPower(0);
                landerRiser2.setPower(0);

                // Turn off RUN_TO_POSITION
                leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                landerRiser1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                landerRiser2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                //  sleep(250);   // optional pause after each move
            }
        }


        private void setUp() {
            /*
             * Initialize the drive system variables.
             * The init() method of the hardware class does all the work here
             */
            leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
            rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
            landerRiser1 = hardwareMap.get(DcMotor.class, "lander_riser1");
            landerRiser2 = hardwareMap.get(DcMotor.class, "lander_riser2");
            flippy= hardwareMap.servo.get("flippy_flipper");

            leftDrive.setDirection(DcMotor.Direction.FORWARD);
            rightDrive.setDirection(DcMotor.Direction.REVERSE);


            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Resetting Encoders");
            telemetry.update();

            leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            landerRiser1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            landerRiser2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            landerRiser1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            landerRiser2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // Send telemetry message to indicate successful Encoder reset
            telemetry.addData("Path0", "Starting at %7d :%7d :%7d",
                    leftDrive.getCurrentPosition(),
                    rightDrive.getCurrentPosition(),
                    landerRiser1.getCurrentPosition());
            telemetry.update();

            //DodeCV stuff



            // Set up detector
            telemetry.addData("Status", "DogeCV 2018.0 - Gold Align Example");

            // Set up detector
            detector = new GoldAlignDetector(); // Create detector
            detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance()); // Initialize it with the app context and camera
            detector.useDefaults(); // Set detector to use default settings

            // Optional tuning
            detector.alignSize = 100; // How wide (in pixels) is the range in which the gold object will be aligned. (Represented by green bars in the preview)
            detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
            detector.downscale = 0.4; // How much to downscale the input frames

            detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
            //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
            detector.maxAreaScorer.weight = 0.005; //

            detector.ratioScorer.weight = 5; //
            detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment

            detector.enable(); // Start the detector!

        }
    }