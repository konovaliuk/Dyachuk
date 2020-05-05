package dachuk.snow;

import dachuk.snow.model.Route;
import dachuk.snow.model.Transport;
import dachuk.snow.model.User;
import dachuk.snow.service.RouteService;
import dachuk.snow.service.TransportService;
import dachuk.snow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/drivers/")
public class DriverController {
    private final UserService userService;
    private final RouteService routeService;
    private final TransportService transportService;


    @Autowired
    public DriverController(UserService userService, RouteService routeService, TransportService transportService) {
        this.userService = userService;

        this.routeService = routeService;
        this.transportService = transportService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody User user) {
        Map<Object, Object> response = new HashMap<>();
        User registerUser = userService.login(user);

        if(registerUser!= null){
            return new ResponseEntity<>(registerUser, HttpStatus.OK);
        }
        response.put("message", "Incorrect username or password");
        return ResponseEntity.ok(response);
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody User user){
        Map<Object, Object> response = new HashMap<>();

        User registerUser = userService.registration(user);

        if(registerUser!= null){
            return new ResponseEntity<>(registerUser, HttpStatus.OK);
        }
        response.put("message", "Not Available Username");
        return ResponseEntity.ok(response);
    }

    @PostMapping("approveRoute")
    public ResponseEntity approveRoute(@RequestBody User user){

        Map<Object, Object> response = new HashMap<>();

        User approveUserRoute = userService.approveStatus(user);

        if(approveUserRoute!= null){
            return new ResponseEntity<>(approveUserRoute, HttpStatus.OK);
        }
        response.put("message", "some Wrong");
        return ResponseEntity.ok(response);
    }

    @PostMapping("findMYRoute")
    public ResponseEntity findMyRoute(@RequestBody User user){
        Map<Object, Object> response = new HashMap<>();

        User findUser = userService.findById(user.getId());

        Route findRoute = routeService.findByDriverId(findUser.getId());
        response.put("Route", findRoute);

        Transport findTransport = transportService.findByRouteId(findRoute.getId());
        response.put("Transport", findTransport);

        return ResponseEntity.ok(response);

    }
}
