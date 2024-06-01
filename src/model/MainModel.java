package model;

import bean.User;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
  private UserService userService = new UserServiceImpl();
  private ModelData modelData = new ModelData();
  
  @Override
  public void loadUsers() {
      List<User> users =  userService.getUsersBetweenLevels(1, 100);
      modelData.setUsers(users);
      modelData.setUsers(this.getAllUsers());
      modelData.setDisplayDeletedUserList(false);
  }
  
  @Override
  public void deleteUserById(long id) {
    userService.deleteUser(id);
    List<User> users = this.getAllUsers();
    modelData.setUsers(users);
  }
  
  @Override
  public void loadDeletedUsers() {
    List<User> users = userService.getAllDeletedUsers();
    modelData.setUsers(users);
    modelData.setDisplayDeletedUserList(true);
    
  }
  
  public void loadUserById(long userId) {
    User user = userService.getUsersById(userId);
    List<User> list = new ArrayList<>();
    list.add(user);
    modelData.setUsers(list);
    modelData.setDisplayDeletedUserList(false);
    this.modelData.setActiveUser(user);
  }
  
  @Override
  public ModelData getModelData() {
    return this.modelData;
  }
  
  private List<User> getAllUsers() {
    List<User> users =  userService.getUsersBetweenLevels(1, 100);
    return userService.filterOnlyActiveUsers(users);
  }
}
