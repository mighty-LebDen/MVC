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
  }
  
  @Override
  public ModelData getModelData() {
    return this.modelData;
  }
}
