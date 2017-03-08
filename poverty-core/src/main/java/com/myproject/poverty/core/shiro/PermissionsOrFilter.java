package com.myproject.poverty.core.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PermissionsOrFilter extends AuthorizationFilter {

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request,response);
        String[] permissionsArray = (String[])mappedValue;

        if(permissionsArray == null|| permissionsArray.length== 0) {
            //no permissions specified, so nothing to check - allow access.
            return true;

        }

        for(String permission : permissionsArray) {
	        if(subject.isPermitted(permission)) {
	            return true;
	        }
        }

        return false;
    }

}