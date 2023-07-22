public class Program {
    public static void main(String[] args) {
        //создаем игрушки
        ToyModel item1 = new ToyModel("Мишка плюшевый", 2, 20);
        ToyModel item2 = new ToyModel("Маршал(собачий патруль)", 3, 10);
        ToyModel item3 = new ToyModel("Дарт Вейдер", 10, 10);
        ToyModel item4 = new ToyModel("Маша(Маша и медведь)", 5, 5);
        ToyModel item5 = new ToyModel("Баз Лайтер", 30, 40);
        ToyModel item6 = new ToyModel("Вуди", 10, 30);
        ToyModel item7 = new ToyModel("Майк", 10, 70);
        ToyModel item8 = new ToyModel("Салли", 10, 70);
        ToyModel item9 = new ToyModel("Грогу", 1, 2);


        System.out.println("_________________");
        //создаем магазин
        ToyStoreModel store = new ToyStoreModel("Буслик");
        System.out.println(store.toString());

        //добавляем игрушки в магазин
        store.addItem(item1);
        store.addItem(item2);
        store.addItem(item3);
        store.addItem(item4);
        store.addItem(item5);
        store.addItem(item6);
        store.addItem(item7);
        store.addItem(item8);
        store.addItem(item9);
        //выводим ассортимент
        store.printAllItems();

        //получаем подарки
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        store.chooseItem();
        //выводим подарки, ожидающие выдачи
        store.printAllSelectedItems();
        //выдаем игрушку
        store.giveOutPrize("майк");
        //выдаем все подарки
        store.giveOutAllPrizes();
        //выводим подарки, ожидающие выдачи
        store.printAllSelectedItems();

    }
}
