package com.bijay.expensetracker.filters;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bijay.expensetracker.Constants;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

// for intercept the requests.
// apply this to all the urls
public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        type-casting these servlet request/response objects to httpservlet request/response objects.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("******* JWT Validation Started *******");

//        getting requests data from header
        String authHeader = httpRequest.getHeader("Authorization");
        System.out.println("authHeader = " + authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            // its just a convention to split authHeader using String "Bearer"
            String[] authHeaderArr = authHeader.split("Bearer");
            if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
                String token = authHeaderArr[1];
                try {
                    Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token).getBody();

                    claims.getExpiration().before(new Date());
                    httpRequest.setAttribute("userId", Integer.parseInt(claims.get("userId").toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid/expired token");
                    return;
                }
            } else {
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer [token]");
                return;
            }
        } else {
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Provided.");
            return;
        }
        chain.doFilter(request, response);
    }

    public boolean checkUserValidity(Claims claims) {
        return true;
    }

}
