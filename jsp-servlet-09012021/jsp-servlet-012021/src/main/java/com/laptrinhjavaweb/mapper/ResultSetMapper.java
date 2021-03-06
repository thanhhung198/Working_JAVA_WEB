package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> {
	// Tra ve list<T>
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> results = new ArrayList<T>();
		try {
			if (zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();// ResultSetMetaData de get gtri trong Entity
				Field[] fields = zClass.getDeclaredFields(); // co tat ca field khi put BuildingEntity, nhung ko co
																// field trong class ma no extends(chi dung trong 1
																// class)
				// Chay vong lap de get tung field, get name cua field do
				while (rs.next()) {
					T object = zClass.newInstance(); // Tao Object cua T (convert lai tu Class), VD BuildingEntity
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) { // getColumnCount: chay tung column
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1); // Object: KDL chua xac dinh, do cho biet value tra ve
																	// gtri String hay int
						ColumnModel columnModel = new ColumnModel();
						columnModel.setColumnName(columnName);
						columnModel.setColumnValue(columnValue);
						convertResultSetToEntity(fields, columnModel, object);
						//convertResultSetToEntity(fields, columnName, columnValue, object);
						
						/*
						 * for (Field field : fields) { if (field.isAnnotationPresent(Column.class)) {
						 * Column column = field.getAnnotation(Column.class); if
						 * (column.name().equals(columnName) && columnValue != null) {
						 * BeanUtils.setProperty(object, field.getName(), columnValue); break; } } }
						 */

						Class<?> parentClass = zClass.getSuperclass(); // Ktra xem con class cha k

						while (parentClass != null) {
							Field[] fieldParent = parentClass.getDeclaredFields();
							//convertResultSetToEntity(fields, columnName, columnValue, object);
							convertResultSetToEntity(fieldParent, columnModel, object);
							parentClass = parentClass.getSuperclass();
						}
					}
					results.add(object);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Chá»‰ in ra trÃªn eclipse , netbean chá»© k in ra trÃªn server tháº­t
		}

		return results;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private void convertResultSetToEntity(Field[] fields, ColumnModel columnModel, Object... objects) {

		T object = (T) objects[0];
		// 1: columnName
		// 2: columValue
		// 3: T object
		try {
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.name().equals(columnModel.getColumnName()) && columnModel.getColumnValue() != null) {
						BeanUtils.setProperty(object, field.getName(), columnModel.getColumnValue());
						break;
					}
				}
			}
		} catch (InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
	}

	static class ColumnModel {
		String columnName;
		Object columnValue;

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public Object getColumnValue() {
			return columnValue;
		}

		public void setColumnValue(Object columnValue) {
			this.columnValue = columnValue;
		}
	}
}
