package controllers;

import models.Users;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createForm;
import views.html.edtiForm;
import java.util.HashSet;
import java.util.Set;

import views.html.users;

import javax.inject.Inject;

public class UserController extends Controller {

    @Inject
    FormFactory formFactory;


    public Result  index(){

        Set<Users> user_list = Users.allUsers();

        return ok(users.render( user_list) );
    }

    public Result create(){

        Form<Users> usersForm = formFactory.form(Users.class);
        return ok(createForm.render(usersForm, "") ) ;

    }

    public Result save(){
        Form<Users> userForm = formFactory.form(Users.class).withDirectFieldAccess(true);
        Users userData = userForm.bindFromRequest().get();

        Users user = Users.findById(userData.id);
        if(user!=null){
            return ok(createForm.render(userForm , "User Id Already Exists"));
        }

        Users.add(userData);
        return redirect( routes.UserController.index());
    }

    public Result edit(Integer id){

        Users user = Users.findById(id);
        if(user==null){
            return notFound("User Not Found");
        }
        Users.remove(user);
        Form<Users> usersForm = formFactory.form(Users.class).withDirectFieldAccess(true).fill(user);

        return ok(edtiForm.render(usersForm , user ));


    }

    public Result update(){
        Form<Users> userForm = formFactory.form(Users.class).withDirectFieldAccess(true);
        Users userData = userForm.bindFromRequest().get();
        Users.add(userData);

        return redirect(routes.UserController.index());
    }

    public Result destroy(Integer id){
        Users user = Users.findById(id);
        Users.remove(user);
        return redirect(routes.UserController.index());
    }


    public Result show(Integer id){
        Set<Users> singleUser = new HashSet<>();
        Users user= Users.findById(id);
        singleUser.add(user);

        return ok(users.render(singleUser));
    }

}