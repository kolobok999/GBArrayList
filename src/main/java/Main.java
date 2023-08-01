public class Main {
    public static void main(String[] args) {
        GBList<Integer> list = new GBArrayList<>();
        list.add(5);
        list.add(65);
        list.add(25);
        System.out.println(list);
        list.update(1, 5555);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("__________________________________");

        GBList<Integer> llList = new GBLinkedList<>();
        System.out.println("size: " + llList.size());
        llList.add(5);
        llList.add(43);
        llList.add(32);
        llList.add(76);
        System.out.println("size: " + llList.size());
        System.out.println(llList);
        System.out.println("get(3): " + llList.get(3));
        llList.update(2, 777);
        System.out.println("update(2, 777): " + llList);
        llList.remove(1);
        System.out.println("remove(1): " + llList);

        System.out.println("Проверка итератора:");
        for (int e : llList) {
            System.out.println(e);
        }
    }
}
