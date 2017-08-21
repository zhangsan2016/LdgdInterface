package aninterface.ldgd.com.recyclerview.model;

import java.util.Date;

/**
 * Created by ldgd on 2017/8/18.
 */

public class DataModel {

    private String mLabel;
    private Date mDateTime;

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public Date getDateTime() {
        return mDateTime;
    }

    public void setDateTime(Date dateTime) {
        mDateTime = dateTime;
    }
}
