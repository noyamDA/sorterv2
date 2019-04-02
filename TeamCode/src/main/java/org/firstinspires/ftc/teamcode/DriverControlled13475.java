package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//hello, i am test. dont remove me pls - ok, now u can
/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Hardware may touch this one", group="LinearOpMode")
//@Disabled
public class DriverControlled13475 extends LinearOpMode {

    // Declare OpMode members.
    //private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor landerRiser1 = null;
    private DcMotor landerRiser2 = null;

    private DcMotor spinnyArmExt = null;
    private DcMotor spinnyArmTilt1 = null;
    private DcMotor spinnyArmTilt2 = null;

    private CRServo spinner1 = null;
    private CRServo spinner2 = null;
    private Servo dumper1 = null;
    private Servo dumper2 = null;
    private Servo flippy = null;
    private Servo pusher1 = null;
    private Servo pusher2 = null;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        setUp();
        boolean flipperCount = false;
        int spinnerCount = 0;
        double servoPower=0;


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //motors

            float driveLeft = gamepad1.left_stick_y;
            float driveRight = gamepad1.right_stick_y;
            float landerRiserpwr = gamepad1.left_trigger - gamepad1.right_trigger;

            //float spinnyArmExtpwr = gamepad2.right_trigger - gamepad2.left_trigger;
/*
            while (gamepad2.dpad_down) {//in
                spinnyArmTilt1.setPower(-.5);
                spinnyArmTilt2.setPower(-.5);
                spinnyArmExt.setPower(-.11);
            }
            while (gamepad2.dpad_up) {//out
                spinnyArmTilt1.setPower(.5);
                spinnyArmTilt2.setPower(.5);
                spinnyArmExt.setPower(.11);

            }
            if (!(gamepad2.dpad_up || gamepad2.dpad_down)) {
                spinnyArmTilt1.setPower(0);
                spinnyArmTilt2.setPower(0);
                spinnyArmExt.setPower(0);

            }
*/

            leftDrive.setPower(driveLeft);
            rightDrive.setPower(driveRight);
            landerRiser1.setPower(landerRiserpwr);
            landerRiser2.setPower(landerRiserpwr);
            //spinnyArmExt.setPower(spinnyArmExtpwr);

            //servos code

//Spinners
                if (gamepad2.x) {//spin in
                    spinner2.setPower(-1);
                    spinner1.setPower(1);
                    spinnerCount = 1;
                } else if (gamepad2.a) {//spin stop
                    spinner2.setPower(0);
                    spinner1.setPower(0);
                    spinnerCount = 2;
                } else if (gamepad2.b) {//spin out
                    spinner2.setPower(1);
                    spinner1.setPower(-1);
                    spinnerCount = 0;
                }


//dumper
            if (gamepad2.right_bumper) {
                dumper1.setPosition(.5);
                dumper2.setPosition(.5);
            }
            if (gamepad2.left_bumper) {
                dumper1.setPosition(.002);
                dumper2.setPosition(.002);
            }

//flipper

            if (gamepad2.y) {

                if (flipperCount == false) {
                    flippy.setPosition(0);
                    flipperCount = true;
                } else if (flipperCount == true) {
                    flippy.setPosition(1);
                    flipperCount = false;
                }
            }

            if(gamepad2.dpad_down){
                    pusher2.setPosition(0);
                    pusher1.setPosition(0);
            }
            if(gamepad2.dpad_up){
                    runtime.reset();
                    while (true){

                    runtime.startTime();
                pusher2.setPosition(servoPower);
                pusher1.setPosition(servoPower);
                servoPower = (runtime.milliseconds()*runtime.milliseconds())/1000;
                if((servoPower >= 1)||!gamepad2.dpad_up){
                    servoPower=0;
                    break;
                }
                    }

            }
            //feedback();
        }
    }
    private void setUp(){
        //telemetry.addData("Status", "Initializing. Or is it?");
        //telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        landerRiser1 = hardwareMap.get(DcMotor.class, "lander_riser1");
        landerRiser2 = hardwareMap.get(DcMotor.class, "lander_riser2");

        spinnyArmExt = hardwareMap.get(DcMotor.class, "spinny_arm_ext");
        spinnyArmTilt1 = hardwareMap.get(DcMotor.class, "spinny_arm_tilt1");
        spinnyArmTilt2 = hardwareMap.get(DcMotor.class, "spinny_arm_tilt2");


        spinner1 = hardwareMap.crservo.get("spinner1");
        spinner2 = hardwareMap.crservo.get( "spinner2");
        dumper1= hardwareMap.servo.get("dumper1");
        dumper2= hardwareMap.servo.get("dumper2");
        flippy= hardwareMap.servo.get("flippy_flipper");
        pusher1= hardwareMap.servo.get("pusher1");
        pusher2= hardwareMap.servo.get("pusher2");



        spinnyArmExt.setDirection(DcMotor.Direction.REVERSE);
        spinnyArmTilt1.setDirection(DcMotor.Direction.FORWARD);
        spinnyArmTilt2.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        pusher2.setDirection(Servo.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //runtime.reset();
    }
    private void feedback () {
        //Show the elapsed game time and wheel power.
        //telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftDrive, rightDrive);
        //telemetry.update();
    }
}