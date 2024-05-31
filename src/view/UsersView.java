package view;

import bean.User;
import controller.Controller;
import model.ModelData;

import java.util.List;

public class UsersView implements View {
  private Controller controller;
  
  
  
  @Override
  public void refresh(ModelData modelData) {
    System.out.println("All users");
    List<User> users = modelData.getUsers();
    for(User user : users) {
      System.out.println(user + "\t");
    }
    System.out.println("===================================================");
  }
  
  @Override
  public void setController(Controller controller) {
    this.controller = controller;
  
  }
  public void fireEventShowAllUsers() {
    controller.onShowAllUsers();
  }
  
  public void fireEventShowDeletedUsers() {
    controller.onShowAllDeletedUsers();
  }
}
