public interface StoreItemInterface {
    Integer getId();
    String getName();
    Integer getChance();
    void setCount(Integer count);
    void setChance(Integer chance);
    Integer getCount();
    String toString();
    String toStringSelected();

}
