import controller.Controller;
import model.MainModel;
import model.Model;
import view.UsersView;

public class Main {
  public static void main(String[] args) {
    Model model = new MainModel();
    UsersView usersView = new UsersView();
    Controller controller = new Controller();
    
    usersView.setController(controller);
    controller.setModel(model);
    controller.setUsersView(usersView);
    usersView.fireEventShowAllUsers();
  }
}