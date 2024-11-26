public class Main {
    public static void main(String[] args) {

        AdaptiveList list1 = AdaptiveList.singletonList(5);
        System.out.println("Test 1: " + list1.containsTopPriority(5));
        System.out.println("List 1: " + listToString(list1));

        AdaptiveList list2 = new AdaptiveList(1, new AdaptiveList(2, new AdaptiveList(3, null)));
        System.out.println("Test 2: " + list2.containsTopPriority(4));
        System.out.println("List 2: " + listToString(list2));

        AdaptiveList list3 = new AdaptiveList(1, new AdaptiveList(2, new AdaptiveList(3, null)));
        System.out.println("Test 3: " + list3.containsTopPriority(2));
        System.out.println("List 3: " + listToString(list3));

        AdaptiveList list4 = new AdaptiveList(1, new AdaptiveList(2, new AdaptiveList(3, null)));
        System.out.println("Test 4: " + list4.containsTopPriority(3));
        System.out.println("List 4: " + listToString(list4));

        AdaptiveList list5 = new AdaptiveList(1, new AdaptiveList(2, new AdaptiveList(3, null)));
        System.out.println("Test 5: " + list5.containsTopPriority(1));
        System.out.println("List 5: " + listToString(list5));

        list1.append(6);
        System.out.println("Test 6: append 6: " + listToString(list1));

        list1.prepend(4);
        System.out.println("Test 7: prepend 4: " + listToString(list1));
    }

    private static String listToString(AdaptiveList list) {
        StringBuilder sb = new StringBuilder();
        AdaptiveList current = list;
        sb.append("[");
        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}