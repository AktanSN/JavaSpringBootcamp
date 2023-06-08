package com.aktansanhal.weatherfinalcase.controller.contract.Impl;

import com.aktansanhal.weatherfinalcase.dto.requests.CityRequestDTO;
import com.aktansanhal.weatherfinalcase.dto.responses.CityResponseDTO;
import com.aktansanhal.weatherfinalcase.entity.City;
import com.aktansanhal.weatherfinalcase.entity.User;
import com.aktansanhal.weatherfinalcase.kafka.ProducerService;
import com.aktansanhal.weatherfinalcase.mapper.CityMapper;
import com.aktansanhal.weatherfinalcase.service.concretes.CityServiceImpl;
import com.aktansanhal.weatherfinalcase.service.concretes.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CityControllerContractImplTest {

    @Mock
    private CityMapper cityMapper;

    @Mock
    private CityServiceImpl cityServiceImpl;

    @Mock
    private ProducerService producerService;

    @Mock
    private UserServiceImpl userServiceImpl;

    @InjectMocks
    private CityControllerContractImpl cityController;

    @Test
    void saveCity_ValidRequest_ReturnCityResponseDTO() {
        // Arrange
        CityRequestDTO requestDTO = new CityRequestDTO("Istanbul",1L,"25","2023-06-08 01:15:26.486529","01d");


        User user = new User();
        user.setId(1L);

        City city = new City();
        city.setId(1L);
        city.setUser(user);

        CityResponseDTO expectedResponse = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(userServiceImpl.findById(anyLong())).thenReturn(Optional.of(user));
        Mockito.when(cityMapper.toCity(any(CityRequestDTO.class))).thenReturn(city);
        Mockito.when(cityServiceImpl.save(any(City.class))).thenReturn(city);
        Mockito.when(cityMapper.toCityResponseDTO(any(City.class))).thenReturn(expectedResponse);

        // Act
        CityResponseDTO responseDTO = cityController.saveCity(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(expectedResponse.id(), responseDTO.id());
        // Diğer özellikleri de kontrol edebilirsiniz.
    }

    @Test
    void getAllCities_CitiesExist_ReturnCityResponseDTOList() {
        // Arrange
        City city1 = new City();
        city1.setId(1L);

        City city2 = new City();
        city2.setId(2L);

        List<City> cities = Arrays.asList(city1, city2);

        CityResponseDTO responseDTO1 = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        CityResponseDTO responseDTO2 = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(cityServiceImpl.findAll()).thenReturn(cities);
        Mockito.when(cityMapper.toCityResponseDTO(city1)).thenReturn(responseDTO1);
        Mockito.when(cityMapper.toCityResponseDTO(city2)).thenReturn(responseDTO2);

        // Act
        List<CityResponseDTO> responseDTOList = cityController.getAllCities();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
        // Diğer özellikleri de kontrol edebilirsiniz.
    }

    @Test
    void getCityById_ValidId_ReturnCityResponseDTO() {
        // Arrange
        Long cityId = 1L;

        City city = new City();
        city.setId(cityId);

        CityResponseDTO expectedResponse = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(cityServiceImpl.findById(anyLong())).thenReturn(Optional.of(city));
        Mockito.when(cityMapper.toCityResponseDTO(city)).thenReturn(expectedResponse);

        // Act
        CityResponseDTO responseDTO = cityController.getCityById(cityId);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(expectedResponse.id(), responseDTO.id());
        // Diğer özellikleri de kontrol edebilirsiniz.
    }

    @Test
    void getCitiesByUserId_ValidUserId_ReturnCityResponseDTOList() {
        // Arrange
        Long userId = 1L;

        User user = new User();
        user.setId(userId);

        City city1 = new City();
        city1.setId(1L);
        city1.setUser(user);

        City city2 = new City();
        city2.setId(2L);
        city2.setUser(user);

        List<City> cities = Arrays.asList(city1, city2);

        CityResponseDTO responseDTO1 = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        CityResponseDTO responseDTO2 = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(userServiceImpl.findById(anyLong())).thenReturn(Optional.of(user));
        Mockito.when(cityServiceImpl.findByUserId(city1.getUser().getId())).thenReturn(cities);
        Mockito.when(cityMapper.toCityResponseDTO(city1)).thenReturn(responseDTO1);
        Mockito.when(cityMapper.toCityResponseDTO(city2)).thenReturn(responseDTO2);

        // Act
        List<CityResponseDTO> responseDTOList = cityController.getCitiesByUserId(userId);

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
        // Diğer özellikleri de kontrol edebilirsiniz.
    }

    @Test
    void updateCity_ValidRequest_ReturnCityResponseDTO() {
        // Arrange
        Long cityId = 1L;

        CityRequestDTO requestDTO = new CityRequestDTO("Istanbul",1L,"25","2023-06-08 01:15:26.486529","01d");


        User user = new User();
        user.setId(1L);

        City city = new City();
        city.setId(cityId);
        city.setUser(user);

        CityResponseDTO expectedResponse = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(userServiceImpl.findById(anyLong())).thenReturn(Optional.of(user));
        Mockito.when(cityServiceImpl.findById(anyLong())).thenReturn(Optional.of(city));
        Mockito.when(cityMapper.toCity(any(CityRequestDTO.class))).thenReturn(city);
        Mockito.when(cityServiceImpl.save(any(City.class))).thenReturn(city);
        Mockito.when(cityMapper.toCityResponseDTO(any(City.class))).thenReturn(expectedResponse);

        // Act
        CityResponseDTO responseDTO = cityController.updateCity(cityId, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(expectedResponse.id(), responseDTO.id());
        // Diğer özellikleri de kontrol edebilirsiniz.
    }

    @Test
    void deleteCity_ValidId_ReturnSuccessMessage() {
        // Arrange
        Long cityId = 1L;

        City city = new City(1L,"ankara","25","2023-06-08 01:15:26.486529","01d",null);

        city.setId(cityId);

        CityResponseDTO expectedResponse = new CityResponseDTO(1L,"Istanbul","25","2023-06-08 01:15:26.486529","01d",null);


        Mockito.when(cityServiceImpl.findById(anyLong())).thenReturn(Optional.of(city));
        Mockito.doNothing().when(cityServiceImpl).delete(anyLong());
        Mockito.when(cityMapper.toCityResponseDTO(city)).thenReturn(expectedResponse);

        // Act
        CityResponseDTO responseDTO = cityController.deleteCityById(cityId);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(expectedResponse.id(), responseDTO.id());
        // Diğer özellikleri de kontrol edebilirsiniz.
        Mockito.verify(producerService, Mockito.times(2)).sendMessage(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(cityServiceImpl, Mockito.times(1)).findById(cityId);
        Mockito.verify(cityServiceImpl, Mockito.times(1)).delete(cityId);
        Mockito.verify(cityMapper, Mockito.times(1)).toCityResponseDTO(city);
    }
}