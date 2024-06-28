package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingDateResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.FindHotelWithAvailableRoomsResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.SearchByBookingDateHotelsResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature.GetAllHotelFeaturesByHotelIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetImageUrlsOfHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetImageUrlsOfRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomForHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeaturesByRoomTypeIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HotelsController {
    private HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddHotelRequest request) {
        hotelService.add(request);

        return new SuccessResponse(HotelMessages.HOTEL_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateHotelRequest request) {
        hotelService.update(request);

        return new SuccessResponse(HotelMessages.HOTEL_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        hotelService.delete(id);

        return new SuccessResponse(HotelMessages.HOTEL_DELETED);
    }

    @GetMapping
    public DataResponse<List<FindHotelWithAvailableRoomsResponse>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        List<FindHotelWithAvailableRoomsResponse> findHotelWithAvailableRoomsResponseList = new ArrayList<>();

        for (Hotel hotel : hotels) {
            //Map Struct Auto Mapping
            FindHotelWithAvailableRoomsResponse findHotelWithAvailableRoomsResponse = HotelMapper.INSTANCE.findHotelResponseFromHotelResponse(hotel);

            //Hotel Features Manual&Auto Mapping
            List<HotelFeature> hotelFeatures = hotel.getHotelFeatures();
            List<GetAllHotelFeaturesByHotelIdResponse> getAllHotelFeaturesByHotelIdResponseList = HotelFeatureMapper.INSTANCE.getAllHotelFeaturesByHotelIdFromHotelFeatureList(hotelFeatures);
            findHotelWithAvailableRoomsResponse.setHotelFeatures(getAllHotelFeaturesByHotelIdResponseList);

            //Rooms Manual&Auto Mapping
            List<GetByIdRoomForHotelResponse> getByIdRoomForHotelResponseList = RoomMapper.INSTANCE.getByIdRoomForHotelResponseFromRoomList(hotel.getRooms());

            for (int i = 0; i < hotel.getRooms().size(); i++) {
                //Room Images Manual&Auto Mapping
                List<RoomImage> roomImages = hotel.getRooms().get(i).getRoomImages();
                List<GetImageUrlsOfRoomResponse> getImageUrlsOfRoomResponseList = RoomImageMapper.INSTANCE.getImagesUrlOfHotelResponseListFromHotelImages(roomImages);
                getByIdRoomForHotelResponseList.get(i).setImageUrls(getImageUrlsOfRoomResponseList);

                //Room Type Features Manual&Auto Mapping
                List<RoomTypeFeature> features = hotel.getRooms().get(i).getRoomType().getRoomTypeFeatures();
                List<GetAllRoomTypeFeaturesByRoomTypeIdResponse> featuresResponse = RoomTypeFeatureMapper.INSTANCE.GetAllRoomTypeFeaturesByRoomTypeIdResponseList(features);
                getByIdRoomForHotelResponseList.get(i).getRoomType().setFeatures(featuresResponse);
            }

            findHotelWithAvailableRoomsResponse.setRooms(getByIdRoomForHotelResponseList);

            //Images Manual&Auto Mapping
            List<HotelImage> hotelImages = hotel.getHotelImages();
            List<GetImageUrlsOfHotelResponse> urls = HotelImageMapper.INSTANCE.getImagesUrlOfHotelResponseListFromHotelImages(hotelImages);
            findHotelWithAvailableRoomsResponse.setHotelImageUrls(urls);

            findHotelWithAvailableRoomsResponseList.add(findHotelWithAvailableRoomsResponse);
        }

        return new SuccessDataResponse<>(findHotelWithAvailableRoomsResponseList, HotelMessages.HOTEL_LISTED);
    }

    /*
    @GetMapping("/findHotelWithAvailableRooms")
    public DataResponse<FindHotelWithAvailableRoomsResponse> findHotelWithAvailableRooms(@RequestParam Integer hotelId) {
        Hotel hotel = hotelService.findHotelWithAvailableRooms(hotelId);
        FindHotelWithAvailableRoomsResponse findHotelWithAvailableRoomsResponse = HotelMapper.INSTANCE.findHotelResponseFromHotelResponse(hotel);

        List<HotelFeature> hotelFeatures = hotel.getHotelFeatures();
        List<GetAllHotelFeaturesByHotelIdResponse> getAllHotelFeaturesByHotelIdResponseList = HotelFeatureMapper.INSTANCE.getAllHotelFeaturesByHotelIdFromHotelFeatureList(hotelFeatures);
        findHotelWithAvailableRoomsResponse.setHotelFeatures(getAllHotelFeaturesByHotelIdResponseList);

        List<GetByIdRoomForHotelResponse> getByIdRoomForHotelResponseList = RoomMapper.INSTANCE.getByIdRoomForHotelResponseFromRoomList(hotel.getRooms());
        findHotelWithAvailableRoomsResponse.setRooms(getByIdRoomForHotelResponseList);

        return new SuccessDataResponse<>(findHotelWithAvailableRoomsResponse, HotelMessages.HOTEL_LISTED);
    }
    */

    @GetMapping("/{getById}")
    public DataResponse<GetByIdHotelResponse> getById(@PathVariable Integer getById) {
        Hotel hotel = hotelService.getById(getById);
        GetByIdHotelResponse getByIdHotelResponse = HotelMapper.INSTANCE.getByIdHotelResponse(hotel);

        return new SuccessDataResponse<>(getByIdHotelResponse, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByName")
    public DataResponse<List<GetAllHotelResponse>> searchByName(@RequestParam String name) {
        List<Hotel> hotels = hotelService.searchByHotelName(name);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByLocation")
    public DataResponse<List<GetAllHotelResponse>> searchByLocation(@RequestParam String location) {
        List<Hotel> hotels = hotelService.searchByLocation(location);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByStarRating")
    public DataResponse<List<GetAllHotelResponse>> searchByStarRating(@RequestParam int starRating) {
        List<Hotel> hotels = hotelService.searchByStarRating(starRating);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByPrice")
    public DataResponse<List<GetAllHotelResponse>> searchByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Hotel> hotels = hotelService.searchByPrice(minPrice, maxPrice);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByRoomCapacityHotels")
    public DataResponse<FindHotelWithAvailableRoomsResponse> searchByRoomCapacityHotels(@RequestParam int person) {
        Hotel hotel = hotelService.searchByRoomCapacityHotels(person);
        FindHotelWithAvailableRoomsResponse findHotelWithAvailableRoomsResponse = HotelMapper.INSTANCE.findHotelResponseFromHotelResponse(hotel);

        List<Room> rooms = hotel.getRooms();
        List<GetByIdRoomForHotelResponse> getByIdRoomForHotelResponseList = RoomMapper.INSTANCE.getByIdRoomForHotelResponseFromRoomList(hotel.getRooms());
        findHotelWithAvailableRoomsResponse.setRooms(getByIdRoomForHotelResponseList);

        return new SuccessDataResponse<>(findHotelWithAvailableRoomsResponse, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByDate")
    public DataResponse<SearchByBookingDateHotelsResponse> searchByDate(@RequestParam LocalDate startDate, LocalDate endDate) {
        Hotel hotel = hotelService.searchByBookingDateHotelsResponse(startDate, endDate);
        SearchByBookingDateHotelsResponse searchByBookingDateHotelsResponse = HotelMapper.INSTANCE.searchByBookingDateFromHotelResponse(hotel);

        List<Booking> bookings = hotel.getBookings();
        List<GetAllBookingDateResponse> getAllBookingDateResponseList = BookingMapper.INSTANCE.getAllBookingDateResponseListFromBookings(bookings);
        searchByBookingDateHotelsResponse.setBooking(getAllBookingDateResponseList);

        return new SuccessDataResponse<>(searchByBookingDateHotelsResponse, HotelMessages.HOTEL_LISTED);
    }
}
