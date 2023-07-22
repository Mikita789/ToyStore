import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiveOutModelWriteFile implements GiveOutInterface {
    @Override
    public void giveOutAllPrizes(ArrayList<StoreItemInterface> prizesArray){
        Integer countPrizes = prizesArray.size();
        for(StoreItemInterface item : prizesArray){
            this.savePrizeToFile(item);
        }
        prizesArray = new ArrayList<StoreItemInterface>();
        System.out.printf("Все призы выданы. (%d шт.)", countPrizes);
        System.out.println();
    }

    @Override
    public void giveOutPrize(ArrayList<StoreItemInterface> prizesArray, String namePrize) {
        boolean flag = false;
        for(StoreItemInterface item : prizesArray){
            if(item.getName().equals(namePrize)){
                this.savePrizeToFile(item);
                prizesArray.remove(item);
                System.out.println("ВЫДАН");
                System.out.println(item.toStringSelected());
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Такой игрушки нет в списке для выдачи");
        }
    }

    private void savePrizeToFile(StoreItemInterface prize) {
        DateFormat df = new SimpleDateFormat("d.MM.yyyy в HH:mm:ss");
        String currentDateTime = df.format(new Date());
        try (PrintWriter writer = new PrintWriter(new FileWriter("prizes.txt", true))) {
            writer.println("Выдан приз:  ID " + prize.getId() + "/имя -" + prize.getName() + "-/время выдачи " + currentDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
