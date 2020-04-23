package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.modelDto.HotelForm;
import com.gavintravelling.app.repository.BookedRoomRepository;
import com.gavintravelling.app.repository.HotelRepository;
import com.gavintravelling.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rest/")
public class HotelFormController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private HotelRepository hotelRepository;


    @PostMapping(value = "filterHotel")
public List<Hotel> filter(@Valid @ModelAttribute("hotelForm")HotelForm hotelForm,
                          BindingResult result){
    if(result.hasErrors()){
        return new ArrayList<>();
    }
    List<Hotel> hotelResult = new ArrayList<>();
    var hotels = hotelRepository.getHotelsByDistanceToBeachIsLessThanEqualAndDistanceToCenterIsLessThanEqualAndCity_Name(
            hotelForm.getDistBeach(),hotelForm.getDistCenter(),hotelForm.getCityName()).stream().filter(hotel -> {
        if(hotelForm.isHaveChildrenClub()){
            return hotel.isChildrenClub();
        }
        if(hotelForm.isHaveNightEntertain()){
            return hotel.isNightEntertainment();
        }
        if(hotelForm.isHavePool()){
            return hotel.isPool();
        }
        if(hotelForm.isHaveRestaurant()){
            return hotel.isRestaurant();
        }
        return true;
    }).collect(Collectors.toList());

    var rooms = (List<Room>) roomRepository.getRoomsByRoomType_HotelIn(hotels);
    var bookedRoomsId = (List<Long>) bookedRoomRepository.getBookedRoomWithinDate(hotelForm.getStartDate(),hotelForm.getEndDate());

    Map<Object, List<Room>> mappedByHotel = rooms.stream().filter(room -> !bookedRoomsId.contains(room.getId())).collect(Collectors.groupingBy(room -> room.getRoomType().getHotel()));
    mappedByHotel.forEach((k,v)-> {
        if(v.size() >= hotelForm.getRoomCount()){
            hotelResult.add((Hotel) k);
        }
    });
    return hotelResult;
}
}



