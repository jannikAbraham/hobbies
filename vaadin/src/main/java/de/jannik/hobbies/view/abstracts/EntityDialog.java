package de.jannik.hobbies.view.abstracts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import de.jannik.hobbies.service.EntityService;

import java.util.List;

public abstract class EntityDialog<T> extends Dialog
{
  private T entity;
  private final Binder<T> binder;
  private final EntityService<T> service;

  public EntityDialog(T entity, EntityService<T> service, Class<T> clazz)
  {
    // Declaring mandatory fields
    this.entity = entity;
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

  protected abstract List<Component> getComponentFields(Binder<T> binder);

  private void saveOrUpdate()
  {

    try
    {
      binder.writeBean(entity);
      if (binder.validate().isOk())
      {
        service.saveOrUpdate(entity);
        entityWasSaved(entity);
        close();
      }
    }
    catch (ValidationException e)
    {
      e.printStackTrace();
    }
  }

  public abstract void entityWasSaved(T updatedEntity);

  public void setEntity(T entity)
  {
    this.entity = entity;
    binder.setBean(entity);
  }
}
