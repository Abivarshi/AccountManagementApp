/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.jframe.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author acer
 */
public class DynamicColumnDataSource extends JRAbstractBeanDataSource {

    private List<String> columnHeaders;
    private List<List<String>> rows;
    private Iterator<List<String>> iterator;
    private List<String> currentRow;

    public DynamicColumnDataSource(List<String> columnHeaders, List<List<String>> rows) {
        super(true);
        this.rows = rows;
        this.columnHeaders = columnHeaders;
        if (this.rows != null && this.rows != null) {
            this.iterator = this.rows.iterator();
        }
    }

    @Override
    public boolean next() {
        boolean hasNext = false;
        if (iterator != null) {
            hasNext = iterator.hasNext();
            if (hasNext) {
                this.currentRow = iterator.next();
            }
        }
        return hasNext;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        // The name of the field in dynamic columns that were created by DynamicReportBulder is also the index into the list of columns.
        // For example, if the field is named 'col1', this is the second (because it's zero-based) column in the currentRow.
        String fieldName = field.getName();
        if (fieldName.startsWith(DynamicReportBuilder.COL_EXPR_PREFIX)) {
            String indexValue = fieldName.substring(DynamicReportBuilder.COL_EXPR_PREFIX.length());
            String column = currentRow.get(Integer.parseInt(indexValue));
            return column;
        } else if (fieldName.startsWith(DynamicReportBuilder.COL_HEADER_EXPR_PREFIX)) {
            int indexValue = Integer.parseInt(fieldName.substring(DynamicReportBuilder.COL_HEADER_EXPR_PREFIX.length()));
            String columnHeader = columnHeaders.get(indexValue);
            return columnHeader;
        } else {
            throw new RuntimeException("The field name '" + fieldName + "' in the Jasper Report is not valid");
        }
    }

    @Override
    public void moveFirst() {
        if (rows != null) {
            iterator = rows.iterator();
        }
    }
}
