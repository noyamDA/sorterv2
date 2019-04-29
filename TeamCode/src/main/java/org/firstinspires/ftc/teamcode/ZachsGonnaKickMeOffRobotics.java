package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="DriverControlled13475", group="LinearOpMode")

public class ZachsGonnaKickMeOffRobotics extends LinearOpMode {

    private DcMotor rightDrive = null;
    private DcMotor leftDrive = null;
    private DcMotor landerRiserA = null;
    private DcMotor landerRiserB = null;
    private DcMotor spinnyArmExt = null;
    private DcMotor spinnyArmTiltA = null;
    private DcMotor spinnyArmTiltB = null;
    private CRServo spinnerA = null;
    private CRServo spinnerB = null;
    private Servo dumperA = null;
    private Servo dumperB = null;
    private Servo flippy = null;


    @Override
    public void runOpMode() {
        setUp();
        boolean flipperCount= false;
        int spinnerCount = 0;

        while(opModeIsActive()) {

            float driveLeft = gamepad1.left_stick_y;
            float driveRight = gamepad1.right_stick_y;
            float landerRiserpwr = gamepad1.left_trigger - gamepad1.right_trigger;

            while (gamepad2.dpad_down) {
                spinnyArmTiltA.setPower(-.5);
                spinnyArmTiltB.setPower(-.5);
            }



            leftDrive.setPower(driveLeft);
            rightDrive.setPower(driveRight);
            landerRiserA.setPower(landerRiserpwr);
            landerRiserB.setPower(landerRiserpwr);

            if (gamepad2.y) {

                if (flipperCount == false) {
                    flippy.setPosition(0);
                    flipperCount = true;
                } else if (flipperCount == true) {
                    flippy.setPosition(1);
                    flipperCount = false;
                }
            }

        }
    }

    private void setUp(){


        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        landerRiserA = hardwareMap.get(DcMotor.class, "landerRiserA");
        landerRiserB = hardwareMap.get(DcMotor.class, "landerRiserB");

        flippy = hardwareMap.servo.get("flippy");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
    }
}