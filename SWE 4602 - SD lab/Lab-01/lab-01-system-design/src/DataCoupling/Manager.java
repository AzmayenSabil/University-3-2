package DataCoupling;

public class Manager {
    StorageHandler storageHandler;
    public Manager(StorageHandler handler){
        this.storageHandler = handler;
    }

    public void changeStock(int stockUsed){
        storageHandler.changeStock(stockUsed);
    }

    public void showStock(){
        storageHandler.showStock();
    }
}
