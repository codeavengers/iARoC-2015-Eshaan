package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    int number = 0;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?
        //driveDirect(500, 500);


    }

    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        readSensors(SENSORS_INFRARED_BYTE);
        readSensors(SENSORS_WALL);
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
        int sensor = getInfraredByte();

if (sensor == 252){
    driveDirect(500, 500);
}
if (sensor == 250){
    driveDirect(460, 500 );
}
        if (sensor == 246){
         driveDirect (500, 460);
        }
        if (sensor == 254){
            driveDirect(500, 500);
        }
        if(sensor == 248){
            driveDirect(460, 500);
        }
if (sensor == 244){
    driveDirect(500, 460);
}
        if(sensor == 242){
            driveDirect(500, 500);
        }
        //if(sensor == 255){
          //  driveDirect(-500, 500);
            //SystemClock.sleep(1000);
            //driveDirect(500, 500);
        //}


            //dashboard.speak("" + getInfraredByte());
            //readSensors(SENSORS_WALL);
            //dashboard.speak("" + getWallSignal());
            //if(getWallSignal()>1){
            //dashboard.speak("nobody puts baby in a corner");


            // readSensors(SENSORS_DISTANCE);
            //number = number + getDistance();
            // readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
            // readSensors(SENSORS_DISTANCE);
            //number = number + getDistance();
            //if(isBumpRight() || isBumpLeft()) {
            //readSensors(SENSORS_DISTANCE);
            //number = number + getDistance();
            //dashboard.speak(number + ".");


        }
    }