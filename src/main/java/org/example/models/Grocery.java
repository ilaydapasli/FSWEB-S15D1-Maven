package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

   public static ArrayList<String> groceryList = new ArrayList<>();

   public static void startGrocery() {
      Scanner scanner = new Scanner(System.in);
      int choice;

      do {
         System.out.println("\nPazar Listesi Uygulaması");
         System.out.println("0 - Çıkış");
         System.out.println("1 - Eleman Ekle");
         System.out.println("2 - Eleman Sil");
         System.out.print("Seçiminiz: ");
         choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
            case 0:
               System.out.println("Uygulama durduruluyor...");
               break;
            case 1:
               System.out.print("Eklemek istediğiniz elemanları giriniz (tek eleman veya virgüllerle ayrılmış): ");
               String addInput = scanner.nextLine();
               addItems(addInput);
               break;
            case 2:
               System.out.print("Çıkarmak istediğiniz elemanları giriniz (tek eleman veya virgüllerle ayrılmış): ");
               String removeInput = scanner.nextLine();
               removeItems(removeInput);
               break;
            default:
               System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
         }
         printSorted();

      } while (choice != 0);
   }

   public static void addItems(String input) {
      String[] items = input.split(",\\s*");
      for (String item : items) {
         if (!groceryList.contains(item.toLowerCase())) {
            groceryList.add(item.toLowerCase());
         }
      }
   }

   public static void removeItems(String input) {
      String[] items = input.split(",\\s*");
      for (String item : items) {
         if (groceryList.contains(item.toLowerCase())) {
            groceryList.remove(item.toLowerCase());
         } else {
            System.out.println(item + " listede bulunamadı!");
         }
      }
   }

   public static boolean checkItemIsInList(String product) {
      return groceryList.contains(product.toLowerCase());
   }

   public static void printSorted() {
      Collections.sort(groceryList);
      System.out.println("\nGüncel Pazar Listesi:");
      for (String item : groceryList) {
         System.out.println("- " + item);
      }
   }

   public static void main(String[] args) {
      startGrocery();
   }
}
