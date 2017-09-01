package com.diankangwo.util;

import javax.servlet.http.HttpServletRequest;

/**
 * The Interface of CustomEditor. translate Object to String according to
 * special rule,when user add not basic object to page navigator as parameter.
 * 
 */
public interface ICustomEditor {

    /**
     * translate Object to String according to special rule.
     * 
     * @param request
     *            ...
     * @param value
     *            which will translated by user customEditor.
     * @return String
     */
    String parse(HttpServletRequest request, Object value);
}
