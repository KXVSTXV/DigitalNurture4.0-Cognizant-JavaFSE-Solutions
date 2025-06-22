import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Search
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int number, searchID, ch, key = -1;
        System.out.println("Enter number of items: ");
        number = sc.nextInt();

        //storing the products in a Product[] array
        Product[] array = new Product[number];
        for(int i=0; i<number; i++)
        {
            System.out.println("For Product "+(i+1)+" :-");
            System.out.print("Enter Product ID:  ");
            int id = sc.nextInt();
            sc.nextLine();      //consumes a new line
            System.out.print("Enter Product Name:  ");
            String name = sc.nextLine();
            System.out.print("Enter Product Category:  ");
            String category = sc.nextLine();
            Product p = new Product(id, name, category);
            array[i] = p;
        }

        //searching a product by Product ID
        System.out.print("Enter the Product ID of the product to be searched:  ");
        searchID = sc.nextInt();

        //choosing which algorithm to implement while searching --- an invalid option will prompt an user to choose again
        do
        {
            System.out.println("Enter choice of search algorithm --- \n1. Linear Search \n2. Binary Search");
            ch = sc.nextInt();
            switch(ch)
            {

                case 1:
                key = LinearSearch(array, searchID);    //use Linear Search for option 1
                break;

                case 2:

                //sorting the Product[] array for Binary Search (Quick Sort)
                Arrays.sort(array, new Comparator<Product>() {
                    public int compare(Product a, Product b) {
                        if (a.productId < b.productId)
                            return -1;
                        else if (a.productId > b.productId)
                            return 1;
                        else
                            return 0;
                    }
                });

                key = BinarySearch(array, searchID);    //use Binary Search for option 2
                break;
            }
        }
        while(ch != 1 && ch != 2);

        if(key != -1)   //if the product is found
        {
            System.out.println("Product "+ searchID +" found at index "+key);
        }
        else if(key == -1)  //if the product is not found
        {
            System.out.println("Product "+ searchID +"not found");
        }

        sc.close();
    }

    //Linear Search
    public static int LinearSearch(Product[] array, int searchID)
    {
        int flag = -1;
        for(int i=0; i<array.length; i++)
        {
            if(array[i].productId == searchID)  //prduct is found at index i
            {
                flag = i;
                break;
            }
        }

        return flag;    //returns the index or -1 (if not found)
    }

    //Binary Search
    public static int BinarySearch(Product[] array, int searchID)
    {
        int beg = 0, end = array.length - 1, flag = -1;

        while(beg <= end)
        {
            int mid = (beg + (end - beg))/2;

            if(array[mid].productId == searchID) //product is found at index mid
            {
                flag = mid;
                break;
            }
            else if(array[mid].productId > searchID)    //search in left half
            {
                end = mid - 1;
            }
            else if(array[mid].productId < searchID)    //search in right half
            {
                beg = mid + 1;
            }
        }

        return flag;    //returns the index or -1 (if not found)
    }
}