package StampCollecting;

public class ImageHandler {
    PersonalProfile profile;
    public ImageHandler(PersonalProfile personalProfile){
        this.profile = personalProfile;
    }

    public void handleImage(){
        System.out.println("Manipulating only "+profile.imageLink+" and "+profile.name);
    }
}
