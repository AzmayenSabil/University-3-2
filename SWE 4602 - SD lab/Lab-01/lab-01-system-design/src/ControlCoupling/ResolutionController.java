package ControlCoupling;

import static ControlCoupling.Internet.isSlow;

public class ResolutionController {
    public int resolution;

    public void controlResolution(){
        if(isSlow){
            resolution = 720;
        }else{
            resolution = 1080;
        }
    }

    public void showResolution(){
        System.out.println("Resolution : "+ resolution);
    }
}
