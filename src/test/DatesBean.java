/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grouping;

import java.util.Date;

/**
 *
 * @author cultuzz
 */
public class DatesBean {
    
    private Date fromDate;
    private Date toDate;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "DatesBean{" + "fromDate=" + fromDate + ", toDate=" + toDate + '}';
    }
    
    
}
