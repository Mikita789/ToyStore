import java.util.ArrayList;

public class ToyStoreModel implements BasicStore {
    private ChooseItemInterface chooseModel;
    private GiveOutInterface giveOutModel;
    private String title;
    private String description;
    private ArrayList<StoreItemInterface> itemsArray = new ArrayList<>();
    private ArrayList<StoreItemInterface> selectedItemsArray = new ArrayList<>();

    public ToyStoreModel(String title, String description) {
        this.giveOutModel = new GiveOutModelWriteFile();
        this.chooseModel = new RandomChooseItemModelChance();
        this.title = title;
        this.description = description;
    }

    public ToyStoreModel(String title) {
        this.giveOutModel = new GiveOutModelWriteFile();
        this.chooseModel = new RandomChooseItemModelChance();
        this.title = title;
        this.description = "Basic ToyStore";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChooseModel(ChooseItemInterface chooseModel) {
        this.chooseModel = chooseModel;
    }

    public void setGiveOutModel(GiveOutInterface giveOutModel) {
        this.giveOutModel = giveOutModel;
    }

    @Override
    public String toString() {
        return "ToyStoreModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void addItem(StoreItemInterface item){
        Boolean flag = true;
        for(StoreItemInterface element : itemsArray){
            if(element.getName().equals(item.getName())){
                System.out.println("Такой элемент уже есть. не могу добавить");
                flag = false;
                break;
            }
        }
        if(flag) {
            this.itemsArray.add(item);
        }
    }
    public void printAllItems(){
        System.out.println("---------------------------------------------------");
        System.out.printf("Ассортимент магазина %s:", this.title);
        System.out.println();
        for(StoreItemInterface item : this.itemsArray){
            System.out.println(item.toString());
        }
        System.out.println("---------------------------------------------------");
    }
    public void printAllSelectedItems(){
        if(!this.selectedItemsArray.isEmpty()){
            System.out.println("---------------------------------------------------");
            System.out.printf("Случайные подарки из магазина %s ожидают выдачи:", this.title);
            System.out.println();
            for(StoreItemInterface item : this.selectedItemsArray){
                System.out.println(item.toStringSelected());
            }
            System.out.println("---------------------------------------------------");
        }else{
            System.out.println("Все игрушки выданы. Список для выдачи пуст.");
        }

    }

    public void chooseItem(){
        StoreItemInterface element = this.chooseModel.chooseItem(this.itemsArray);
        this.selectedItemsArray.add(element);
    }

    public void giveOutAllPrizes(){
        this.giveOutModel.giveOutAllPrizes(this.selectedItemsArray);
    }
    public void giveOutPrize(String namePrize){
        this.giveOutModel.giveOutPrize(this.selectedItemsArray, namePrize);
    }
}
