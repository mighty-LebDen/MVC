package model;

import bean.User;

import java.util.List;

public class MainModel implements Model {
  UserService userService = new UserServiceImpl();
  private ModelData modelData = new ModelData();
  
  @Override
  public void loadUsers() {
      List<User> users =  userService.getUsersBetweenLevels(1, 100);
      modelData.setUsers(users);
      modelData.setDisplayDeletedUserList(false);
  }
  
  @Override
  public void loadDeletedUsers() {
    List<User> users = userService.getAllDeletedUsers();
    modelData.setUsers(users);
    modelData.setDisplayDeletedUserList(true);
    
  }
  
  @Override
  public ModelData getModelData() {
    return this.modelData;
  }
}
