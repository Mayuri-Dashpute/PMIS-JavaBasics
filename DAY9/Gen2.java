package DAY9;

class Pair<K,V> {
  private K Key;
  private V value;
Pair(K key, V value)  {
    this.Key =key;
    this.value = value;
  }
  K getkey(){
    return Key;
  }
  V getValue(){
    return value;
  }
}

public class   Gen2{
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("Age", 25);
        String k = p.getkey();
        Integer v = p.getValue();
        System.out.println(k+ ":" +v);
    }
}