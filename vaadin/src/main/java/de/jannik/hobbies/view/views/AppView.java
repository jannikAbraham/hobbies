package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.view.views.abstracts.VaadinPage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@UIScope
@SpringComponent
@Route("")
@PageTitle("Test-view")
public class AppView extends AppLayout
{
  @Autowired
  private List<VaadinPage> pages = new ArrayList<>();

  public AppView()
  {

  }

  @PostConstruct
  private void init()
  {
    List<Button> buttonList = new ArrayList<>();
    VerticalLayout hl1 = new VerticalLayout();

    for (VaadinPage page : pages)
    {
      Button pageButton = new Button(page.getButtonText());
      pageButton.setIcon(page.getIcon());
      pageButton.addClickListener(e -> {
        //look at main view
        UI.getCurrent().navigate(page.getButtonText());
      });
      hl1.add(pageButton);
      buttonList.add(pageButton);
    }
    addToDrawer(hl1);
    //clicking the button from code
    buttonList.get(0).getElement().callJsFunction("click");
  }
}

