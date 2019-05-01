package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="*zoom*", group = "Autonomous")
//@Disable
public class Auto5361Depot extends LinearOpMode {

//-----------------------

    private static final double COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    private static final double DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    private static final double WHEEL_DIAMETER_INCHES   = 2 ;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;


    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor conveyorBelt;
    private Servo separator;

    //--------------------------

    @Override
    public void runOpMode() {
        //wheelInit("motorZoom");
        conveyorBelt = hardwareMap.get(DcMotor.class, "Conveyor Belt");
        conveyorBelt.setDirection(DcMotor.Direction.FORWARD);
        conveyorBelt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        separator = hardwareMap.get(Servo.class, "Separator");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

//-------------------- // (((IP)))

        conveyorBelt.setPower(1);
        telemetry.addData("Status", "Moving");
        telemetry.update();
        encoderDrive(1,36, 10);
        sleep(1000);

    }

    public void encoderDrive(double speed,
                             double leftInches,
                             double timeoutS) {
        int newLeftTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = conveyorBelt.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
           

            conveyorBelt.setTargetPosition(newLeftTarget);
           
            // Turn On RUN_TO_POSITION
            conveyorBelt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            
            // reset the timeout time and start motion.
            runtime.reset();
            conveyorBelt.setPower(Math.abs(speed));

            
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (conveyorBelt.isBusy())) {

                         }

            // Stop all motion;
            conveyorBelt.setPower(0);
            

            // Turn off RUN_TO_POSITION
            conveyorBelt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           
        }
    }
}
