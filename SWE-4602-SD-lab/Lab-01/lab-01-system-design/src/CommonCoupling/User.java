package CommonCoupling;

public class User {
    public int user_id;
    PublicDocfile doc;

    public User(PublicDocfile publicDocfile){
        this.doc = publicDocfile;
    }

    public void readFromDoc(){
        doc.read();
    }

    public void writeOnDoc(String content){
        doc.write(content);
    }
}
