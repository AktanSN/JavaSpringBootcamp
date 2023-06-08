package com.aktansanhal.weatherfinalcase.result.securityResult;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiError {

    private Map<String, String> validationErrors;



}
