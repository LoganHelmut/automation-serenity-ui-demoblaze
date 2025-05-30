package demoblaze.ui.serenity.automation.utils;

import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataModel {
    private final Map<String, String> dynamicVariables = new HashMap<>();

    // set dynamic values
    public static DataModel setData(DataTable dataTable) {
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        Map<String, String> data = mapInfo.get(0);

        DataModel dataModel = new DataModel();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            dataModel.setDynamicVariable(entry.getKey(), entry.getValue());
        }
        return dataModel;
    }

    // get dynamic variable
    public String getDynamicVariable(String key) {
        return this.dynamicVariables.get(key);
    }

    // set dynamic variable
    public void setDynamicVariable(String key, String value) {
        this.dynamicVariables.put(key, value);
    }
}
