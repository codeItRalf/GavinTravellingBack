package com.gavintravelling.app.rest;


import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.entity.RoomType;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.repository.BookedRoomRepository;
import com.gavintravelling.app.repository.RoomRepository;
import com.gavintravelling.app.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rest")
public class SearchController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;


    @GetMapping("/city={cityId}&startdate={startDate}&enddate={endDate}")
    public List<Room> getRoomTypesByHotel(@PathVariable long cityId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")
                                           Date endDate){


        var rooms = (List<Room>) roomRepository.getAllByRoomType_Hotel_City_Id(cityId);
        var bookedRoomsId = (List<Long>) bookedRoomRepository.getBookedRoomWithinDate(startDate,endDate);
        int bookedRoomSize = bookedRoomsId.size();
        return rooms.stream().filter(room -> !bookedRoomsId.contains(room.getId())).collect(Collectors.toList());

    }


}
