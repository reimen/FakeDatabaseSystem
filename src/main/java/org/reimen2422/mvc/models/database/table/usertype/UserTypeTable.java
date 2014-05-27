package org.reimen2422.mvc.models.database.table.usertype;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.SchemaModelInterface$;
import org.reimen2422.mvc.models.database.table.Table;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserType;

import java.util.ArrayList;
import java.util.List;

public abstract class UserTypeTable<T extends UserType> extends Table<T> {

    public UserTypeTable(Database database, SchemaModelInterface$<T> schemaModelInterface$) {
        super(database, schemaModelInterface$);
    }

    public List<T> selectByName(String name) {
        List<T> userTypeList = selectAll();
        List<T> resultList = new ArrayList<T>();
        for (T userType : userTypeList) {
            if(name.equals(userType.getName())) {
                resultList.add(userType);
            }
        }

        return resultList;
    }

    public int deleteByName(String name) {
        List<T> targetList = selectByName(name);
        if(targetList.size() == 0) return 0;

        for(T userType : targetList) {
            if(userType.getName().equals(name)) {
                deleteById(userType.getId());
            }
        }
        return targetList.size();
    }
}
