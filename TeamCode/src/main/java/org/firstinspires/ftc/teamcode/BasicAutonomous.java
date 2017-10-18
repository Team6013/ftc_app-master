package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Roba Abbajabal on 10/13/17.
 */

/*
 *           README: Commands made by Roba Abbajabal
 *--------------------------------------------------------------
 * forward(motorPower, timeInMilliseconds);
 * backward(motorPower, timeInMilliseconds);
 * left(motorPower, timeInMilliseconds);
 * right(motorPower, timeInMilliseconds);
 * stop_driving();
 *
 * IMPORTANT NOTE: motorPower can range between 0 to 1, 0 being no movement and 1 being full forward. motorPower can be written in decimal numbers. (Ex: 0, 0.4, 1)
 *                 timeInMilliseconds does not accept decimal/fractional numbers.
 *                 Start where it says "Begin editing code here." and end where it says "Stop editing code here." DO NOT edit any code outside of those two comments!
 */

@Autonomous(name="BasicAutonomous", group="")
//@Disabled

public class BasicAutonomous extends LinearOpMode {

    private ElapsedTime runTime = new ElapsedTime();
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private Servo leftClaw = null;
    private Servo rightClaw = null;

    @Override
    public void runOpMode() throws InterruptedException{

        telemetry.addData("Status", "This script has been made by the FTC Programming Team! " + "The robot has initialized! ");

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftClaw.setDirection(Servo.Direction.FORWARD);
        rightClaw.setDirection(Servo.Direction.REVERSE);


        //Begin editing code here.
        forward(0.5, 5000);
        left(0.5, 2000);

        stop_driving();
        //Stop editing code here.

    }


    public void forward(double motorPower, long timeInMilliseconds) throws InterruptedException{
        leftMotor.setPower(motorPower);
        rightMotor.setPower(motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        telemetry.addData("Motors", "The robot's right motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        Thread.sleep(timeInMilliseconds);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
    public void backward(double motorPower, long timeInMilliseconds) throws InterruptedException{
        leftMotor.setPower(motorPower);
        rightMotor.setPower(motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        telemetry.addData("Motors", "The robot's right motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        Thread.sleep(timeInMilliseconds);
        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }
    public void left(double motorPower, long timeInMilliseconds) throws InterruptedException{
        leftMotor.setPower(motorPower);
        rightMotor.setPower(-motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        telemetry.addData("Motors", "The robot's right motor is running at " + -motorPower + " for " + timeInMilliseconds + " milliseconds.");
        Thread.sleep(timeInMilliseconds);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
    public void right(double motorPower, long timeInMilliseconds) throws InterruptedException{
        leftMotor.setPower(-motorPower);
        rightMotor.setPower(motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + -motorPower + " for " + timeInMilliseconds + " milliseconds.");
        telemetry.addData("Motors", "The robot's right motor is running at " + motorPower + " for " + timeInMilliseconds + " milliseconds.");
        Thread.sleep(timeInMilliseconds);
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
    public void stop_driving() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        telemetry.addData("Status", "The robot has finished moving!");
    }
}
