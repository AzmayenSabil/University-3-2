package CommonCoupling;

public class PublicDocfile {
    public int doc_id;
    public static String contentOfDoc;

    public void read(){
        System.out.println(contentOfDoc);
    }

    public void write(String content){
        contentOfDoc = content;
    }

}
