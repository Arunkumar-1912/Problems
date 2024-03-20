package org.example.Application;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product{
    private String name ;
    private int quantity;
    private double price;

    Product(String name , int quantity , double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
class Customer{
    private String name;
    private String address;

    Customer(String name , String address){
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
public class BillingApplication {
    private List<Product> products = new ArrayList<>();
    private Customer customer;

    public void setCustomer(Customer newCustomer) {
        customer = newCustomer;
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public static void main(String[] args){

        BillingApplication billingApplication = new BillingApplication();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Name of Custom : ");
        String customerName = scanner.nextLine();
        System.out.println("Enter the Customer Address : ");
        String customerAddress = scanner.nextLine();
        Customer customer = new Customer(customerName,customerAddress);
        billingApplication.setCustomer(customer);

        while (true){
            System.out.println("Enter the Product Name(type 'done' to finished) : ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("done")){
                break;
            }
            System.out.println("Enter the Quantity : ");
            int quantity = scanner.nextInt();

            System.out.println("Enter the Price : ");
            double price = scanner.nextDouble();

            scanner.nextLine();

            Product product = new Product(productName,quantity,price);
            billingApplication.addProduct(product);
        }
        billingApplication.billingDetail();
    }
    public  void billingDetail(){
        System.out.println("****************** Customer Detail ******************");
        System.out.println("Customer Name : "+ customer.getName());
        System.out.println("Customer Address : "+customer.getAddress());
        System.out.println("****************** Product Details *****************");
        System.out.println("Name \t\t\t Price \t\t\t Quantity \t\t\t Amount");
        System.out.println("----------------------------------------------------------------");
        long total = 0;
        for (Product product : products){
            System.out.println(product.getName()+"\t\t\t"+product.getPrice()+"\t\t\t"+product.getQuantity()+"\t\t\t"+product.getQuantity()*product.getPrice());

            total+=product.getQuantity()*product.getPrice();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total \t\t\t\t\t\t\t\t" + total);
        System.out.println("----------------------------------------------------------------");
    }
}
