package com.yingjia.api.controller;

import com.yingjia.api.entity.User;
import com.yingjia.api.response.LoginResponse;
import com.yingjia.api.service.HttpService;
import com.yingjia.api.service.PersistentService;
import com.yingjia.api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Optional;

@Controller
@RequestMapping(path="/wx")
public class wxController {

    private PersistentService p;
    private HttpService h;
    private UserService u;

    @Autowired
    void userController(PersistentService persistentService, HttpService httpService, UserService userService) {
        this.p = persistentService;
        this.h = httpService;
        this.u = userService;
    }

    @PostMapping("/login-by-wx")
    public ResponseEntity<?> login(@RequestBody String code) {
        //String response = h.login(code);
        //return response == null? h.errorLogin(): response;
        String token = u.login(code);
        return ResponseEntity.ok(new LoginResponse(token));
    }
    @PostMapping("/add")
    public @ResponseBody int add(@RequestParam String userId,
                                 @RequestParam String userName,
                                 @RequestParam String sex) {
        User user = new User(userId);
        user.setUserName(userName).setSex(sex);
        return p.saveUser(user);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return p.getRepo().findAll();
    }
    @GetMapping(path="/find")
    public @ResponseBody Optional<User> getOneUser(@RequestParam int userId) {
        // This returns a JSON or XML with the users
        var result = p.getRepo().findById(Integer.valueOf(userId));
        return result;
    }
    PrintStream fileOut;
    @RequestMapping(value = "/**")
    public ResponseEntity<String> handleUnmatchedRequests(HttpServletRequest request) {


        try {
            if(fileOut==null){
                File logFile = new File("/var/logs/unmatched_requests.log");
                fileOut = new PrintStream(new FileOutputStream(logFile, true)); // Append mode
                System.setOut(fileOut); // Redirect System.out to the file
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the error if file creation fails
        }

        if(fileOut!=null){
            System.setOut(fileOut);
        }

        // Log the unmatched request details
        System.out.printf("Unmatched Request - URL: {%s}, Method: {%s}", request.getRequestURI(), request.getMethod());

        System.out.println(request.toString());

        Enumeration<String> parameterNames = request.getParameterNames();

        if (!parameterNames.hasMoreElements()) {
            System.out.println("Request Parameters: None");
        } else {
            System.out.println("Request Parameters:");
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName); // Gets the parameter value
                System.out.printf("  %s: %s%n", paramName, paramValue);
            }
        }
        StringBuilder body = new StringBuilder();

        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line).append("\n"); // Read the body line by line
            }
        } catch (IOException e) {
            System.err.println("Failed to read request body: " + e.getMessage());
        }

        if (body.length() == 0) {
            System.out.println("Request Body: None");
        } else {
            System.out.println("Request Body:");
            System.out.println(body.toString());
        }

        // Return custom response for unmatched requests
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No handler found for this request.");
    }

}
