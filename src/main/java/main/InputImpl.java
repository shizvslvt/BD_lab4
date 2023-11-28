package main;

import java.util.Scanner;

public class InputImpl implements Input {
    @Override
    public Estate InputEstate() {
            Scanner scanner = new Scanner(System.in);
            Estate estate = new Estate();
            System.out.print("Enter Seller ID:");
            estate.setSellerId(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter Title: ");
            estate.setTitle(scanner.nextLine());
            System.out.print("Enter Cost:");
            estate.setCost(scanner.nextInt());
            System.out.print("Enter Type:");
            estate.setType(scanner.nextInt());
            System.out.print("Enter Locality:");
            estate.setLocality(scanner.nextInt());
            System.out.print("Enter City:");
            estate.setCity(scanner.nextInt());
            System.out.print("Enter Area:");
            estate.setArea(scanner.nextInt());
            System.out.print("Enter Bedrooms:");
            estate.setBedrooms(scanner.nextInt());
            System.out.print("Enter Floors:");
            estate.setFloors(scanner.nextInt());
            System.out.print("Enter Date Created (YYYY-MM-DD):");
            String dateString = scanner.next();
            estate.setDateCreated(java.sql.Date.valueOf(dateString));
            System.out.print("Enter Viewed:");
            estate.setViewed(scanner.nextInt());
            System.out.print("Enter Deal:");
            estate.setDeal(scanner.nextInt());
            System.out.print("Enter Archived:");
            estate.setArchived(scanner.nextInt());
            return estate;
    }
}
