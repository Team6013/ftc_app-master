package org.firstinspires.ftc.teamcode;

/**
 * Created by Roba Abbajabal on 10/13/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptVuforiaNavigation;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import static com.sun.tools.javac.util.Constants.format;

@Autonomous(name="VuforiaVuMarksIdentification", group ="VuforiaVuMarksIdentification")
//@Disabled
public class VuforiaVuMarksIdentification extends LinearOpMode {

    VuforiaLocalizer vuforia;

    @Override public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AYopJqz/////AAAAGd7dq6/IAUxmkk2YPfuDDJIScTBeUahXwWW5cAm30qYh06uJbRTEnM8XQZqYPwsQ8r+kp4FkQIU8LqTpk3C+FN8F1W7b/LKOCPXqa33IVgjfo6jzH7fi3mtIhfmtAFv3Tl01wDI2iKamifnWinRD829j20xg6hRGb2xpdNz1c2YiOuQJ+wGPW/orzwsvGObXwz1LOxY9YcSI8ZbWf8QtFoez/iy0sI4ESLDeVysCqBYb3mYLY917Z5rOnppu/9pN1ytcgL4Qv/Qb+wX0oHcxwnUACGjEMQV0AxYY9ENrO+5VuxDTEQYhN/CSo6aQjfwEQrOe2GkAsntyriI/RsKQ+kocIhkGXFKQ3A9A0Ots1Y4K";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        parameters.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                telemetry.addData("VuMark", "%s visible", vuMark);

                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)relicTemplate.getListener()).getPose();
                telemetry.addData("Pose", format(pose));

                if (pose != null) {
                    VectorF trans = pose.getTranslation();
                    Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                    double tX = trans.get(0);
                    double tY = trans.get(1);
                    double tZ = trans.get(2);

                    double rX = rot.firstAngle;
                    double rY = rot.secondAngle;
                    double rZ = rot.thirdAngle;

                    if(vuMark == RelicRecoveryVuMark.LEFT) {
                        telemetry.addData("VuMark is ", "Left");
                        telemetry.addData("X =", tX);
                        telemetry.addData("Y =", tY);
                        telemetry.addData("Z =", tZ);
                    } else if (vuMark == RelicRecoveryVuMark.CENTER) {
                        telemetry.addData("VuMark is ", "Center");
                        telemetry.addData("X =", tX);
                        telemetry.addData("Y =", tY);
                        telemetry.addData("Z =", tZ);

                    } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                        telemetry.addData("VuMark is ", "Right");
                        telemetry.addData("X =", tX);
                        telemetry.addData("Y =", tY);
                        telemetry.addData("Z =", tZ);

                    }
                }

            }
            else {
                telemetry.addData("VuMark", "not visible");
            }

            telemetry.update();
        }
    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
