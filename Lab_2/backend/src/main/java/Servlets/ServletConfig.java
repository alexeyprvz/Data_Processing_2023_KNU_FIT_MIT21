package Servlets;

import Crud.CrudFile;
import Crud.CrudInterface;

public class ServletConfig implements ServletConfigInterface{
    public void setCrudInt(CrudInterface crudInt) {
        this.crudInt = crudInt;
    }

    CrudInterface crudInt;

    public ServletConfig(){
        this.crudInt = new CrudFile();
    }
    @Override
    public CrudInterface getCrud() {
        return crudInt;
    }
}
