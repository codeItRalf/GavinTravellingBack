package com.gavintravelling.app.rest;

import com.gavintravelling.app.repository.BookedRoomRepository;
import com.gavintravelling.app.repository.HotelRepository;
import com.gavintravelling.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/search")
public class SearchController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private HotelRepository hotelRepository;

//
//    EquivalentToday at 8:26 AM
//    Jag visade ju er ett alternativ (ModelAttribute elr liknande heter det)
//    LajtToday at 8:26 AM
//    Gjorde du ?
//    EquivalentToday at 8:26 AM
//    där man packar ihop alla dessa variabler till 1 enda stort objekt
//    LajtToday at 8:27 AM
//            Aha
//    Börjar känna igen det
//    EquivalentToday at 8:27 AM
//    Övrigt: man behöver skapa en klass som innehåller alla dessa variabler med såklart.
//    LajtToday at 8:28 AM
//    Okej, behöver man skapa en liknande view med i SQL?
//    EquivalentToday at 8:28 AM
//            nä
//    sql har inget att göra med Springs: Controller-klasser
//    Det är bara repository som länkar ihop Databasen med Java


}
