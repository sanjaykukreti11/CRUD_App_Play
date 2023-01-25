package models;

import java.util.HashSet;
import java.util.Set;

public class Users {

    public Integer id;
    public String first_name;
    public String last_name;
    public Integer age;
    public Integer phone;

   public Users(){}


    public  Users(Integer id,String first_name,String last_name,Integer age,Integer phone){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.phone = phone;
    }

    private static Set<Users> users_list;

    static {
        users_list = new HashSet<>();
        users_list.add(new Users(1, "Sanjay", "Kukreti", 21 , 981111));
        users_list.add(new Users(2, "Rohan", "Kumar", 22 , 983331111));
        users_list.add(new Users(3, "Rohit", "Saxena", 32 , 99981111));
    }


    public static Set<Users> allUsers(){
        System.out.println("size of list" + users_list.size());
        return users_list;
    }


    public static Users findById(Integer id){
        for(Users user : users_list){
            if(user.id.equals(id)){
                return user;
            }
        }
        return null;
    }


    public static void add(Users user){
        users_list.add(user);
    }


    public static boolean remove(Users user){
        return users_list.remove(user);
    }



}
