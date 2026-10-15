package DAY9;

 class Locker<T> {
    private T item;
    void put(T item){
        this.item = item;
    }

    T get(){
        return  item;
    }

    class gen{
        public static void main(String[] args) {
            Locker<String> l1 = new Locker<>();
            l1.put("c++ book");
            System.out.println("The locker has: "+ l1.get());
            Locker<Integer> intloc = new Locker<>();
            intloc.put(1234);
            intloc.put(9868);
            System.out.println("Loker has:"+ intloc);
            
        }
    }
}
