import java.util.ArrayList;

public interface GiveOutInterface {
    void giveOutAllPrizes(ArrayList<StoreItemInterface> prizesArray);
    void giveOutPrize(ArrayList<StoreItemInterface> prizesArray, String namePrize);
}
