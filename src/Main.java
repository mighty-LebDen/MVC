import controller.Controller;
import model.MainModel;
import model.Model;
import view.EditUserView;
import view.UsersView;

public class Main {
  public static void main(String[] args) {
    Model model = new MainModel();
    UsersView usersView = new UsersView();
    Controller controller = new Controller();
    EditUserView editUserView = new EditUserView();
    
    usersView.setController(controller);
    editUserView.setController(controller);
    controller.setModel(model);
    controller.setUsersView(usersView);
    controller.setEditUserView(editUserView);
    
    usersView.fireEventShowAllUsers();
    usersView.fireEventOpenUserEditForm(126L);
    editUserView.fireEventUserDeleted(124L);
    usersView.fireEventShowDeletedUsers();
    editUserView.fireEventUserChanged("Lebedev", 126L, 99);
    usersView.fireEventShowAllUsers();
    usersView.fireEventShowAllUsers();
    
    
  }
}