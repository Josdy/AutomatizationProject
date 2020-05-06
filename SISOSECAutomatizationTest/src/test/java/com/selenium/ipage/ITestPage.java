package com.selenium.ipage;

public interface ITestPage<T>
{

  public void create(T entitie);

  public void fix(T entitie);

  public void edit(T entitie);

  public void delete(T entitie);

}
