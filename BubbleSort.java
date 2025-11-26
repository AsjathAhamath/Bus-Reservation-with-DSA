import java.util.List;

public class BubbleSort {
    public static void bubblesort(List <Customer> customers){
        int n =customers.size();
        for(int m = 0;m<n-1;m++){
            for(int e=0;e<n -1;e++){
                if(customers.get(e).getCustomerAge()> customers.get(e+1).getCustomerAge()){
                    //swap customer[j] with customers [j+1]
                    Customer Cus = customers.get(e);
                    customers.set(e, customers.get(e));
                    customers.set(e+ 1,Cus);
                }
            }
        }
    }
}