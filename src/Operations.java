import java.util.Scanner;
public class Operations {


    public static void main() {

        Machine machine = new Machine();
        machine.addToMachine();
        boolean shutDown =false;

        while (!shutDown) {
        System.out.println(machine);
        System.out.println("Welcome.. please choose your beverage : \n" +
                "for cola press A1 -- A3 \n" +
                "for orange press B1 -- B3 \n" +
                "for XL press C1 -- C3 \n" +
                "for reboot press R \n" +
                "for End and ShutDown press C \n" +
                "The machine waiting for your choice.... ");

        Scanner scanner = new Scanner(System.in);

        String action = scanner.next().toUpperCase();


            switch (action) {
                case "A1", "A2", "A3" -> machine.getBeverage(machine.cola);
                case "B1", "B2", "B3" -> machine.getBeverage(machine.orange);
                case "C1", "C2", "C3" -> machine.getBeverage(machine.XL);
                case "R" -> {
                    System.out.println("you reboot the machine all the setting are default now !");
                    try {
                        Thread.sleep(1500);
                        System.out.println("bip..");
                        Thread.sleep(1500);
                        System.out.println("bop..");
                        Thread.sleep(1500);
                        System.out.println("bip..");
                        System.out.println("the machine booted successfully !");
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Operations.main();
                }
                case "C" -> shutDown = true;
            }
        }
    }

}
