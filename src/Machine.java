import utilities.Emoney;
import utilities.Product_Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Machine {

    List<Product_Item> items = new ArrayList<>();
    double money = 500;
    List<Double> emoneyList = new ArrayList<>(Arrays.asList(
            Emoney.CENT.getValue(),
            Emoney.FIFTY_CENT.getValue(),
            Emoney.SHEKEL.getValue(),
            Emoney.TOW_SHEKEL.getValue(),
            Emoney.FIVE.getValue(),
            Emoney.TEN.getValue(),
            Emoney.TWENTY.getValue(),
            Emoney.FIFTY.getValue(),
            Emoney.ONE_HUNDRED.getValue(),
            Emoney.TWO_HUNDRED.getValue()
    ));



    Product_Item cola = new Product_Item("cola" , 5 , 20);
    Product_Item orange = new Product_Item("orange" , 3 , 12);
    Product_Item XL = new Product_Item("XL" , 7 , 2);
    public Machine(){}

    public boolean addToMachine(){
        items.add(cola);
        items.add(orange);
        items.add(XL);
        return true;
    }

    public boolean getBeverage(Product_Item item){
        Scanner in = new Scanner(System.in);
        if (item.getCapacity()!=0){
            System.out.println(" name : " + item.getName() + ", cost : " + item.getCost() + ", capacity " + item.getCapacity());
            System.out.println("Are you want to purchase ? \n 0 to cancel and return \n 1 to purchase.. ");
            System.out.println("The machine waiting for your choice....");
            double choice = in.nextDouble();
            switch ((int) choice) {
                case 0:
                    return false;
                case 1:
                    System.out.println("Please insert your money to machine : ..." +
                            "\n you can insert only 0.1 , 0.5 , 1 , 2 , 5 , 10 , 20 , 50 , 100 , 200 ");
                    double clientMoney = in.nextDouble();
                    clientMoney = checkCoins(emoneyList,clientMoney);
                        while (!(clientMoney >= item.getCost())) {
                            System.out.println("no enough money please insert more " + (item.getCost() - clientMoney) +
                                    "if you don't have enough please press 0 " +
                                    "\nor to continue press 1 ");
                            choice = in.nextDouble();
                            switch ((int) choice) {
                                case 0 -> {
                                    System.out.println("don't forget your refund : " + clientMoney);
                                    return false;
                                }
                                case 1 -> {
                                    System.out.println("Please insert your money to machine : ..." +
                                            "\n you can insert only 0.1 , 0.5 , 1 , 2 , 5 , 10 , 20 , 50 , 100 , 200 ");
                                    double extraMoney = in.nextDouble();
                                    checkCoins(emoneyList, extraMoney);
                                    clientMoney = extraMoney + clientMoney;
                                }
                            }
                        }
                        double sum = clientMoney-item.getCost();
                        money = money - sum;

                        if (!(money>=0)) {
                            money = money+sum;
                            System.out.println(" Sorry i don't have enough change for you :( \n" +
                                    " please insert the exact amount of beverage..you can insert until " + money);
                            System.out.println("you received refund " + clientMoney +" and please try again..");
                            return false;
                        }
                    System.out.println("thank you for purchase don't forget your change : " + (clientMoney - item.getCost()));
                    item.setCapacity(item.getCapacity() - 1);
                    return true;
            }
        }
        System.out.println("Sorry .. end of capacity for this beverage .. waite for refill.");
        return false;
    }

    @Override
    public String toString() {
        items.forEach(item ->
                System.out.println(" name : " + item.getName() + ", cost : " + item.getCost() + ", capacity : " + item.getCapacity()));
        return"Machine 430 : for help Call to 02132454 \n";
    }

    public static double checkCoins(List<Double> List,double coins){
        Scanner in = new Scanner(System.in);
        while(!(List.contains(coins))) {
            System.out.println(" Sorry i don't except this please insert number from the list.. ");
            System.out.println("\n you can insert only 0.1 , 0.5 , 1 , 2 , 5 , 10 , 20 , 50 , 100 , 200 ");
            coins = in.nextDouble();
        }
        return coins;
    }

}

