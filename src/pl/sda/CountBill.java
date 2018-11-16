package pl.sda;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountBill {
    private String name;
    private Double cost;
    private int number;
    private Scanner sc = new Scanner(System.in);
    private int i = 0;
    private String dec = " ";
    private List<Articles> articles = new ArrayList<>();

    public void countBill(List<Articles> articles, Double dolarCost, Double tax, Double shipingCost) {
        double shipingCostOneProduct;
        BigDecimal totalCost;
        double shipingCostInZl = shipingCost * dolarCost / articles.size();

        if(articles.isEmpty()){

            System.out.println("Nie dodałeś żadnego artykułu !!!!");
        }else{
            for (int n = 0; articles.size() > n; n++) {
                System.out.println("-----------------------------------------------------------------------------------");
                shipingCostOneProduct = shipingCostInZl / articles.get(n).getNumber();
                totalCost = BigDecimal.valueOf(articles.get(n).getCost()).multiply((BigDecimal.valueOf(dolarCost)))
                        .add(BigDecimal.valueOf(shipingCostOneProduct));
                totalCost = totalCost.add(totalCost.multiply(BigDecimal.valueOf(tax / 100)));
                System.out.printf((n + 1) + ". Nazwa towaru: " + articles.get(n).getName() + ", ilość sztuk : "
                        + articles.get(n).getNumber() + ", cena netto za 1 szt: %2.2f zł", totalCost);
                System.out.println();
            }
        }
    }

    public List<Articles> addArticles() {
        // List<Articles> articles = new ArrayList<>();
        do {
            System.out.println("Podaj nazwe: ");
            name = sc.nextLine();
            System.out.println("Podaj ilość: ");
            number = sc.nextInt();
            System.out.println("Podaj cene w $: ");
            cost = sc.nextDouble();
            articles.add(new Articles(name, number, cost));
            sc.nextLine();
            System.out.println("wprowadzmy jeszcze t/n");
            dec = sc.nextLine();
        } while ((!dec.equals("n")));

        return articles;
    }

    public void showList(List<Articles> articles) {

        if (articles.isEmpty()) {

            System.out.println("Nie dodałeś jeszcze artykułów !!!!");

        } else {
            for (Articles a : articles) {
                i++;
                System.out.println(i + ", Nazwa: " + a.getName() + ", Ilosc szt: " + a.getNumber() +
                        ", Cena za 1 szt.: " + a.getCost() + " $");
            }
            i = 0;
        }
    }


    public List<Articles> getArticles() {
        return articles;
    }
}
