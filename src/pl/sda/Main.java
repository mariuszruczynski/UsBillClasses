package pl.sda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double dolarCost = 0;
        double tax = 0;
        Scanner sc = new Scanner(System.in);
        CountBill countBill = new CountBill();
        double shipingCost = 0;
        int removePos;



        System.out.println(" -- Entering Usa Bill --");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain menu:");
            System.out.println("1. Add articles");
            System.out.println("2. Show articles and parameters");
            System.out.println("3. Count bill");
            System.out.println("4. Remove article");
            System.out.println("5. Set value of tax");
            System.out.println("6. Set shiping price");
            System.out.println("7. Set dollar price");
            System.out.println("8. Exit");

            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    countBill.addArticles();
                    break;
                case 2:
                    System.out.println("Wartosc za 1 dolara : " + dolarCost + " zł, cło: "
                            + tax + " %, koszt transportu: " + shipingCost + " $");
                    countBill.showList(countBill.getArticles());
                    break;
                case 3:
                    if (tax == 0 || shipingCost == 0 || dolarCost == 0) {
                        System.out.println("Sprawdz czy wpisałeś koszt transportu, wartośc dolara i cło !!!");
                    } else {
                        countBill.countBill(countBill.getArticles(), dolarCost, tax, shipingCost);
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Lista artykułów: ");
                    countBill.showList(countBill.getArticles());
                    System.out.println("Podaj nr artykułu do usuniecia: ");
                    removePos = Integer.parseInt(sc.nextLine());

                    if (removePos > countBill.getArticles().size()) {
                        System.out.println("Error, position doesn't exit !!!!");
                        System.out.println("Try again !!!");
                    } else {
                        countBill.getArticles().remove((removePos - 1));
                    }
                    break;
                case 5:
                    System.out.println("Podaj wartość cła:");
                    tax = sc.nextDouble();
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Podaj  koszt przesyłki:");
                    shipingCost = sc.nextDouble();
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Podaj cene dodlara wg odprawy celnej");
                    dolarCost = sc.nextDouble();
                    sc.nextLine();
                    break;
                default:
                    exit = true;
            }
        }
    }
}
