package de.jannik.hobbies.view.views.abstracts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import de.jannik.hobbies.service.EntityService;

import java.util.List;

public abstract class EntityDialog<Entity> extends Dialog
{
  private Entity entity;
  private final Binder<Entity> binder;
  private final EntityService<Entity> service;

  public EntityDialog(EntityService<Entity> service, Class<Entity> clazz)
  {
    // Declaring mandatory fields
    this.service = service;
    binder = new BeanValidationBinder<>(clazz);
    binder.setBean(entity);

    // Init style
    setWidth("450px");

    // Declaring action buttons
    Button saveButton = new Button("Save", e -> saveOrUpdate());
    Button cancelButton = new Button("Cancel", e -> close());

    // Preparing container
    HorizontalLayout fieldContainers = new HorizontalLayout();
    fieldContainers.getStyle().set("flex-wrap", "wrap").set("gap", "12px");

    // get component fields
    List<Component> componentFields = getComponentFields(binder);
    for (Component component : componentFields)
      fieldContainers.add(component);

    // Add to the layout
    add(fieldContainers);
    getFooter().add(saveButton, cancelButton);
  }

  protected abstract List<Component> getComponentFields(Binder<Entity> binder);

  private void saveOrUpdate()
  {
    if (binder.validate().isOk())
    {
      service.saveOrUpdate(entity);
      entityWasSaved(entity);
      close();
    }
  }

  public abstract void entityWasSaved(Entity updatedEntity);

  public void setEntity(Entity entity)
  {
    this.entity = entity;
    binder.setBean(entity);
  }

  public abstract Entity getNewEntity();
}
