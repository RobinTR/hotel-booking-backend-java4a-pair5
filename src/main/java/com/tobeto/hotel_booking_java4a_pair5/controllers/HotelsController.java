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
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetAllRoomFeaturesByRoomIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

                //Room Features Manual&Auto Mapping
                List<RoomFeature> features = hotel.getRooms().get(i).getRoomFeatures();
                List<GetAllRoomFeaturesByRoomIdResponse> featuresResponse = RoomFeatureMapper.INSTANCE.GetAllRoomFeaturesByRoomIdResponseList(features);
                getByIdRoomForHotelResponseList.get(i).setFeatures(featuresResponse);
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
    public DataResponse<List<FindHotelWithAvailableRoomsResponse>> searchByRoomCapacityHotels(@RequestParam int person) {
        List<Hotel> hotels = hotelService.searchByRoomCapacityHotels(person);
        List<FindHotelWithAvailableRoomsResponse> findHotelWithAvailableRoomsResponseList = new ArrayList<>();

        for (Hotel hotel : hotels) {
            FindHotelWithAvailableRoomsResponse findHotelWithAvailableRoomsResponse = HotelMapper.INSTANCE.findHotelResponseFromHotelResponse(hotel);

            List<GetByIdRoomForHotelResponse> getByIdRoomForHotelResponseList = RoomMapper.INSTANCE.getByIdRoomForHotelResponseFromRoomList(
                    hotel.getRooms().stream()
                            .filter(room -> room.getRoomType().getCapacity() == person)
                            .collect(Collectors.toList())
            );

            findHotelWithAvailableRoomsResponse.setRooms(getByIdRoomForHotelResponseList);
            findHotelWithAvailableRoomsResponseList.add(findHotelWithAvailableRoomsResponse);
        }

        return new SuccessDataResponse<>(findHotelWithAvailableRoomsResponseList, HotelMessages.HOTEL_LISTED);
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

    @GetMapping("/searchByRoomFilters")
    public DataResponse<List<FindHotelWithAvailableRoomsResponse>> searchByRoomFilters(@RequestParam Integer hotelId,
                                                   @RequestParam(required = false) LocalDate startDate,
                                                   @RequestParam(required = false) LocalDate endDate,
                                                   @RequestParam(required = false) Integer roomCapacity) {
        List<Hotel> hotels = hotelService.searchHotelByRoomWithFilters(hotelId, startDate, endDate, roomCapacity);
        List<FindHotelWithAvailableRoomsResponse> response = HotelMapper.INSTANCE.findHotelResponseFromHotelResponseList(hotels);

        for (int i = 0; i < hotels.size(); i++) {
            List<GetAllHotelFeaturesByHotelIdResponse> hotelFeatures = HotelFeatureMapper.INSTANCE.getAllHotelFeaturesByHotelIdFromHotelFeatureList(hotels.get(i).getHotelFeatures());
            List<GetImageUrlsOfHotelResponse> imageUrlsOfHotelResponseList = HotelImageMapper.INSTANCE.getImagesUrlOfHotelResponseListFromHotelImages(hotels.get(i).getHotelImages());
            response.get(i).setHotelFeatures(hotelFeatures);
            response.get(i).setHotelImageUrls(imageUrlsOfHotelResponseList);

            for (int j = 0; j < response.get(i).getRooms().size(); j++) {
                List<RoomImage> roomImages = hotels.get(i).getRooms().get(j).getRoomImages();
                List<GetImageUrlsOfRoomResponse> getImageUrlsOfRoomResponseList = RoomImageMapper.INSTANCE.getImagesUrlOfHotelResponseListFromHotelImages(roomImages);
                response.get(i).getRooms().get(j).setImageUrls(getImageUrlsOfRoomResponseList);

                List<RoomFeature> roomFeatures = hotels.get(i).getRooms().get(j).getRoomFeatures();
                List<GetAllRoomFeaturesByRoomIdResponse> getAllRoomFeaturesByRoomIdResponseList = RoomFeatureMapper.INSTANCE.GetAllRoomFeaturesByRoomIdResponseList(roomFeatures);
                response.get(i).getRooms().get(j).setFeatures(getAllRoomFeaturesByRoomIdResponseList);
            }
        }

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }
}
