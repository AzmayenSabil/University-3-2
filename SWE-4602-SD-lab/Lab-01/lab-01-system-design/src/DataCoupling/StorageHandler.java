package DataCoupling;

public class StorageHandler {
    public int stockLeft = 1000;

    public void changeStock(int stockUsed){
        this.stockLeft = stockLeft - stockUsed;
    }

    public void showStock(){
        System.out.println("Stock left: "+ stockLeft);
    }
}
