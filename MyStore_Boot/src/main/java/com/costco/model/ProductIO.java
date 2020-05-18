package com.costco.model;

import java.io.*;
import java.util.*;

public class ProductIO {

    public static Product getProduct(String code, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String productCode = t.nextToken();
                if (code.equalsIgnoreCase(productCode)) {
                	String category = t.nextToken();
                	String img = t.nextToken();
                	String name = t.nextToken();
                	int inventory = Integer.parseInt(t.nextToken());
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    Product p = new Product(productCode, name, description, inventory, price, category, img);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String productCode = t.nextToken();
            	String category = t.nextToken();
            	String img = t.nextToken();
            	String name = t.nextToken();
            	int inventory = Integer.parseInt(t.nextToken());
                String description = t.nextToken();
                double price = Double.parseDouble(t.nextToken());
                
                Product p = new Product(productCode, name, description, inventory, price, category, img);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
}