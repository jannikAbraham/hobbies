package de.jannik.hobbies.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringContext implements ApplicationContextAware
{
     
    private static ApplicationContext context;
    /**
     * Returns the Spring managed bean instance of the given class type if it exists.
     * Returns null otherwise.
     * @param beanClass
     * @return
     */
    public static <T extends Object> T getBean(Class<T> beanClass) {
      return context.getBean(beanClass);
    }

    /**
     * Creates a new Spring managed bean instance of the given class type passing any params to the constructor and returns it.
     * Requires the bean to be of prototype scope.
     * @param beanClass
     * @param params
     * @return
     */
    public static <T extends  Object> T getBean(Class<T> beanClass, Object... params)
    {
        return context.getBean(beanClass, params);
    }

    /**
     * gets a list of all beans implementing/extending baseClass
     * @param <T>     * @param beanClass
     * @return
     */
    public static <T extends Object> List<T> getBeans(Class<T> baseClass) {
        return new ArrayList<>(context.getBeansOfType(baseClass).values());
    }
    
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException
    {
        // store ApplicationContext reference to access required beans later on
        SpringContext.context = context;
    }
}