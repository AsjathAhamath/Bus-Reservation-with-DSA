import java.util.List;

public class InsertionSorting {
    public static void insertionSorting(List<Customer> customers) {
        int n = customers.size();
        for (int m = 1; m < n; m++) {
            Customer key = customers.get(m);
            int e = m - 1;
            while (e >= 0 && customers.get(e).getCustomerAge() > key.getCustomerAge()) {
                customers.set(e + 1, customers.get(e));
                e--;
            }
            customers.set(e + 1, key);
        }
    }
}
