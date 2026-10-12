package DAY6.Example;

public class app {
    public static void main(String[] args) {
        System.out.println("initial user count"+ UserAccount.gettotalUsers());
        UserAccount user1 = new UserAccount("mayuri");
         UserAccount user2 = new UserAccount("mayur");
          UserAccount user3 = new UserAccount("mayu");

          System.out.println("created " + user1.getusername());
          System.out.println("created " + user2.getusername());
          System.out.println("created " + user3.getusername());
          System.out.println("total users registered" +UserAccount.gettotalUsers());
    }
    
}
