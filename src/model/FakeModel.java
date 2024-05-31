package model;

import bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{
  private ModelData modelData = new ModelData();
  
  @Override
  public void loadUsers() {
    User user = new User("A", 1, 1);
    List<User> list = new ArrayList<>();
    list.add(user);
    user = new User("B", 2, 1);
    list.add(user);
    modelData.setUsers(list);
  }
  
  @Override
  public ModelData getModelData() {
    return this.modelData;
  }
}
