//package com.demo.springmvc.controller.propertyeditor;
//
//import org.springframework.beans.PropertyEditorRegistrar;
//import org.springframework.beans.PropertyEditorRegistry;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// *
// * <p>Title: CustomPropertyEditor</p>
// * <p>Description:自定义属性编辑器 </p>
// */
//public class CustomPropertyEditor implements PropertyEditorRegistrar {
//
//	public void registerCustomEditors(PropertyEditorRegistry binder) {
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//
//	}
//
//}
