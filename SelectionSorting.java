import java.util.List;

/**
 * SelectionSorting
 */
public class SelectionSorting {

    public static void selectionSorting(List<Customer> customers) {
        int n = customers.size();// n = get the customer counts
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (customers.get(j).getCustomerAge() < customers.get(minIndex).getCustomerAge()) {
                    minIndex = j;
                }
            }
            // swap customers[minIndex] with customers[i]
            Customer temp = customers.get(minIndex);
            customers.set(minIndex, customers.get(i));
            customers.set(i, temp);
        }

    }
}