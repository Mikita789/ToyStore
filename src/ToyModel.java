import java.util.Random;

public class ToyModel implements StoreItemInterface {
    Random rd = new Random();
    private Integer id;
    private String name;
    private Integer count;
    private Integer chance;
    public ToyModel(String name, Integer count, Integer chance) {
        this.name = name;
        this.count = count;
        this.chance = chance;
        this.id = (rd.nextInt(100, 1000) - rd.nextInt(1, 100)) * rd.nextInt(1, 20);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        System.out.printf("Количество изменено на %d", this.count);
        System.out.println();
        System.out.println();

    }

    public Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
        System.out.printf("Шанс изменен на %d", this.chance);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ToyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", chance=" + chance +
                '}';
    }

    public String toStringSelected(){
        return "ToyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
