import java.util.ArrayList;
import java.util.Random;

public class ChooseItemModel implements ChooseItemInterface{
    public StoreItemInterface chooseItem(ArrayList<StoreItemInterface> fromItemsArray){
        Integer totalProbability = 0;
        for(StoreItemInterface item : fromItemsArray){
            totalProbability += item.getChance();
        }

        Double rdNumber = this.randomDoubleRange(0.0, 100.0);
        Double accumulatedProbability = 0.0;
        for(StoreItemInterface item : fromItemsArray){
            accumulatedProbability += (Double.valueOf(item.getChance()) / Double.valueOf(totalProbability)) * 100;
            if(rdNumber <= accumulatedProbability){
                StoreItemInterface selectedItem = item;
                System.out.println("Выпал приз:   ");
                System.out.println(selectedItem.toStringSelected());
                if(item.getCount() > 1){
                    item.setCount(item.getCount() - 1);
                } else if (item.getCount() == 1) {
                    fromItemsArray.remove(item);
                }
                //this.selectedItemsArray.add(selectedItem);
                return selectedItem;
            }
        }
        System.out.println("наверное нет элементов :(");
        return null;
    }

    private Double randomDoubleRange(Double min, Double max){
        Random rd = new Random();
        Double randomValue = min + (max - min) * rd.nextDouble();
        return randomValue;
    }
}
