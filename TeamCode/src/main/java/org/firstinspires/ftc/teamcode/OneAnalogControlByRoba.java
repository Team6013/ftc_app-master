package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Roba Abbajabal on 10/11/17.
 */

@TeleOp(name="OneAnalogControlByRoba", group="AnalogControlByRoba") //Calls this class (program) a teleop so it can be run at the driver station.
//@Disabled  //Disables this script from showing up in the driver station.

public class OneAnalogControlByRoba extends OpMode {  //Basic class where the code runs and extends this to the Opmode procedures.

    private ElapsedTime runTime = new ElapsedTime(); //Creates a time for the amount of time driven on the drive station.
    private DcMotor leftMotor = null; //Makes a variable called leftMotor.
    private DcMotor rightMotor = null; //Makes a variable called  rightMotor.
    private Servo leftClaw = null; //Makes a variable called leftClaw.
    private Servo rightClaw = null; //Makes a variable called rightClaw.


    @Override
    public void start() { //Runs once after driver hits start.

        runTime.reset(); //Resets the time driven on the driver station.
        telemetry.addData("Status", "This script has been made by Roba! " + "The robot has started running! ");
    }

    @Override
    public void loop() { //Runs repeatedly after driver hits start until driver hits end.

        if (gamepad1.left_stick_x > 0.5) { //When setting the left analog stick to right.
            leftMotor.setPower(0.01);
            rightMotor.setPower(1.0);
        }
        if (gamepad1.left_stick_x < -0.5) { //When setting the left analog stick to left.
            leftMotor.setPower(1.0);
            rightMotor.setPower(0.01);
        }
        if (gamepad1.left_stick_y > 0.5) { //When setting the left analog stick to down.
            leftMotor.setPower(-1.0);
            rightMotor.setPower(-1.0);
        }
        if (gamepad1.left_stick_y < -0.5) { //When setting the left analog stick to up.
            leftMotor.setPower(1.0);
            rightMotor.setPower(1.0);
        }
        if (gamepad1.left_stick_x == 0 && gamepad1.left_stick_y == 0) { //When resting the left analog stick.
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
        }
        telemetry.addData("Status", "This robot has been running for " + runTime.toString()); //Message for robot controller.
        telemetry.addData("Motors", "Left Motor's Power: , Right Motor's Power: ", leftMotor.getPowerFloat(), rightMotor.getPowerFloat()); //Message for robot controller.
    }

    @Override
    public void init() { //Runs once after driver hits initiate.

        telemetry.addData("Status", "Robot is initializing..."); //Message for robot controller.

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor"); //Gets the drivers for the leftMotor.
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor"); //Gets the drivers for the rightMotor.
        leftClaw = hardwareMap.get(Servo.class, "leftClaw"); //Gets the drivers for the leftServo.
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");


        leftMotor.setDirection(DcMotor.Direction.FORWARD); //Sets the direction of the motor.
        rightMotor.setDirection(DcMotor.Direction.REVERSE); //Sets the direction of the motor.
        leftClaw.setDirection(Servo.Direction.FORWARD); //Sets the direction of the servo.
        rightClaw.setDirection(Servo.Direction.REVERSE); //Sets the direction of the servo.

        telemetry.addData("Status", "Robot has successfully initialized!"); //Message for robot controller.
    }

    @Override
    public void init_loop() { //Runs repeatedly after driver hits initiate until driver hits stop.

    }

    @Override
    public void stop() {  //Runs once after driver hits stop.

        telemetry.addData("Status", "Robot has stopped!");
    }
}
