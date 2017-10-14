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
 * turn(leftMotorPower, rightMotorPower, timeInMilliseconds);
 * stop_driving();
 *
 * IMPORTANT NOTE: motorPower can range between -1 to 1, -1 being full reverse, 0 being no movement, and 1 being full forward. motorPower can be written in decimal numbers. (Ex: -1, -0.6, 0, 0.4, 1)
 *                 timeInMilliseconds does not accept decimal/fractional numbers.
 *                 Start where it says "Begin editing code here." and end where it says "Stop editing code here." DO NOT edit any code outside of those two comments!
 */

@Autonomous(name="AutonomousBlueLeftByRoba", group="AutonomousByRoba")
//@Disabled

public class AutonomousBlueLeftByRoba extends LinearOpMode {

    private ElapsedTime runTime = new ElapsedTime(); //Creates a time for the amount of time driven on the drive station.
    private DcMotor leftMotor = null; //Makes a variable called leftMotor.
    private DcMotor rightMotor = null; //Makes a variable called  rightMotor.
    private Servo leftClaw = null; //Makes a variable called leftClaw.
    private Servo rightClaw = null; //Makes a variable called rightClaw.

    @Override
    public void runOpMode() throws InterruptedException{

        telemetry.addData("Status", "This script has been made by Roba! " + "The robot has initialized! ");

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor"); //Gets the drivers for the leftMotor.
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor"); //Gets the drivers for the rightMotor.
        leftClaw = hardwareMap.get(Servo.class, "leftClaw"); //Gets the drivers for the leftServo.
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        leftMotor.setDirection(DcMotor.Direction.FORWARD); //Sets the direction of the motor.
        rightMotor.setDirection(DcMotor.Direction.REVERSE); //Sets the direction of the motor.
        leftClaw.setDirection(Servo.Direction.FORWARD); //Sets the direction of the servo.
        rightClaw.setDirection(Servo.Direction.REVERSE); //Sets the direction of the servo.


        //Begin editing code here.
        forward(1, 10000);

        stop_driving();
        //Stop editing code here.

    }


    public void forward(double motorPower, long time) throws InterruptedException{
        leftMotor.setPower(motorPower);
        rightMotor.setPower(motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + motorPower);
        telemetry.addData("Motors", "The robot's right motor is running at " + motorPower);
        Thread.sleep(time);
    }
    public void backward(double motorPower, long time) throws InterruptedException{
        leftMotor.setPower(motorPower);
        rightMotor.setPower(motorPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + motorPower);
        telemetry.addData("Motors", "The robot's right motor is running at " + motorPower);
        Thread.sleep(time);

    }
    public void turn(double leftPower, double rightPower, long time) throws InterruptedException{
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
        telemetry.addData("Motors", "The robot's left motor is running at " + leftPower);
        telemetry.addData("Motors", "The robot's right motor is running at " + rightPower);
        Thread.sleep(time);
    }
    public void stop_driving() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        telemetry.addData("Status", "The robot has finished moving!");
    }
}