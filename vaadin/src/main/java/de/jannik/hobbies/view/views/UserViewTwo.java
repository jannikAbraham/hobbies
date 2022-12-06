//package de.jannik.hobbies.view.views;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.combobox.ComboBox;
//import com.vaadin.flow.component.datepicker.DatePicker;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.html.Label;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.textfield.EmailField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.spring.annotation.SpringComponent;
//import com.vaadin.flow.spring.annotation.UIScope;
//import de.jannik.hobbies.model.entity.Country;
//import de.jannik.hobbies.model.entity.User;
//import de.jannik.hobbies.model.enums.Gender;
//import de.jannik.hobbies.service.CountryService;
//import de.jannik.hobbies.service.UserService;
//import de.jannik.hobbies.view.abstracts.EntityDialog;
//import de.jannik.hobbies.view.abstracts.VaadinCrud;
//import de.jannik.hobbies.view.abstracts.VaadinPage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringComponent
//@UIScope
//@PageTitle("User View")
//@Route(value = "User", layout = AppView.class)
//public class UserViewTwo extends VaadinCrud<User> implements VaadinPage
//{
//  //toDo handle EntityDialog
//
//  private final Grid<User> userGrid;
//  private final UserService userService;
//  private final CountryService countryService;
//
//  private EntityDialog<User> entityDialog;
//
//  public UserViewTwo(UserService userService, CountryService countryService)
//  {
//    super(userService);
//    this.userService = userService;
//    this.countryService = countryService;
//
//    userGrid = new Grid<>(User.class, false);
//    userGrid.addColumn(User::getName).setHeader("Name");
//    userGrid.addColumn(User::geteMail).setHeader("E-Mail");
//    userGrid.addColumn(User::getGender).setHeader("Gender");
//    userGrid.addColumn(User::getBirthday).setHeader("Birthday");
//    userGrid.addColumn(User::getCountry).setHeader("Country");
//
//    userGrid.setItems(userService.findAll());
//
//    setGrid(userGrid);
//
//    handleEntityDialog();
//  }
//
//  private void handleEntityDialog()
//  {
//    entityDialog = new EntityDialog<User>(new User(), userService, User.class)
//    {
//      @Override
//      protected List<Component> getComponentFields(Binder<User> binder)
//      {
//        // Declaring user fields components
//        TextField name = new TextField("Name");
//        Label nameStatus = new Label();
//
//        EmailField eMail = new EmailField("E-Mail");
//        DatePicker birthday = new DatePicker("Birthday");
//
//        ComboBox<Gender> gender = new ComboBox<>("Gender");
//        gender.setItems(Gender.values());
//
//        ComboBox<Country> country = new ComboBox<>("Country");
//        country.setItems(countryService.findAll());
//        country.setItemLabelGenerator(Country::getCode);
//
//        // Binding and validating component fields with user fields
//        //ToDo validate this when clicking the Save button currently he is validating already when clicking the add button
//        binder.forField(name).withValidator(n -> n.length() >= 3 ,"Name cant be empty")
//            .bind(User::getName, User::setName);
//        binder.forField(eMail).withValidator(n -> !n.isEmpty() ,"Please enter an e mail")
//            .bind(User::geteMail, User::seteMail);
//        binder.forField(birthday).withValidator(n -> n.toString().isBlank() , "Date cant be empty")
//            .bind(User::getBirthday, User::setBirthday);
//        binder.forField(gender).withValidator(n -> n.toString().isBlank() ,"Please select something")
//            .bind(User::getGender, User::setGender);
//        binder.forField(country).withValidator(n -> n.toString().isBlank() ,"Please select something")
//            .bind(User::getCountry, User::setCountry);
//
//        ArrayList<Component> fieldsComponents = new ArrayList<>();
//        fieldsComponents.add(name);
//        fieldsComponents.add(eMail);
//        fieldsComponents.add(birthday);
//        fieldsComponents.add(country);
//        fieldsComponents.add(gender);
//
//        return fieldsComponents;
//      }
//
//      // abstract this
//      @Override
//      public void entityWasSaved(User updatedEntity)
//      {
//        refreshData();
//      }
//    };
//    setEntityDialog(entityDialog);
//  }
//
//  private void createNewUser()
//  {
//    entityDialog.setEntity(new User());
//    entityDialog.open();
//  }
//
//  @Override
//  protected User createNewEntity()
//  {
//    return new User();
//  }
//
//  private void deleteUser()
//  {
//    userService.delete(userGrid.asSingleSelect().getValue());
//    refreshData();
//  }
//
//  private void updateUser()
//  {
//    entityDialog.setEntity(userGrid.asSingleSelect().getValue());
//    entityDialog.open();
//  }
//
//  private void refreshData()
//  {
//    userGrid.setItems(userService.findAll());
//  }
//
//
//
//  @Override
//  public String getButtonText()
//  {
//    return "User";
//  }
//
//  @Override
//  public Icon getIcon()
//  {
//    return VaadinIcon.USER.create();
//  }
//}
