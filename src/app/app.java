package app;

import java.util.Scanner;

public class app {

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;
    static Scanner sc;


    public static void main(String[] args) {
        sc();
        showData(processData());
    }

    

   private static void sc(){
        sc = new Scanner(System.in);
        System.out.println("Введите свое имя");
        merchantName = sc.nextLine();
        System.out.println("Введите свою эл.почту");
        email = sc.nextLine();
        System.out.println("Введите свой номер");
        phone = sc.nextLine();
        System.out.println("Введите имя товара");
        productName = sc.nextLine();
        System.out.println("Введите количество товара");
        quantity = sc.nextInt();
        System.out.println("Введите стоимость товара");
        price = sc.nextDouble();
    }

    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    private static void showData(String output) {
        System.out.println(output);
    }
}
