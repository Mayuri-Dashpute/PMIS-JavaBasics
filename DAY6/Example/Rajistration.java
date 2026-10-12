package DAY6.Example;

 class UserAccount {
    private String username;
    private static int totalUsers =0;

   public UserAccount(String username){
    this.username=username;
    totalUsers++;
   }

   public String getusername(){
    return username;
   }

   public static int gettotalUsers(){
    return totalUsers;
   }
    
}
