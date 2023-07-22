public interface BasicStore {
    String getTitle();
    String toString();
    String getDescription();
    void setDescription(String description);
    void addItem(StoreItemInterface item);
    void printAllItems();
    void chooseItem();
    void printAllSelectedItems();
    void setChooseModel(ChooseItemInterface chooseModel);
    void setGiveOutModel(GiveOutInterface giveOutModel);
}
