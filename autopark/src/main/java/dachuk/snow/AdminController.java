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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin/")
public class AdminController {

    private final UserService userService;
    private final RouteService routeService;
    private final TransportService transportService;


    @Autowired
    public AdminController(UserService userService, RouteService routeService, TransportService transportService) {
        this.userService = userService;

        this.routeService = routeService;
        this.transportService = transportService;
    }

    @PostMapping("createRoute")
    public ResponseEntity createRoute(@RequestBody Route route){
        Map<Object, Object> response = new HashMap<>();

        Route route1 = routeService.create(route);

        if(route1!= null){
            return new ResponseEntity<>(route1, HttpStatus.OK);
        }

        response.put("message", "Some wrong");
        return ResponseEntity.ok(response);
    }

    @PostMapping("findRouteId")
    public ResponseEntity findRouteById(@RequestParam int id){
        return new ResponseEntity<>(routeService.findById(id), HttpStatus.OK);
    }

    @PostMapping("findAllRoute")
    public ResponseEntity findAllRoute(){
        return new ResponseEntity<>(routeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("updateRoute")
    public ResponseEntity updateRoute(@RequestBody Route route){
        Map<Object, Object> response = new HashMap<>();

        Route route1 = routeService.update(route);

        if(route1!= null){
            return new ResponseEntity<>(route1, HttpStatus.OK);
        }

        response.put("message", "Some wrong");
        return ResponseEntity.ok(response);
    }

    @PostMapping("createTransport")
    public ResponseEntity createTransport(@RequestBody Transport transport){
        Map<Object, Object> response = new HashMap<>();

        Transport transport1 = transportService.create(transport);

        if(transport1!= null){
            return new ResponseEntity<>(transport1, HttpStatus.OK);
        }

        response.put("message", "Some wrong");
        return ResponseEntity.ok(response);
    }


    @PostMapping("findTransportId")
    public ResponseEntity findTransportById(@RequestParam int id){
        return new ResponseEntity<>(transportService.findById(id), HttpStatus.OK);
    }

    @PostMapping("findAllTransport")
    public ResponseEntity findAllTransport(){
        return new ResponseEntity<>(transportService.findAll(), HttpStatus.OK);
    }


    @PostMapping("updatetransport")
    public ResponseEntity updateTransport(@RequestBody Transport transport){
        Map<Object, Object> response = new HashMap<>();

        Transport transport1 = transportService.update(transport);

        if(transport1!= null){
            return new ResponseEntity<>(transport1, HttpStatus.OK);
        }

        response.put("message", "Some wrong");
        return ResponseEntity.ok(response);
    }

    @PostMapping("updateDriver")
    public ResponseEntity updateDriver(@RequestBody User driver){

        Map<Object, Object> response = new HashMap<>();

        User user = userService.update(driver);

        if(user!= null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        response.put("message", "Some wrong");
        return ResponseEntity.ok(response);
    }

    @PostMapping("findAllUsers")
    public ResponseEntity findAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

}
