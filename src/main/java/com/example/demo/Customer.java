package com.example.demo;/**
 * Created by TUTEHUB on 2021/7/2 6:09 PM.
 * Copyright © 2021 TUTEHUB. All rights reserved.
 * ------------------------
 * Non-disclosure Terms
 * -------------------------
 * These codes are TUTEHUB's property, as the developer, such as employee, contractor, and intern, working for TUTEHUB cannot disclose, spread, copy, preserve, sell, and do other activities without the consent of TUTEHUB.
 * Developer dph agrees with above terms.
 * Technique Support: jobyme88.com
 * Contact: noreply@fengcaoculture.com
 */


import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description
 */
@Data
public class Customer {
    private String id;
    private String telephone;
    private List<String> favorites;
    private Map<String, Boolean> communicationPreferences;

    // standard getters and setters
}