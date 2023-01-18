package Main;

import java.util.ArrayList;
import java.util.List;

public class History {
    public List<String> history = new ArrayList<>();

    public int getSize(){
        return history.size();
    }

    public void addCalculation(String calculation) {
        history.add(calculation);
    }

    public void displayHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + 1 + ": " + history.get(i));
        }
    }

    public void clearHistory() {
        history.clear();
    }
}
