package com.tobeto.hotel_booking_java4a_pair5.core.configurations;

import com.tobeto.hotel_booking_java4a_pair5.core.filters.JwtAuthenticationFilter;
import com.tobeto.hotel_booking_java4a_pair5.entities.Role;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"
    };

    private static final String[] GET_WHITE_LIST_URL = {
            "/api/roomfeedbacks",
            "/api/roomfeedbacks/{getById}",
            "/api/roomtypes",
            "/api/roomtypes/{getById}",
            "/api/rooms",
            "/api/rooms/{getById}",
            "/api/roombooked",
            "/api/roombooked/{getById}",
            "/api/paymentmethods",
            "/api/paymentmethods/{getById}",
            "/api/countries",
            "/api/countries/{getById}",
            "/api/cities",
            "/api/cities/{getById}",
            "/api/districts",
            "/api/districts/{getById}",
            "/api/areas",
            "/api/areas/{getById}",
            "/api/neighborhoods",
            "/api/neighborhoods/{getById}",
            "/api/hotels",
            "/api/hotels/{getById}",
            "/api/hotels/star",
            "/api/hotels/searchByName",
            "/api/hotels/location",
            "/api/hotelreviews",
            "/api/hotelreviews/{getById}",
            "/api/bookings",
            "/api/bookings/{getById}",
            "/api/addresses/{getById}",
            "/api/guests/**"
    };
    private static final String[] GET_ADMIN_URL = {
            "/api/supports",
            "/api/supports/{getById}",
            "/api/managers",
            "/api/managers/{getById}",
            "/api/users",
            "/api/users/{getById}",
            "/api/guests",
            "/api/guests/{getById}",
            "/api/addresses",
    };
    private static final String[] POST_WHITE_LIST_URL = {
            "/api/supports",
            "/api/guests",
            "/api/v1/auth/register",
            "/api/v1/auth/login"
    };
    private static final String[] POST_GUEST_MANAGER_ADMIN = {
            "/api/roomfeedbacks",
            "/api/roombooked",
            "/api/paymentbycards",
            "/api/hotelreviews",
            "/api/bookings/**",
            "/api/addresses"
    };
    private static final String[] POST_MANAGER_ADMIN = {
            "/api/rooms",
            "/api/managers",
            "/api/hotels",
    };
    private static final String[] POST_ADMIN = {
            "/api/roomtypes",
            "/api/paymentmethods",
            "/api/countries",
            "/api/cities",
            "/api/districts",
            "/api/areas",
            "/api/neighborhoods",
    };
    private static final String[] PUT_WHITE_LIST_URL = {
            "/api/v1/auth/register",
            "/api/v1/auth/login"
    };
    private static final String[] PUT_GUEST_MANAGER_ADMIN = {
            "/api/paymentbycards",
            "/api/bookings",
            "/api/addresses"
    };
    private static final String[] PUT_MANAGER_ADMIN = {
            "/api/roomfeedbacks",
            "/api/rooms",
            "/api/managers",
            "/api/hotels",
    };
    private static final String[] PUT_ADMIN = {
            "/api/roombooked",
            "/api/hotelreviews",
            "/api/roomtypes",
            "/api/paymentmethods",
            "/api/countries",
            "/api/cities",
            "/api/districts",
            "/api/areas",
            "/api/neighborhoods",
    };
    private static final String[] PUT_GUEST_ADMIN = {
            "/api/guests"
    };
    private static final String[] DELETE_MANAGER_ADMIN = {
            "/api/hotels",
            "/api/bookings",
            "/api/roomimages/**",
            "/api/hotelimages/**"
    };
    private static final String[] DELETE_WHITE_LIST_URL = {
            "/api/users/address",
            "/api/users/card"
    };
    private static final String[] DELETE_ADMIN = {
            "/api/**"
            /* "/api/rooms",
            "/api/roombooked",
            "/api/hotelreviews",
            "/api/roomtypes",
            "/api/paymentmethods",
            "/api/countries",
            "/api/cities",
            "/api/districts",
            "/api/areas",
            "/api/neighborhoods",
            */
    };
    private static final String[] PATCH_ADMIN = {
            "/api/hotels",
            "/api/managers",
            "/api/supports"
    };
    private static final String[] PATCH_MANAGER_ADMIN = {
            "/api/roomfeedbacks",
            "/api/bookings/{id}/checkindate",
            "/api/bookings/{id}/checkoutdate",
            "/api/bookings/{id}/reservationstatus"
    };

    private final UserService userService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.GET, GET_WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.GET, GET_ADMIN_URL).hasAnyAuthority(Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.POST, POST_WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.POST, POST_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.POST, POST_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority())
                                .requestMatchers(HttpMethod.POST, POST_GUEST_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority(), Role.GUEST.getAuthority())
                                .requestMatchers(HttpMethod.PUT, PUT_WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.PUT, PUT_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.PUT, PUT_GUEST_ADMIN).hasAnyAuthority(Role.GUEST.getAuthority(), Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.PUT, PUT_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority())
                                .requestMatchers(HttpMethod.PUT, PUT_GUEST_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority(), Role.GUEST.getAuthority())
                                .requestMatchers(HttpMethod.DELETE, DELETE_WHITE_LIST_URL).permitAll()
                                .requestMatchers(HttpMethod.DELETE, DELETE_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.DELETE, DELETE_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority())
                                .requestMatchers(HttpMethod.PATCH, PATCH_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority())
                                .requestMatchers(HttpMethod.PATCH, PATCH_MANAGER_ADMIN).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.MANAGER.getAuthority())
                                .anyRequest().permitAll()
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .exceptionHandling(eh -> eh.authenticationEntryPoint(new CustomAuthenticationFailureHandler()))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
