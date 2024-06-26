package controller;

import model.Model;
import view.EditUserView;
import view.UsersView;

public class Controller {
  private Model model;
  private UsersView usersView;
  private EditUserView editUserView;
  
  public void setModel(Model model) {
    this.model = model;
  }
  
  public void onShowAllUsers() {
    model.loadUsers();
    this.refreshView();
  }
  public void refreshView() {
    usersView.refresh(this.model.getModelData());
  }
  
  public void refreshEditView() {
    editUserView.refresh(this.model.getModelData());
  }
  
  public void refreshDelete() {
    editUserView.refreshDeleted(this.model.getModelData());
  }
  
  public void setUsersView(UsersView usersView) {
    this.usersView = usersView;
  }
  
  public void setEditUserView(EditUserView editUserView) {
    this.editUserView = editUserView;
  }
  
  public void onShowAllDeletedUsers() {
    model.loadDeletedUsers();
    this.refreshView();
  }
  
  public void onOpenUserEditForm(long userId) {
    model.loadUserById(userId);
    this.refreshEditView();
  }
  
  public void onUserDelete(long userId) {
    model.deleteUserById(userId);
    this.refreshView();
  }
  
  public void onUserChange(String name, long id, int level) {
    model.changeUserData(name, id, level);
    this.refreshView();
  }
}
